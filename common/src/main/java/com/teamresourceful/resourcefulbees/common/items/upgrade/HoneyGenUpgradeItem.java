package com.teamresourceful.resourcefulbees.common.items.upgrade;

import net.minecraft.world.item.Item;

public class HoneyGenUpgradeItem extends Item implements Upgrade {

    private final UpgradeType upgradeType;

    public HoneyGenUpgradeItem(Properties arg, UpgradeType upgradeType) {
        super(arg);
        this.upgradeType = upgradeType;
    }

    @Override
    public UpgradeType getUpgradeType() {
        return upgradeType;
    }
}
