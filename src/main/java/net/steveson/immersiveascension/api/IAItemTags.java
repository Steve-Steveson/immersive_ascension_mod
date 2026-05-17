package net.steveson.immersiveascension.api;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class IAItemTags {
    private IAItemTags() {

    }
        public static final TagKey<Item> STAIRS_SHEETMETAL = createTag("sheetmetal_stairs");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
    }
}
