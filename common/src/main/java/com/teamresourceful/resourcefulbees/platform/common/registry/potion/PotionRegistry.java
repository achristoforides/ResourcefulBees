package com.teamresourceful.resourcefulbees.platform.common.registry.potion;

import com.teamresourceful.resourcefulbees.platform.NotImplementedError;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class PotionRegistry {

    @ExpectPlatform
    public static void registerItemRecipe(@NotNull Item from, @NotNull Ingredient ingredient, @NotNull Item to) {
        throw new NotImplementedError();
    }

    @ExpectPlatform
    public static void registerPotionRecipe(@NotNull Potion from, @NotNull Ingredient ingredient, @NotNull Potion to) {
        throw new NotImplementedError();
    }

}
