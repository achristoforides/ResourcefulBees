package com.teamresourceful.resourcefulbees.common.menus;

import com.teamresourceful.resourcefulbees.common.blockentities.BreederBlockEntity;
import com.teamresourceful.resourcefulbees.common.lib.constants.BreederConstants;
import com.teamresourceful.resourcefulbees.common.menus.base.ContainerSlot;
import com.teamresourceful.resourcefulbees.common.menus.content.PositionContent;
import com.teamresourceful.resourcefulbees.common.registries.minecraft.ModMenuTypes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class BreederMenu extends AbstractModContainerMenu<BreederBlockEntity> {

    public final ContainerData times;
    public final ContainerData endTimes;

    public BreederMenu(int id, Inventory inv, Optional<PositionContent> content) {
        this(id, inv, PositionContent.getOrNull(content, inv.player.level, BreederBlockEntity.class), new SimpleContainerData(2), new SimpleContainerData(2));
    }

    public BreederMenu(int id, Inventory inv, BreederBlockEntity entity, ContainerData times, ContainerData endTimes) {
        super(ModMenuTypes.BREEDER.get(), id, inv, entity);
        this.times = times;
        this.endTimes = endTimes;
        this.addDataSlots(times);
        this.addDataSlots(endTimes);
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return true;
    }

    @Override
    public int getContainerInputEnd() {
        return 1 + BreederConstants.NUM_OF_BREEDERS * 5;
    }

    @Override
    public int getInventoryStart() {
        return 19 + BreederConstants.NUM_OF_BREEDERS * 5;
    }

    @Override
    public int getPlayerInvXOffset() {
        return 30;
    }

    @Override
    public int getPlayerInvYOffset() {
        return 106;
    }

    @Override
    protected void addMenuSlots() {
        this.addSlot(new ContainerSlot(getEntity(), 0, 6, 18));

        for (int i = 0; i < BreederConstants.NUM_OF_BREEDERS; i++) {
            this.addSlot(new ContainerSlot(getEntity(), BreederConstants.PARENT_1_SLOTS.get(i), 30, 18 +(i *20)));
            this.addSlot(new ContainerSlot(getEntity(), BreederConstants.FEED_1_SLOTS.get(i), 66, 18 +(i*20)));
            this.addSlot(new ContainerSlot(getEntity(), BreederConstants.PARENT_2_SLOTS.get(i), 102, 18 +(i*20)));
            this.addSlot(new ContainerSlot(getEntity(), BreederConstants.FEED_2_SLOTS.get(i), 138, 18 +(i*20)));
            this.addSlot(new ContainerSlot(getEntity(), BreederConstants.EMPTY_JAR_SLOTS.get(i), 174, 18 +(i*20)));
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new ContainerSlot(getEntity(), 11 + (j + i * 9), 30+(j*18), 58 + (i*18)));
            }
        }
    }
}
