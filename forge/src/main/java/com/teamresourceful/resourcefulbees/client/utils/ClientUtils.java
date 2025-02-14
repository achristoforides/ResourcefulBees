package com.teamresourceful.resourcefulbees.client.utils;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.teamresourceful.resourcefulbees.client.util.ClientRenderUtils;
import com.teamresourceful.resourcefulbees.common.lib.tools.UtilityClassError;
import com.teamresourceful.resourcefullib.client.utils.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;

public final class ClientUtils {

    private ClientUtils() {
        throw new UtilityClassError();
    }

    public static void drawFluid(PoseStack matrix, int height, int width, FluidStack fluidStack, int x, int y, int blitOffset) {
        Minecraft mc = Minecraft.getInstance();
        RenderUtils.bindTexture(InventoryMenu.BLOCK_ATLAS);
        IClientFluidTypeExtensions props = IClientFluidTypeExtensions.of(fluidStack.getFluid());
        TextureAtlasSprite sprite = mc.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(props.getStillTexture(fluidStack));
        int remainder = height % 16;
        int splits = (height - remainder) / 16;
        if (remainder != 0) splits++;
        int fluidColor = props.getTintColor(fluidStack);

        RenderSystem.setShaderColor(((fluidColor >> 16) & 0xFF)/ 255.0F, ((fluidColor >> 8) & 0xFF)/ 255.0F, (fluidColor & 0xFF)/ 255.0F,  ((fluidColor >> 24) & 0xFF)/ 255.0F);
        for (int i = 0; i < splits; i++) {
            //TODO figure out why they are still squished
            int splitHeight = (i + 1 == splits && remainder != 0 ? remainder : 16);
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
            bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
            bufferbuilder.vertex(matrix.last().pose(), x, y + (i * 16f) + splitHeight, blitOffset).uv(sprite.getU0(), sprite.getV(width)).endVertex();
            bufferbuilder.vertex(matrix.last().pose(), x + (float)width, y + (i * 16f) + splitHeight, blitOffset).uv(sprite.getU(splitHeight), sprite.getV(width)).endVertex();
            bufferbuilder.vertex(matrix.last().pose(), x + (float)width, y + (i * 16f), blitOffset).uv(sprite.getU(splitHeight), sprite.getV0()).endVertex();
            bufferbuilder.vertex(matrix.last().pose(), x, y + (i * 16f), blitOffset).uv(sprite.getU0(), sprite.getV0()).endVertex();
            BufferUploader.drawWithShader(bufferbuilder.end());
        }
    }

    public static float getDimensionBrightnessAtEyes(Entity entity) {
        float lightLevelAtEyes = entity.level.getRawBrightness(new BlockPos(entity.getEyePosition(1.0F)), 0);
        return lightLevelAtEyes / 15.0F;
    }

    public static void onResourceReload(ModelEvent.BakingCompleted event) {
        ClientRenderUtils.DEFAULT_TEXTURER.clear();
    }
}
