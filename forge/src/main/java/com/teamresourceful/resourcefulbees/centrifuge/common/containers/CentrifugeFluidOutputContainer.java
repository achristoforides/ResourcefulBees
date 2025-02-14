package com.teamresourceful.resourcefulbees.centrifuge.common.containers;

import com.teamresourceful.resourcefulbees.centrifuge.common.blocks.CentrifugeFluidOutput;
import com.teamresourceful.resourcefulbees.centrifuge.common.entities.CentrifugeFluidOutputEntity;
import com.teamresourceful.resourcefulbees.centrifuge.common.helpers.CentrifugeEnergyStorage;
import com.teamresourceful.resourcefulbees.centrifuge.common.registries.CentrifugeMenus;
import com.teamresourceful.resourcefulbees.centrifuge.common.states.CentrifugeState;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import org.jetbrains.annotations.NotNull;

public class CentrifugeFluidOutputContainer extends CentrifugeContainer<CentrifugeFluidOutputEntity> {

    public CentrifugeFluidOutputContainer(int id, Inventory inv, FriendlyByteBuf buffer) {
        this(id, inv, getTileFromBuf(inv.player.level, buffer, CentrifugeFluidOutputEntity.class), new CentrifugeState().deserializeBytes(buffer), dummyEnergyStorageData());
    }

    public CentrifugeFluidOutputContainer(int id, Inventory inv, CentrifugeFluidOutputEntity entity, CentrifugeState state, CentrifugeEnergyStorage energyStorage) {
        super(CentrifugeMenus.CENTRIFUGE_FLUID_OUTPUT_CONTAINER.get(), id, inv, entity, state, energyStorage);
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return entity != null && ContainerLevelAccess.create(level, entity.getBlockPos()).evaluate((world, pos) ->
                world.getBlockState(pos).getBlock() instanceof CentrifugeFluidOutput && player.distanceToSqr(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) <= 64.0D, true);
    }

    @Override
    public int getContainerInputEnd() {
        return 0;
    }

    @Override
    public int getInventoryStart() {
        return 0;
    }


    @Override
    protected void addCentrifugeSlots() {
        //HAS FLUID TANKS
    }
}
