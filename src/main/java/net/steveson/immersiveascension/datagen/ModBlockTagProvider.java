package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.api.IETags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.steveson.immersiveascension.ImmersiveAscensionMod;
import net.steveson.immersiveascension.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ImmersiveAscensionMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.INSULATING_GLASS_STAIRS.get())
                .add(ModBlocks.SLAG_GLASS_STAIRS.get())
                .add(ModBlocks.SLAG_GLASS_SLAB.get())

                .add(ModBlocks.CUT_URANIUM_BLOCK.get())
                .add(ModBlocks.CUT_URANIUM_STAIRS.get())
                .add(ModBlocks.CUT_URANIUM_SLAB.get())
                .add(ModBlocks.PILLAR_URANIUM_BLOCK.get())
                .add(ModBlocks.PILLAR_URANIUM_STAIRS.get())
                .add(ModBlocks.PILLAR_URANIUM_SLAB.get());

        tag(BlockTags.STAIRS)
                .add(ModBlocks.INSULATING_GLASS_STAIRS.get())
                .add(ModBlocks.SLAG_GLASS_STAIRS.get())

                .add(ModBlocks.CUT_URANIUM_STAIRS.get())
                .add(ModBlocks.PILLAR_URANIUM_STAIRS.get());

        tag(BlockTags.SLABS)
                .add(ModBlocks.SLAG_GLASS_SLAB.get())
                .add(ModBlocks.CUT_URANIUM_SLAB.get())
                .add(ModBlocks.PILLAR_URANIUM_SLAB.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CUT_URANIUM_BLOCK.get())
                .add(ModBlocks.PILLAR_URANIUM_BLOCK.get());

        tag(IETags.grindingDiskHarvestable)
                .add(ModBlocks.CUT_URANIUM_BLOCK.get())
                .add(ModBlocks.CUT_URANIUM_STAIRS.get())
                .add(ModBlocks.CUT_URANIUM_SLAB.get())
                .add(ModBlocks.PILLAR_URANIUM_BLOCK.get())
                .add(ModBlocks.PILLAR_URANIUM_STAIRS.get())
                .add(ModBlocks.PILLAR_URANIUM_SLAB.get());

        tag(IETags.getTagsFor(EnumMetals.URANIUM).storage)
                .add(ModBlocks.CUT_URANIUM_BLOCK.get())
                .add(ModBlocks.PILLAR_URANIUM_BLOCK.get());
    }
}
