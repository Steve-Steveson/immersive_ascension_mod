package net.steveson.immersiveascension.datagen.loot;

import blusunrize.immersiveengineering.api.EnumMetals;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.steveson.immersiveascension.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.INSULATING_GLASS_STAIRS.get());
        this.dropSelf(ModBlocks.SLAG_GLASS_STAIRS.get());
        this.add(ModBlocks.SLAG_GLASS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SLAG_GLASS_SLAB.get()));


        for(EnumMetals m : EnumMetals.values())
        {
            if(!m.isVanillaMetal())
            {
                this.dropSelf(ModBlocks.STORAGE_STAIRS.get(m).get());
            }
            this.dropSelf(ModBlocks.SHEETMETAL_STAIRS.get(m).get());
        }

        for(DyeColor dye : DyeColor.values())
        {
            this.dropSelf(ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye).get());
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
