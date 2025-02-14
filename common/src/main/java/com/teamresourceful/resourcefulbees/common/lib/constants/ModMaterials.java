package com.teamresourceful.resourcefulbees.common.lib.constants;

import com.teamresourceful.resourcefulbees.common.lib.tools.UtilityClassError;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public final class ModMaterials {

    public static final Material MATERIAL_HONEY = new Material.Builder(MaterialColor.TERRACOTTA_ORANGE).noCollider().nonSolid().replaceable().liquid().build();

    private ModMaterials() {
        throw new UtilityClassError();
    }
}
