package com.teamresourceful.resourcefulbees.client.screens.beepedia;

import com.teamresourceful.resourcefulbees.ResourcefulBees;
import com.teamresourceful.resourcefulbees.common.lib.tools.UtilityClassError;
import net.minecraft.resources.ResourceLocation;

public final class BeepediaTextures {

    private BeepediaTextures() {
        throw new UtilityClassError();
    }

    public static final ResourceLocation BOOK = new ResourceLocation("textures/item/book.png");
    public static final ResourceLocation TRAIT = new ResourceLocation(ResourcefulBees.MOD_ID, "textures/gui/beepedia/trait_icon.png");
    public static final ResourceLocation HOMEYCOMB = new ResourceLocation("textures/item/honeycomb.png");
    public static final ResourceLocation RECIPE_BOOK = new ResourceLocation("textures/item/knowledge_book.png");
    public static final ResourceLocation HONEY = new ResourceLocation(ResourcefulBees.MOD_ID, "textures/item/catnip_honey_bottle.png");
    public static final ResourceLocation BEE = new ResourceLocation(ResourcefulBees.MOD_ID, "textures/item/bee_jar_filled.png");

    public static final ResourceLocation HUNGER_BAR = new ResourceLocation(ResourcefulBees.MOD_ID, "textures/gui/beepedia/hunger_bar.png");
    public static final ResourceLocation HUNGER = new ResourceLocation(ResourcefulBees.MOD_ID, "textures/gui/beepedia/hunger.png");
    public static final ResourceLocation SATURATION = new ResourceLocation(ResourcefulBees.MOD_ID, "textures/gui/beepedia/saturation.png");

}
