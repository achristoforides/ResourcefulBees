package com.teamresourceful.resourcefulbees.client.models;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.teamresourceful.resourcefulbees.common.lib.constants.ModConstants;
import com.teamresourceful.resourcefulbees.common.lib.tools.UtilityClassError;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.ModelEvent;

import java.util.Map;

public final class ModelHandler {

    private static final Multimap<ResourceLocation, ResourceLocation> MODEL_MAP = LinkedHashMultimap.create();
    private static final String MODEL_INVENTORY_TAG = "inventory";
    private static final String ITEM_MODEL_PATH = "item/models/";
    private static final String JSON_FILE_EXTENSION = ".json";

    private ModelHandler() {
        throw new UtilityClassError();
    }

    private static void registerGenericBlockState(ModelEvent.RegisterAdditional event, RegistryEntry<Block> block, String parentModel, RenderType renderType, ResourceManager resourceManager) {
        if (resourceManager.getResource(new ResourceLocation(ModConstants.MOD_ID, "blockstates/" + block.getId().getPath() + JSON_FILE_EXTENSION)).isEmpty()) {
            block.get().getStateDefinition().getPossibleStates().forEach(state -> {
                String propertyMapString = BlockModelShaper.statePropertiesToString(state.getValues());
                ModelResourceLocation defaultModelLocation = new ModelResourceLocation(parentModel, propertyMapString);
                event.register(defaultModelLocation);
                MODEL_MAP.put(defaultModelLocation, new ModelResourceLocation(block.getId(), propertyMapString));
            });
        }
    }

    private static void registerGenericItem(ModelEvent.RegisterAdditional event, RegistryEntry<Item> item, String parentModel, ResourceManager resourceManager) {
        if (resourceManager.getResource(new ResourceLocation(ModConstants.MOD_ID, ITEM_MODEL_PATH + item.getId().getPath() + JSON_FILE_EXTENSION)).isEmpty()) {
            ModelResourceLocation defaultModelLocation = new ModelResourceLocation(parentModel, MODEL_INVENTORY_TAG);
            event.register(defaultModelLocation);
            MODEL_MAP.put(defaultModelLocation, new ModelResourceLocation(item.getId(), MODEL_INVENTORY_TAG));
        }
    }

    public static void onAddAdditional(ModelEvent.RegisterAdditional event) {
        ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();

        com.teamresourceful.resourcefulbees.common.registries.minecraft.ModItems.HONEYCOMB_ITEMS.getEntries().forEach(comb -> registerGenericItem(event, comb, ModConstants.MOD_ID + ":honeycomb", resourceManager));
        com.teamresourceful.resourcefulbees.common.registries.minecraft.ModItems.HONEYCOMB_BLOCK_ITEMS.getEntries().forEach(combBlock -> registerGenericItem(event, combBlock, ModConstants.MOD_ID + ":honeycomb_block", resourceManager));

        com.teamresourceful.resourcefulbees.common.registries.minecraft.ModItems.HONEY_BLOCK_ITEMS.getEntries().forEach(honeyBlock -> registerGenericItem(event, honeyBlock, ModConstants.MOD_ID + ":honey_block", resourceManager));
        com.teamresourceful.resourcefulbees.common.registries.minecraft.ModItems.HONEY_BUCKET_ITEMS.getEntries().forEach(bucket -> registerGenericItem(event, bucket, ModConstants.MOD_ID + ":custom_honey_fluid_bucket", resourceManager));
        com.teamresourceful.resourcefulbees.common.registries.minecraft.ModItems.HONEY_BOTTLE_ITEMS.getEntries().forEach(bucket -> registerGenericItem(event, bucket, ModConstants.MOD_ID + ":honey_bottle", resourceManager));

        com.teamresourceful.resourcefulbees.common.registries.minecraft.ModItems.SPAWN_EGG_ITEMS.getEntries().forEach(egg -> registerGenericItem(event, egg, "minecraft:template_spawn_egg", resourceManager));

        com.teamresourceful.resourcefulbees.common.registries.minecraft.ModBlocks.HONEYCOMB_BLOCKS.getEntries().forEach(combBlock -> registerGenericBlockState(event, combBlock, ModConstants.MOD_ID + ":honeycomb_block", null, resourceManager));

        com.teamresourceful.resourcefulbees.common.registries.minecraft.ModBlocks.HONEY_BLOCKS.getEntries().forEach(honeyBlock -> registerGenericBlockState(event, honeyBlock, ModConstants.MOD_ID + ":honey_block", RenderType.translucent(), resourceManager));
    }

    public static void onModelBake(ModelEvent.BakingCompleted event) {
        Map<ResourceLocation, BakedModel> modelRegistry = event.getModels();
        BakedModel missingModel = modelRegistry.get(ModelBakery.MISSING_MODEL_LOCATION);
        MODEL_MAP.asMap().forEach(((resourceLocation, resourceLocations) -> {
            BakedModel defaultModel = modelRegistry.getOrDefault(resourceLocation, missingModel);
            resourceLocations.forEach(modelLocation ->
                modelRegistry.computeIfPresent(modelLocation, (resourceLocation1, iBakedModel) -> {
                    if (iBakedModel.getParticleIcon() instanceof MissingTextureAtlasSprite) return defaultModel;
                    return iBakedModel;
                })
            );
        }));
    }
}
