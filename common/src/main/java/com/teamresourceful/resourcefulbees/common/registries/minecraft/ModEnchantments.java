package com.teamresourceful.resourcefulbees.common.registries.minecraft;

import com.teamresourceful.resourcefulbees.common.enchantments.HiveBreakEnchantment;
import com.teamresourceful.resourcefulbees.common.lib.constants.ModConstants;
import com.teamresourceful.resourcefulbees.common.lib.tools.UtilityClassError;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.enchantment.Enchantment;

public final class ModEnchantments {

    private ModEnchantments() {
        throw new UtilityClassError();
    }

    public static final ResourcefulRegistry<Enchantment> ENCHANTMENTS = ResourcefulRegistries.create(Registry.ENCHANTMENT, ModConstants.MOD_ID);

    public static final RegistryEntry<HiveBreakEnchantment> HIVE_BREAK = ENCHANTMENTS.register("hive_break", HiveBreakEnchantment::new);
}
