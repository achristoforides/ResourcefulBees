package com.teamresourceful.resourcefulbees.common.registry.minecraft;

import com.mojang.serialization.Codec;
import com.teamresourceful.resourcefulbees.common.lib.constants.ModConstants;
import com.teamresourceful.resourcefulbees.common.lib.tools.UtilityClassError;
import com.teamresourceful.resourcefulbees.common.world.biome.modifiers.BeeBiomeModifier;
import com.teamresourceful.resourcefulbees.common.world.biome.modifiers.BeeNestBiomeModifier;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBiomeModifiers {

    private ModBiomeModifiers() {
        throw new UtilityClassError();
    }

    public static final DeferredRegister<Codec<? extends BiomeModifier>> MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, ModConstants.MOD_ID);

    public static final RegistryObject<Codec<BeeNestBiomeModifier>> NEST_MODIFIER = MODIFIERS.register("nests", BeeNestBiomeModifier::makeCodec);
    public static final RegistryObject<Codec<BeeBiomeModifier>> SPAWN_MODIFIER = MODIFIERS.register("spawns", BeeBiomeModifier::customBeeCodec);
    public static final RegistryObject<Codec<BeeBiomeModifier>> DEV_SPAWN_MODIFIER = MODIFIERS.register("dev_spawns", BeeBiomeModifier::devBeeCodec);
    public static final RegistryObject<Codec<BeeBiomeModifier>> SUPPORTER_SPAWN_MODIFIER = MODIFIERS.register("supporter_spawns", BeeBiomeModifier::supporterBeeCodec);
}
