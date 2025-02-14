package com.teamresourceful.resourcefulbees.centrifuge.common.entities;

import com.teamresourceful.resourcefulbees.common.inventory.AbstractFilterItemHandler;
import com.teamresourceful.resourcefulbees.common.lib.constants.NBTConstants;
import com.teamresourceful.resourcefulbees.centrifuge.common.CentrifugeController;
import com.teamresourceful.resourcefulbees.centrifuge.common.containers.CentrifugeVoidContainer;
import com.teamresourceful.resourcefulbees.centrifuge.common.entities.base.AbstractGUICentrifugeEntity;
import com.teamresourceful.resourcefulbees.centrifuge.common.helpers.CentrifugeTier;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class CentrifugeVoidEntity extends AbstractGUICentrifugeEntity {

    private final FilterInventory filterInventory;

    public CentrifugeVoidEntity(Supplier<BlockEntityType<CentrifugeVoidEntity>> entityType, CentrifugeTier tier, BlockPos pos, BlockState state) {
        super(entityType.get(), tier, pos, state);
        this.filterInventory = new FilterInventory(tier.getSlots() * 2);
    }

    public FilterInventory getFilterInventory() {
        return filterInventory;
    }

    public boolean containsItem(ItemStack stack) {
        return filterInventory.containsItem(stack);
    }

    public boolean containsFluid(FluidStack stack) {
        return filterInventory.containsFluid(stack);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("gui.centrifuge.void." + tier.getName());
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory playerInventory, @NotNull Player playerEntity) {
        CentrifugeController controller = nullableController();
        if (controller == null) return null;
        return new CentrifugeVoidContainer(id, playerInventory, this, centrifugeState, controller.getEnergyStorage());
    }

    //region NBT HANDLING
    @Override
    protected void readNBT(@NotNull CompoundTag tag) {
        filterInventory.deserializeNBT(tag.getCompound(NBTConstants.NBT_INVENTORY));
        super.readNBT(tag);
    }

    @NotNull
    @Override
    protected CompoundTag writeNBT() {
        CompoundTag tag = super.writeNBT();
        tag.put(NBTConstants.NBT_INVENTORY, filterInventory.serializeNBT());
        return tag;
    }
    //endregion


    private static class FilterInventory extends AbstractFilterItemHandler {
        protected FilterInventory(int numSlots) {
            super(numSlots);
        }

        public boolean containsItem(ItemStack stack) {
            for (ItemStack slotStack : stacks) {
                if (ItemStack.isSameItemSameTags(stack, slotStack)) return true;
            }
            return false;
        }

        public boolean containsFluid(FluidStack stack) {
            for (ItemStack slotStack : stacks) {
                if (stack.isFluidEqual(slotStack)) return true;
            }
            return false;
        }
    }
}
