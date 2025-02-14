package com.teamresourceful.resourcefulbees.common.config;

import com.teamresourceful.resourcefulconfig.common.annotations.Category;
import com.teamresourceful.resourcefulconfig.common.annotations.Comment;
import com.teamresourceful.resourcefulconfig.common.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.common.config.EntryType;

@Category(id = "client", translation = "Client")
public final class ClientConfig {

    @ConfigEntry(
        id = "generateEnglishLang",
        type = EntryType.BOOLEAN,
        translation = "Generate English Lang"
    )
    @Comment(
        """
        When set to true an en_us.json file will be generated for the bees. [true/false]
        This file will be overwritten every time the mod loads.
        The generated names are based on the bee jsons.
        This is best used by pack devs as a one-time run.
        """
    )
    public static boolean generateEnglishLang = false;

}
