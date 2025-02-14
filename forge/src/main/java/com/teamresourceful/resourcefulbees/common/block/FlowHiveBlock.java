package com.teamresourceful.resourcefulbees.common.block;

import com.teamresourceful.resourcefulbees.common.blocks.base.BeeHouseBlock;
import com.teamresourceful.resourcefulbees.common.blockentities.base.BeeHolderBlockEntity;
import com.teamresourceful.resourcefulbees.common.blockentity.FlowHiveBlockEntity;
import com.teamresourceful.resourcefulbees.common.blocks.base.BeeHolderBlock;
import com.teamresourceful.resourcefulbees.common.lib.constants.translations.FlowHiveTranslations;
import com.teamresourceful.resourcefulbees.common.registry.minecraft.ModBlockEntityTypes;
import com.teamresourceful.resourcefulbees.common.utils.FluidUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FlowHiveBlock extends BeeHouseBlock implements BeeHolderBlock {

    public FlowHiveBlock() {
        super(Properties.of(Material.WOOD).strength(5f, 6f).sound(SoundType.WOOD));
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof FlowHiveBlockEntity flowHive) {
            if (!level.isClientSide) {
                Item item = player.getItemInHand(hand).getItem();
                if (item instanceof BottleItem) {
                    FluidUtils.fillBottle(flowHive.getTank(), player, hand);
                } else if (item instanceof HoneyBottleItem) {
                    FluidUtils.emptyBottle(flowHive.getTank(), player, hand);
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.use(state, level, pos, player, hand, hitResult);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> components, @NotNull TooltipFlag flag) {
        components.add(FlowHiveTranslations.INFO.withStyle(ChatFormatting.GOLD));
        components.add(FlowHiveTranslations.HARVEST.withStyle(ChatFormatting.GOLD));
        components.add(FlowHiveTranslations.CAPACITY.withStyle(ChatFormatting.GOLD));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new FlowHiveBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public MenuProvider getMenuProvider(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos) {
        return null;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, ModBlockEntityTypes.FLOW_HIVE_ENTITY.get(), BeeHolderBlockEntity::serverTick);
    }
}
