package com.teamresourceful.resourcefulbees.common.items;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import com.teamresourceful.resourcefulbees.common.entities.entity.ThrownMutatedPollen;
import com.teamresourceful.resourcefulbees.common.lib.constants.BeeConstants;
import com.teamresourceful.resourcefulbees.common.lib.constants.NBTConstants;
import com.teamresourceful.resourcefulbees.common.recipes.MutationRecipe;
import com.teamresourceful.resourcefulbees.common.registries.minecraft.ModItems;
import com.teamresourceful.resourcefullib.common.color.Color;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class MutatedPollenItem extends Item {
    public MutatedPollenItem(Properties arg) {
        super(arg);
    }

    public static ItemStack getPollen(ResourceLocation id, Level level) {
        ItemStack pollen = new ItemStack(ModItems.MUTATED_POLLEN.get());
        MutationRecipe recipe = MutationRecipe.getRecipe(level, id);
        if (recipe == null) return pollen;
        // add data
        CompoundTag tag = new CompoundTag();
        tag.putString(NBTConstants.POLLEN_ID, recipe.id().toString());
        tag.putString(NBTConstants.POLLEN_BASE_COLOR, recipe.getPollenBaseColor().toString());
        tag.putString(NBTConstants.POLLEN_TOP_COLOR, recipe.getPollenTopColor().toString());
        pollen.setTag(tag);
        return pollen;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand usedHand) {
        ItemStack itemStack = player.getItemInHand(usedHand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        player.getCooldowns().addCooldown(this, 5);
        if (!level.isClientSide) {
            ThrownMutatedPollen thrownPollen = new ThrownMutatedPollen(level);
            thrownPollen.setItem(itemStack);
            thrownPollen.setPos(player.getX(), player.getEyeY(), player.getZ());
            thrownPollen.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(thrownPollen);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    public static int getColor(ItemStack stack, int tintIndex) {
        return tintIndex == 0 ? ((MutatedPollenItem) stack.getItem()).getBasePollenColor(stack) : ((MutatedPollenItem) stack.getItem()).getTopPollenColor(stack);
    }

    private int getTopPollenColor(@NotNull ItemStack stack) {
        if (!stack.hasTag() || stack.getTag() == null) return BeeConstants.DEFAULT_POLLEN_TOP_COLOR.getValue();
        DataResult<Color> color = Color.decodeColor(new Dynamic<>(NbtOps.INSTANCE, stack.getTag().get(NBTConstants.POLLEN_TOP_COLOR)));
        return color.result().orElse(BeeConstants.DEFAULT_POLLEN_TOP_COLOR).getValue();
    }

    private int getBasePollenColor(@NotNull ItemStack stack) {
        if (!stack.hasTag() || stack.getTag() == null) return BeeConstants.DEFAULT_POLLEN_BASE_COLOR.getValue();
        DataResult<Color> color = Color.decodeColor(new Dynamic<>(NbtOps.INSTANCE, stack.getTag().get(NBTConstants.POLLEN_BASE_COLOR)));
        return color.result().orElse(BeeConstants.DEFAULT_POLLEN_BASE_COLOR).getValue();
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        if (stack.getTag() != null && stack.getTag().contains(NBTConstants.POLLEN_ID)) {
            tooltip.add(Component.literal("- ").append(Component.translatable(Util.makeDescriptionId("mutation", new ResourceLocation(stack.getTag().getString(NBTConstants.POLLEN_ID))))
                    .withStyle(ChatFormatting.DARK_PURPLE)));
        }
    }
}
