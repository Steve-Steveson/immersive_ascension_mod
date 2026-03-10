package net.steveson.immersiveascension.api;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ATags {
    private ATags() {

    }

    public static final TagKey<Block> STAIRS_SHEETMETAL = tag("sheetmetal_stairs");


    private static TagKey<net.minecraft.world.level.block.Block> tag(String name) {
        return BlockTags.create(new ResourceLocation("forge", name));
    }
}
