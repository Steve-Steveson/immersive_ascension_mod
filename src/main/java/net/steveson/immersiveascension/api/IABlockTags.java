package net.steveson.immersiveascension.api;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class IABlockTags {
    private IABlockTags() {

    }
        public static final TagKey<Block> STAIRS_SHEETMETAL = createTag("sheetmetal_stairs");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
    }
}
