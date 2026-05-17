package net.steveson.immersiveascension.api;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class IAItemTags {
    private IAItemTags() {

    }

    public static final TagKey<Item> STAIRS_SHEETMETAL = tag("sheetmetal_stairs");


    private static TagKey<Item> tag(String name) {
        return ItemTags.create(new ResourceLocation("forge", name));
    }
}
