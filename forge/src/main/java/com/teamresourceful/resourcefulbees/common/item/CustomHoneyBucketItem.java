package com.teamresourceful.resourcefulbees.common.item;

import com.teamresourceful.resourcefulbees.api.data.BeekeeperTradeData;
import com.teamresourceful.resourcefulbees.api.data.honey.fluid.HoneyFluidData;
import com.teamresourceful.resourcefulbees.common.lib.constants.BeeConstants;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class CustomHoneyBucketItem extends BucketItem {

    private final HoneyFluidData data;

    public CustomHoneyBucketItem(Supplier<? extends Fluid> supplier, Properties builder, HoneyFluidData data) {
        super(supplier, builder);
        this.data = data;
    }

    public static int getColor(ItemStack stack, int tintIndex) {
        if (stack.getItem() instanceof CustomHoneyBucketItem bucket && tintIndex == 1) {
            return bucket.getHoneyBucketColor();
        }
        return BeeConstants.DEFAULT_ITEM_COLOR;
    }

    public int getHoneyBucketColor() {
        return data.renderData().color().getValue();
    }

    @Override
    public ICapabilityProvider initCapabilities(@NotNull ItemStack stack, @Nullable CompoundTag nbt) {
        return new FluidBucketWrapper(stack);
    }

    public boolean isTradable() {
        return data.tradeData().isTradable();
    }

    public BeekeeperTradeData getTradeData() {
        return data.tradeData();
    }
}
