package com.teamresourceful.resourcefulbees.platform.common.registry.creativetab.forge;

import com.teamresourceful.resourcefulbees.platform.common.registry.creativetab.CreativeTabBuilder;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CreativeTabBuilderImpl {
    public static CreativeModeTab create(ResourceLocation id, String background, boolean hideScrollBar, boolean hideTitle, Consumer<CreativeTabBuilder.Adder> adder, Supplier<ItemStack> icon, BiConsumer<ItemLike, List<ItemStack>> listingFunction, List<Supplier<ResourcefulRegistry<Item>>> registryItems, boolean dontSearch) {
        CreativeModeTab tab = new CreativeModeTab(String.format("%s.%s", id.getNamespace(), id.getPath())) {
            @Override
            public @NotNull ItemStack makeIcon() {
                return icon.get();
            }

            @Override
            public void fillItemList(@NotNull NonNullList<ItemStack> items) {

                adder.accept(items::add);

                if (!dontSearch) {
                    for (Item item : Registry.ITEM) {
                        item.fillItemCategory(this, items);
                        listingFunction.accept(item, items);
                    }
                }

                registryItems.stream()
                    .map(Supplier::get)
                    .map(ResourcefulRegistry::getEntries)
                    .flatMap(Collection::stream)
                    .map(RegistryEntry::get)
                    .map(ItemStack::new)
                    .forEach(item -> {
                        items.add(item);
                        listingFunction.accept(item.getItem(), items);
                    });
            }
        };
        if (hideScrollBar) tab.hideScroll();
        if (hideTitle) tab.hideTitle();
        if (background != null) tab.setBackgroundSuffix(background);
        return tab;
    }
}
