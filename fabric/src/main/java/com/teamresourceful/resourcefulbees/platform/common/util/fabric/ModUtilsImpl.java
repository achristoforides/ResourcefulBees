package com.teamresourceful.resourcefulbees.platform.common.util.fabric;

import com.teamresourceful.resourcefulbees.common.util.EnumBuilder;
import com.teamresourceful.resourcefulbees.platform.NotImplementedError;
import com.teamresourceful.resourcefulbees.platform.common.events.SpawnBabyEvent;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;

public class ModUtilsImpl {
    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    public static void openEntityInJEI(EntityType<?> entity) {
        throw new NotImplementedError();
    }

    public static MobCategory createMobCategory(String name, String id, int max, boolean isFriendly, boolean isPersistent, int despawnDistance, MobCategory fallback) {
        //TODO REQUIRES EXTENSIVE TESTING AS THIS IS HACKY AF
        try {
            return EnumBuilder.of(MobCategory.class, name)
                    .withArg(String.class, id)
                    .withArg(int.class, max)
                    .withArg(boolean.class, isFriendly)
                    .withArg(boolean.class, isPersistent)
                    .withArg(int.class, despawnDistance)
                    .build();
        }catch (Throwable e) {
            e.printStackTrace();
            return fallback;
        }
    }

    public static void spawnBabyEvent(SpawnBabyEvent event) {
        SpawnBabyEvent.EVENT.fire(event);
        //TODO check for fabric events
    }

    public static boolean isRealPlayer(Player player) {
        return player != null && player.getClass() == ServerPlayer.class;
    }

    public static ResourceKey<? extends Registry<?>> getSpawnDataRegistryKey() {
        throw new NotImplementedError();
    }

    public static void openScreen(Player player, MenuProvider provider, BlockPos pos) {
    }

    public static Explosion.BlockInteraction getExplosionInteraction(Level level, Entity entity) {
        return level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) ? Explosion.BlockInteraction.BREAK : Explosion.BlockInteraction.NONE;
    }
}
