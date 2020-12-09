package com.resourcefulbees.resourcefulbees.api.beedata;

import com.resourcefulbees.resourcefulbees.registry.ItemGroupResourcefulBees;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class HoneyBottleData {

    public static final Logger LOGGER = LogManager.getLogger();

    /**
     * optional: name of the bee
     */
    private String name = null;

    /**
     * hunger replenished when drunk
     */
    private int hunger = 1;

    /**
     * saturation replenished when drunk
     */
    private float saturation = 1.0f;

    /**
     * color of the honey fluid
     */
    private String honeyColor = "#FFFFFF";

    /**
     * optional: defines if honey is rainbow
     */
    private boolean isRainbow = false;

    /**
     * optional: list of effects given by drinking the item
     */
    private List<HoneyEffect> effects;

    /**
     * The RegistryObject of the Honey Bottle Item
     */
    private transient RegistryObject<Item> honeyBottleRegistryObject;

    /**
     * If the ResourcefulBees mod should handle the registration
     */
    public transient boolean shouldResourcefulBeesDoForgeRegistration;


    public int getHoneyBottleColorInt() {
        return com.resourcefulbees.resourcefulbees.utils.color.Color.parseInt(honeyColor);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean hasHoneyColor() {
        return honeyColor != null && !honeyColor.isEmpty();
    }

    public String getHoneyColor() {
        return honeyColor == null ? "#ffffff" : honeyColor;
    }

    public int getHunger() {
        return hunger;
    }

    public float getSaturation() {
        return saturation;
    }

    public boolean isRainbow() {
        return isRainbow;
    }

    public List<HoneyEffect> getEffects() {
        return effects;
    }

    public void setHoneyBottleRegistryObject(RegistryObject<Item> honeyBottleRegistryObject) {
        this.honeyBottleRegistryObject = this.honeyBottleRegistryObject == null ? honeyBottleRegistryObject : this.honeyBottleRegistryObject;
    }

    public RegistryObject<Item> getHoneyBottleRegistryObject() {
        return honeyBottleRegistryObject;
    }

    public Item.Properties getProperties() {
        return new Item.Properties()
                .group(ItemGroupResourcefulBees.RESOURCEFUL_BEES)
                .containerItem(Items.GLASS_BOTTLE)
                .food(getFood())
                .maxStackSize(16);
    }

    private Food getFood() {
        Food.Builder builder = new Food.Builder().hunger(hunger).saturation(saturation);

        if (hasEffects()) {
            effects.forEach(honeyEffect -> {
                builder.effect(() -> honeyEffect.instance, honeyEffect.chance);
            });
        }
        return builder.build();
    }

    private boolean hasEffects() {
        return effects != null && !effects.isEmpty();
    }

    /**
     * effect : generated from the effect id
     * instance : generated from the effect, duration and strength
     * effectID : used to define the effect used
     * duration : duration in ticks of the effect
     * strength : strength of the potion effect
     * chance : chance for effect to proc on drinking honey
     */
    public class HoneyEffect {
        public transient EffectInstance instance;
        public String effectID;
        public int duration = 60;
        public int strength = 1;
        public float chance = 100;

        public HoneyEffect() {
            instance = new EffectInstance(getEffect(), duration, strength);
        }

        public Effect getEffect() {
            ResourceLocation location = new ResourceLocation(effectID);
            LOGGER.info(String.format("Effect found: %s", location.toString()));
            return effectID == null ? null : ForgeRegistries.POTIONS.getValue(location);
        }

        public String getEffectID() {
            return effectID;
        }
    }
}
