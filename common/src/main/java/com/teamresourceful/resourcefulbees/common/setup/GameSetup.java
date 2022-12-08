package com.teamresourceful.resourcefulbees.common.setup;

import com.teamresourceful.resourcefulbees.common.registries.minecraft.ModPotions;
import com.teamresourceful.resourcefulbees.common.resources.conditions.LoadDevRecipes;
import com.teamresourceful.resourcefulbees.platform.common.registry.potion.PotionRegistry;
import com.teamresourceful.resourcefulbees.platform.common.resources.conditions.ConditionRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

public class GameSetup {

    //TODO Change to common tag for forge and fabric.
    private static final TagKey<Item> HONEY_BOTTLE_TAG = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "honey_bottles"));

    public static void initSerializersAndConditions() {
        ConditionRegistry.registerCondition(new LoadDevRecipes());
    }

    public static void initPotionRecipes() {
        PotionRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(HONEY_BOTTLE_TAG), ModPotions.CALMING_POTION.get());
        PotionRegistry.registerPotionRecipe(ModPotions.CALMING_POTION.get(), Ingredient.of(Items.GLOWSTONE_DUST), ModPotions.LONG_CALMING_POTION.get());
    }
}
