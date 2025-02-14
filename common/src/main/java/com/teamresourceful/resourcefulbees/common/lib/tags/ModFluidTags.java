package com.teamresourceful.resourcefulbees.common.lib.tags;

import com.teamresourceful.resourcefulbees.common.lib.tools.UtilityClassError;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public final class ModFluidTags {
    public static final TagKey<Fluid> HONEY = TagKey.create(Registry.FLUID_REGISTRY, new ResourceLocation("forge", "honey"));

    private ModFluidTags() {
        throw new UtilityClassError();
    }
}
