package com.teamresourceful.resourcefulbees.api.data.trait;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.resourcefulbees.common.lib.enums.DamageTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.apache.commons.lang3.text.WordUtils;
import org.jetbrains.annotations.Nullable;

public record DamageEffect(DamageTypes source, int strength) {

    private static final String[] TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] UNITS = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static final DamageEffect DEFAULT = new DamageEffect(DamageTypes.GENERIC, 0);

    public static final Codec<DamageEffect> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            DamageTypes.CODEC.fieldOf("source").orElse(DamageTypes.GENERIC).forGetter(DamageEffect::source),
            Codec.intRange(0, 20).fieldOf("strength").orElse(0).forGetter(DamageEffect::strength)
    ).apply(instance, DamageEffect::new));

    public DamageSource getDamageSource(@Nullable LivingEntity livingEntity) {
        return source().getSource(livingEntity);
    }

    public Component getDisplayName() {
        return Component.literal(
                String.format("%s %s",
                        WordUtils.capitalizeFully(source.name().replace("_", " ")),
                        TENS[strength % 100 / 10] + UNITS[strength % 10]
                )
        );
    }
}
