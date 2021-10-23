package com.teamresourceful.resourcefulbees.client.gui.widget.beepedia;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.teamresourceful.resourcefulbees.client.gui.tooltip.AbstractTooltip;
import com.teamresourceful.resourcefulbees.client.gui.tooltip.ItemTooltip;
import com.teamresourceful.resourcefulbees.client.gui.tooltip.Tooltip;
import com.teamresourceful.resourcefulbees.client.gui.widget.TooltipWidget;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public class ItemSlot extends EmptySlot {

    private final AbstractTooltip tooltip;
    private final Supplier<ItemStack> stack;

    public ItemSlot(int x, int y, int width, int height, ItemStack stack, ITextComponent tooltip) {
        super(x, y, width, height, tooltip);
        this.tooltip = tooltip == null ? new ItemTooltip(this.x, this.y, this.width, this.height, stack) : new Tooltip(this.x, this.y, this.width, this.height, tooltip);
        this.stack = () -> stack;
        setTooltips(Collections.singletonList(this.tooltip));
    }

    public ItemSlot(int x, int y, ItemStack stack, ITextComponent tooltip) {
        this(x, y, 20, 20, stack, tooltip);
    }

    public ItemSlot(int x, int y, int width, int height, ItemStack stack) {
        this(x, y, width, height, stack, null);
    }

    public ItemSlot(int x, int y, ItemStack stack) {
        this(x, y, 20, 20, stack, null);
    }

    public ItemSlot(int x, int y, int width, int height, Supplier<ItemStack> stack, Supplier<ITextComponent> tooltip) {
        super(x, y, width, height, new StringTextComponent(""));
        this.tooltip = tooltip == null ? new ItemTooltip(this.x, this.y, this.width, this.height, stack) : new Tooltip(this.x, this.y, this.width, this.height, tooltip);
        this.stack = stack;
        setTooltips(Collections.singletonList(this.tooltip));
    }

    public ItemSlot(int x, int y, Supplier<ItemStack> stack, Supplier<ITextComponent> tooltip) {
        this(x, y, 20, 20, stack, tooltip);
    }

    public ItemSlot(int x, int y, int width, int height, Supplier<ItemStack> stack) {
        this(x, y, width, height, stack, null);
    }

    public ItemSlot(int x, int y, Supplier<ItemStack> stack) {
        this(x, y, 20, 20, stack, null);
    }

    @Override
    public void render(@NotNull MatrixStack matrix, int mouseX, int mouseY, float partialTicks) {
        super.render(matrix, mouseX, mouseY, partialTicks);
        renderItemStack(this, stack.get());
    }

    public static void renderItemStack(TooltipWidget widget, ItemStack stack) {
        if (stack == null || stack.getItem() == Items.AIR) return;
        int itemPosX = (widget.getWidth() / 2) - 8;
        int itemPosY = (widget.getHeight() / 2) - 8;

        RenderSystem.disableDepthTest();
        Minecraft.getInstance().getItemRenderer().renderAndDecorateItem(stack, itemPosX, itemPosY);
    }
}
