package com.teamresourceful.resourcefulbees.common.commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import com.teamresourceful.resourcefulbees.ResourcefulBees;
import com.teamresourceful.resourcefulbees.api.beedata.CustomBeeData;
import com.teamresourceful.resourcefulbees.api.beedata.traits.TraitData;
import com.teamresourceful.resourcefulbees.api.honeycombdata.OutputVariation;
import com.teamresourceful.resourcefulbees.api.honeydata.HoneyData;
import com.teamresourceful.resourcefulbees.common.lib.templates.DummyBeeData;
import com.teamresourceful.resourcefulbees.common.lib.templates.DummyHoneyData;
import com.teamresourceful.resourcefulbees.common.lib.templates.DummyHoneycombData;
import com.teamresourceful.resourcefulbees.common.lib.templates.DummyTraitData;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.RegistryOps;

public class TemplateCommand {

    private static final Gson PRETTY_GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String TEMPLATE_STRING = "template";

    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        LiteralArgumentBuilder<CommandSourceStack> builder = Commands.literal(TEMPLATE_STRING);
        builder.then(Commands.literal("bee").requires(stack -> stack.hasPermission(Commands.LEVEL_GAMEMASTERS)).executes(TemplateCommand::printBeeTemplate))
                .then(Commands.literal("honeycomb").requires(stack -> stack.hasPermission(Commands.LEVEL_GAMEMASTERS)).executes(TemplateCommand::printHoneycombTemplate))
                .then(Commands.literal("honey").requires(stack -> stack.hasPermission(Commands.LEVEL_GAMEMASTERS)).executes(TemplateCommand::printHoneyTemplate))
                .then(Commands.literal("trait").requires(stack -> stack.hasPermission(Commands.LEVEL_GAMEMASTERS)).executes(TemplateCommand::printTraitTemplate));
        return builder;
    }

    private static DynamicOps<JsonElement> registryOps(CommandContext<CommandSourceStack> context) {
        return RegistryOps.create(JsonOps.INSTANCE, context.getSource().registryAccess());
    }

    private static int printBeeTemplate(CommandContext<CommandSourceStack> context) {
        DataResult<JsonElement> beeResult = CustomBeeData.codec(TEMPLATE_STRING).encodeStart(registryOps(context), DummyBeeData.DUMMY_CUSTOM_BEE_DATA);
        ResourcefulBees.LOGGER.info(PRETTY_GSON.toJson(beeResult.getOrThrow(false, ResourcefulBees.LOGGER::error)));
        context.getSource().sendSuccess(Component.literal("Bee template printed to logs!"), true);
        return 1;
    }

    private static int printHoneycombTemplate(CommandContext<CommandSourceStack> context) {
        DataResult<JsonElement> variationResult = OutputVariation.CODEC.encodeStart(registryOps(context), DummyHoneycombData.DUMMY_OUTPUT_VARIATION);
        ResourcefulBees.LOGGER.info(PRETTY_GSON.toJson(variationResult.getOrThrow(false, ResourcefulBees.LOGGER::error)));
        context.getSource().sendSuccess(Component.literal("Honeycomb template printed to logs!"), true);
        return 1;
    }

    private static int printHoneyTemplate(CommandContext<CommandSourceStack> context) {
        DataResult<JsonElement> honeyResult = HoneyData.codec(TEMPLATE_STRING).encodeStart(registryOps(context), DummyHoneyData.DUMMY_HONEY_DATA);
        ResourcefulBees.LOGGER.info(PRETTY_GSON.toJson(honeyResult.getOrThrow(false, ResourcefulBees.LOGGER::error)));
        context.getSource().sendSuccess(Component.literal("Honey template printed to logs!"), true);
        return 1;
    }

    private static int printTraitTemplate(CommandContext<CommandSourceStack> context) {
        DataResult<JsonElement> traitResult = TraitData.codec(TEMPLATE_STRING).encodeStart(registryOps(context), DummyTraitData.DUMMY_TRAIT_DATA);
        ResourcefulBees.LOGGER.info(PRETTY_GSON.toJson(traitResult.getOrThrow(false, ResourcefulBees.LOGGER::error)));
        context.getSource().sendSuccess(Component.literal("Trait template printed to logs!"), true);
        return 1;
    }
}
