package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.api.IETags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.steveson.immersiveascension.ImmersiveAscensionMod;
import net.steveson.immersiveascension.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ImmersiveAscensionMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.STAIRS)
                .add(ModBlocks.INSULATING_GLASS_STAIRS.get().asItem())
                .add(ModBlocks.SLAG_GLASS_STAIRS.get().asItem())
                .add(ModBlocks.COKE_STAIRS.get().asItem().asItem())
                .add(ModBlocks.COKEBRICK_STAIRS.get().asItem())
                .add(ModBlocks.BLASTBRICK_STAIRS.get().asItem())
                .add(ModBlocks.BLASTBRICK_REINFORCED_STAIRS.get().asItem())
                .add(ModBlocks.ALLOYBRICK_STAIRS.get().asItem())
                .add(ModBlocks.CUT_URANIUM_STAIRS.get().asItem())
                .add(ModBlocks.PILLAR_URANIUM_STAIRS.get().asItem());

        tag(ItemTags.SLABS)
                .add(ModBlocks.SLAG_GLASS_SLAB.get().asItem())
                .add(ModBlocks.CUT_URANIUM_SLAB.get().asItem())
                .add(ModBlocks.PILLAR_URANIUM_SLAB.get().asItem());

        tag(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage))
                .add(ModBlocks.CUT_URANIUM_BLOCK.get().asItem())
                .add(ModBlocks.PILLAR_URANIUM_BLOCK.get().asItem());



    }
}
