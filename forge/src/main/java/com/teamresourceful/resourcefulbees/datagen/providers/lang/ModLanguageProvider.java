package com.teamresourceful.resourcefulbees.datagen.providers.lang;

import com.teamresourceful.resourcefulbees.common.lib.constants.translations.*;
import com.teamresourceful.resourcefulbees.common.registries.minecraft.ModEffects;
import com.teamresourceful.resourcefulbees.common.registries.minecraft.ModPotions;
import com.teamresourceful.resourcefulbees.common.registry.minecraft.ItemGroupResourcefulBees;
import com.teamresourceful.resourcefulbees.datagen.bases.BaseLanguageProvider;
import net.minecraft.data.DataGenerator;
import org.jetbrains.annotations.NotNull;

public class ModLanguageProvider extends BaseLanguageProvider {

    public ModLanguageProvider(DataGenerator gen) {
        super(gen,
                ApiaryTranslations.class,
                BeehiveTranslations.class,
                BeeLocatorTranslations.class,
                BeepediaTranslations.class,
                CentrifugeTranslations.class,
                BeeconTranslations.class,
                FakeFlowerTranslations.class,
                FlowHiveTranslations.class,
                GuiTranslations.class,
                HoneyDipperTranslations.class,
                ItemTranslations.class,
                JeiTranslations.class,
                MissingRegistryTranslations.class,
                ModTranslations.class,
                TopTranslations.class
        );
        addModule(new CentrifugeLanguageModule());
        addModule(new AdvancementLanguageModule());
        addModule(new BlockLanguageModule());
        addModule(new BeeLanguageModule());
        addModule(new BookLanguageModule());
        addModule(new ItemLanguageModule());
        addModule(new EnchantmentLanguageModule());
    }

    @Override
    public @NotNull String getName() {
        return "Resourceful Bees Language Provider";
    }

    @Override
    protected void addTranslations() {
        addPotions();
        addItemGroups();
        add("tooltip.resourcefulbees.bee.creator", "§7- %s");
        add("entity.minecraft.villager.resourcefulbees.beekeeper", "Beekeeper");
        super.addTranslations();
    }

    private void addItemGroups() {
        add(ItemGroupResourcefulBees.RESOURCEFUL_BEES, "Resourceful Bees");
        add(ItemGroupResourcefulBees.RESOURCEFUL_BEES_HONEY, "Resourceful Bees - Honey");
        add(ItemGroupResourcefulBees.RESOURCEFUL_BEES_BEES, "Resourceful Bees - Spawn Eggs");
        add(ItemGroupResourcefulBees.RESOURCEFUL_BEES_COMBS, "Resourceful Bees - Combs");
        add(ItemGroupResourcefulBees.RESOURCEFUL_BEES_HIVES, "Resourceful Bees - Hives");
    }

    private void addPotions() {
        addEffect(ModEffects.CALMING, "Calming");
        addPotion(ModPotions.CALMING_POTION, "Calming");
        addPotion(ModPotions.LONG_CALMING_POTION, "Calming");
    }

}
