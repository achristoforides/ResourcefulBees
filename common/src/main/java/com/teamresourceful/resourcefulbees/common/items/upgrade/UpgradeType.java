package com.teamresourceful.resourcefulbees.common.items.upgrade;

public enum UpgradeType {
    BREEDER,
    NEST,
    HONEY_CAPACITY,
    ENERGY_CAPACITY,
    ENERGY_XFER,
    HONEY_CONSUMPTION;

    public boolean isType(UpgradeType type) {
        return this == type;
    }
}
