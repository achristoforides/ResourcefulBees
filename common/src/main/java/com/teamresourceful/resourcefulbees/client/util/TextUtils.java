package com.teamresourceful.resourcefulbees.client.util;

import com.mojang.blaze3d.vertex.PoseStack;
import com.teamresourceful.resourcefulbees.common.lib.constants.ModConstants;
import com.teamresourceful.resourcefulbees.common.lib.tools.UtilityClassError;
import com.teamresourceful.resourcefulbees.mixin.client.FontResourceManagerAccessor;
import com.teamresourceful.resourcefulbees.mixin.client.MinecraftAccessor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public final class TextUtils {

    public static final int FONT_COLOR_1 = 0xffc9c9c9;
    public static final int FONT_COLOR_2 = 0xff2cafc7;
    public static final int FONT_COLOR_3 = 0xffc7bf2c;
    public static final int FONT_COLOR_4 = 0xff3b3b3b;
    private static final FontSet FONT_8 =  ((FontResourceManagerAccessor) ((MinecraftAccessor) Minecraft.getInstance()).getFontManager()).getFontSets().get(new ResourceLocation(ModConstants.MOD_ID, "jetbrains_mono_8"));
    public static final Font TERMINAL_FONT_8 = new Font(resourceLocation -> FONT_8, false); //IDK if this should be true or false tbh
    private static final FontSet FONT_12 =  ((FontResourceManagerAccessor) ((MinecraftAccessor) Minecraft.getInstance()).getFontManager()).getFontSets().get(new ResourceLocation(ModConstants.MOD_ID, "jetbrains_mono_12"));
    public static final Font TERMINAL_FONT_12 = new Font(resourceLocation -> FONT_12, false); //IDK if this should be true or false tbh

    private TextUtils() {
        throw new UtilityClassError();
    }

    public static void drawCenteredStringNoShadow(Font font, PoseStack stack, Component component, float x, float y, int color) {
        font.draw(stack, component, x - halfWidthOfText(font, component), y, color);
    }

    public static void tf8DrawCenteredStringNoShadow(PoseStack stack, Component component, float x, float y, int color) {
        drawCenteredStringNoShadow(TERMINAL_FONT_8, stack, component, x, y, color);
    }

    public static void tf12DrawCenteredStringNoShadow(PoseStack stack, Component component, float x, float y, int color) {
        drawCenteredStringNoShadow(TERMINAL_FONT_12, stack, component, x, y, color);
    }

    public static float halfWidthOfText(Font font, Component component) {
        return font.width(component)/2f;
    }
}
