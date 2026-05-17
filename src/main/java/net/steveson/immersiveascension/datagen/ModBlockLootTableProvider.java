package net.steveson.immersiveascension.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.steveson.immersiveascension.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.INSULATING_GLASS_STAIRS.get());
        dropSelf(ModBlocks.SLAG_GLASS_STAIRS.get());
        add(ModBlocks.SLAG_GLASS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SLAG_GLASS_SLAB.get()));



        dropSelf(ModBlocks.CUT_URANIUM_BLOCK.get());
        dropSelf(ModBlocks.CUT_URANIUM_STAIRS.get());
        add(ModBlocks.CUT_URANIUM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CUT_URANIUM_SLAB.get()));
        dropSelf(ModBlocks.PILLAR_URANIUM_BLOCK.get());
        dropSelf(ModBlocks.PILLAR_URANIUM_STAIRS.get());
        add(ModBlocks.PILLAR_URANIUM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PILLAR_URANIUM_SLAB.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
