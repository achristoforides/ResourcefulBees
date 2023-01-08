package com.teamresourceful.resourcefulbees.common.registries.minecraft;

import com.teamresourceful.resourcefulbees.common.items.BeeJarItem;
import com.teamresourceful.resourcefulbees.common.lib.constants.ModConstants;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(Registry.ITEM, ModConstants.MOD_ID);

    public static final ResourcefulRegistry<Item> NEST_ITEMS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> T1_NEST_ITEMS = ResourcefulRegistries.create(NEST_ITEMS);
    public static final ResourcefulRegistry<Item> T2_NEST_ITEMS = ResourcefulRegistries.create(NEST_ITEMS);
    public static final ResourcefulRegistry<Item> T3_NEST_ITEMS = ResourcefulRegistries.create(NEST_ITEMS);
    public static final ResourcefulRegistry<Item> T4_NEST_ITEMS = ResourcefulRegistries.create(NEST_ITEMS);

    //region Nests
    //region Acacia
    public static final RegistryEntry<Item> ACACIA_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/acacia/1", () -> new BlockItem(ModBlocks.ACACIA_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_ACACIA_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/acacia/2", () -> new BlockItem(ModBlocks.T1_ACACIA_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_ACACIA_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/acacia/3", () -> new BlockItem(ModBlocks.T2_ACACIA_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_ACACIA_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/acacia/4", () -> new BlockItem(ModBlocks.T3_ACACIA_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Birch
    public static final RegistryEntry<Item> BIRCH_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/birch/1", () -> new BlockItem(ModBlocks.BIRCH_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_BIRCH_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/birch/2", () -> new BlockItem(ModBlocks.T1_BIRCH_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_BIRCH_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/birch/3", () -> new BlockItem(ModBlocks.T2_BIRCH_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_BIRCH_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/birch/4", () -> new BlockItem(ModBlocks.T3_BIRCH_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Brown Mushr
    public static final RegistryEntry<Item> BROWN_MUSHROOM_NEST_ITEM = T1_NEST_ITEMS.register("nest/brown_mushroom/1", () -> new BlockItem(ModBlocks.BROWN_MUSHROOM_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_BROWN_MUSHROOM_NEST_ITEM = T2_NEST_ITEMS.register("nest/brown_mushroom/2", () -> new BlockItem(ModBlocks.T1_BROWN_MUSHROOM_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_BROWN_MUSHROOM_NEST_ITEM = T3_NEST_ITEMS.register("nest/brown_mushroom/3", () -> new BlockItem(ModBlocks.T2_BROWN_MUSHROOM_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_BROWN_MUSHROOM_NEST_ITEM = T4_NEST_ITEMS.register("nest/brown_mushroom/4", () -> new BlockItem(ModBlocks.T3_BROWN_MUSHROOM_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Crimson
    public static final RegistryEntry<Item> CRIMSON_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/crimson/1", () -> new BlockItem(ModBlocks.CRIMSON_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_CRIMSON_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/crimson/2", () -> new BlockItem(ModBlocks.T1_CRIMSON_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_CRIMSON_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/crimson/3", () -> new BlockItem(ModBlocks.T2_CRIMSON_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_CRIMSON_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/crimson/4", () -> new BlockItem(ModBlocks.T3_CRIMSON_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Crimson Nyl
    public static final RegistryEntry<Item> CRIMSON_NYLIUM_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/crimson_nylium/1", () -> new BlockItem(ModBlocks.CRIMSON_NYLIUM_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_CRIMSON_NYLIUM_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/crimson_nylium/2", () -> new BlockItem(ModBlocks.T1_CRIMSON_NYLIUM_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_CRIMSON_NYLIUM_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/crimson_nylium/3", () -> new BlockItem(ModBlocks.T2_CRIMSON_NYLIUM_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_CRIMSON_NYLIUM_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/crimson_nylium/4", () -> new BlockItem(ModBlocks.T3_CRIMSON_NYLIUM_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Dark Oak
    public static final RegistryEntry<Item> DARK_OAK_NEST_ITEM = T1_NEST_ITEMS.register("nest/dark_oak/1", () -> new BlockItem(ModBlocks.DARK_OAK_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_DARK_OAK_NEST_ITEM = T2_NEST_ITEMS.register("nest/dark_oak/2", () -> new BlockItem(ModBlocks.T1_DARK_OAK_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_DARK_OAK_NEST_ITEM = T3_NEST_ITEMS.register("nest/dark_oak/3", () -> new BlockItem(ModBlocks.T2_DARK_OAK_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_DARK_OAK_NEST_ITEM = T4_NEST_ITEMS.register("nest/dark_oak/4", () -> new BlockItem(ModBlocks.T3_DARK_OAK_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Grass
    public static final RegistryEntry<Item> GRASS_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/grass/1", () -> new BlockItem(ModBlocks.GRASS_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_GRASS_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/grass/2", () -> new BlockItem(ModBlocks.T1_GRASS_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_GRASS_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/grass/3", () -> new BlockItem(ModBlocks.T2_GRASS_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_GRASS_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/grass/4", () -> new BlockItem(ModBlocks.T3_GRASS_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Jungle
    public static final RegistryEntry<Item> JUNGLE_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/jungle/1", () -> new BlockItem(ModBlocks.JUNGLE_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_JUNGLE_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/jungle/2", () -> new BlockItem(ModBlocks.T1_JUNGLE_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_JUNGLE_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/jungle/3", () -> new BlockItem(ModBlocks.T2_JUNGLE_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_JUNGLE_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/jungle/4", () -> new BlockItem(ModBlocks.T3_JUNGLE_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Nether
    public static final RegistryEntry<Item> NETHER_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/netherrack/1", () -> new BlockItem(ModBlocks.NETHER_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_NETHER_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/netherrack/2", () -> new BlockItem(ModBlocks.T1_NETHER_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_NETHER_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/netherrack/3", () -> new BlockItem(ModBlocks.T2_NETHER_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_NETHER_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/netherrack/4", () -> new BlockItem(ModBlocks.T3_NETHER_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Oak
    public static final RegistryEntry<Item> OAK_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/oak/1", () -> new BlockItem(ModBlocks.OAK_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_OAK_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/oak/2", () -> new BlockItem(ModBlocks.T1_OAK_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_OAK_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/oak/3", () -> new BlockItem(ModBlocks.T2_OAK_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_OAK_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/oak/4", () -> new BlockItem(ModBlocks.T3_OAK_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Prismarine
    public static final RegistryEntry<Item> PRISMARINE_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/prismarine/1", () -> new BlockItem(ModBlocks.PRISMARINE_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_PRISMARINE_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/prismarine/2", () -> new BlockItem(ModBlocks.T1_PRISMARINE_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_PRISMARINE_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/prismarine/3", () -> new BlockItem(ModBlocks.T2_PRISMARINE_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_PRISMARINE_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/prismarine/4", () -> new BlockItem(ModBlocks.T3_PRISMARINE_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Purpur
    public static final RegistryEntry<Item> PURPUR_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/chorus/1", () -> new BlockItem(ModBlocks.PURPUR_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_PURPUR_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/chorus/2", () -> new BlockItem(ModBlocks.T1_PURPUR_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_PURPUR_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/chorus/3", () -> new BlockItem(ModBlocks.T2_PURPUR_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_PURPUR_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/chorus/4", () -> new BlockItem(ModBlocks.T3_PURPUR_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Red Mushroo
    public static final RegistryEntry<Item> RED_MUSHROOM_NEST_ITEM = T1_NEST_ITEMS.register("nest/red_mushroom/1", () -> new BlockItem(ModBlocks.RED_MUSHROOM_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_RED_MUSHROOM_NEST_ITEM = T2_NEST_ITEMS.register("nest/red_mushroom/2", () -> new BlockItem(ModBlocks.T1_RED_MUSHROOM_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_RED_MUSHROOM_NEST_ITEM = T3_NEST_ITEMS.register("nest/red_mushroom/3", () -> new BlockItem(ModBlocks.T2_RED_MUSHROOM_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_RED_MUSHROOM_NEST_ITEM = T4_NEST_ITEMS.register("nest/red_mushroom/4", () -> new BlockItem(ModBlocks.T3_RED_MUSHROOM_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Spruce
    public static final RegistryEntry<Item> SPRUCE_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/spruce/1", () -> new BlockItem(ModBlocks.SPRUCE_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_SPRUCE_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/spruce/2", () -> new BlockItem(ModBlocks.T1_SPRUCE_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_SPRUCE_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/spruce/3", () -> new BlockItem(ModBlocks.T2_SPRUCE_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_SPRUCE_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/spruce/4", () -> new BlockItem(ModBlocks.T3_SPRUCE_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Warped
    public static final RegistryEntry<Item> WARPED_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/warped/1", () -> new BlockItem(ModBlocks.WARPED_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_WARPED_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/warped/2", () -> new BlockItem(ModBlocks.T1_WARPED_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_WARPED_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/warped/3", () -> new BlockItem(ModBlocks.T2_WARPED_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_WARPED_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/warped/4", () -> new BlockItem(ModBlocks.T3_WARPED_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Warped Nyli
    public static final RegistryEntry<Item> WARPED_NYLIUM_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/warped_nylium/1", () -> new BlockItem(ModBlocks.WARPED_NYLIUM_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_WARPED_NYLIUM_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/warped_nylium/2", () -> new BlockItem(ModBlocks.T1_WARPED_NYLIUM_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_WARPED_NYLIUM_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/warped_nylium/3", () -> new BlockItem(ModBlocks.T2_WARPED_NYLIUM_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_WARPED_NYLIUM_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/warped_nylium/4", () -> new BlockItem(ModBlocks.T3_WARPED_NYLIUM_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //region Wither
    public static final RegistryEntry<Item> WITHER_BEE_NEST_ITEM = T1_NEST_ITEMS.register("nest/wither/1", () -> new BlockItem(ModBlocks.WITHER_BEE_NEST.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T1_WITHER_BEEHIVE_ITEM = T2_NEST_ITEMS.register("nest/wither/2", () -> new BlockItem(ModBlocks.T1_WITHER_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T2_WITHER_BEEHIVE_ITEM = T3_NEST_ITEMS.register("nest/wither/3", () -> new BlockItem(ModBlocks.T2_WITHER_BEEHIVE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> T3_WITHER_BEEHIVE_ITEM = T4_NEST_ITEMS.register("nest/wither/4", () -> new BlockItem(ModBlocks.T3_WITHER_BEEHIVE.get(), new Item.Properties()));
    //endregion
    //endregion

    public static final RegistryEntry<Item> BEE_JAR = ITEMS.register("bee_jar", () -> new BeeJarItem(new Item.Properties().durability(0).stacksTo(16)));
}
