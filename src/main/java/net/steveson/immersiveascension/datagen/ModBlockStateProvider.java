package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.steveson.immersiveascension.ImmersiveAscension;
import net.steveson.immersiveascension.block.ModBlocks;

import static blusunrize.immersiveengineering.ImmersiveEngineering.rl;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ImmersiveAscension.MOD_ID, exFileHelper);
    }


    @Override
    protected void registerStatesAndModels() {
        stairsBlock(((StairBlock) ModBlocks.CUT_URANIUM_STAIRS.get()), rl("block/metal/storage_uranium_side"));
        slabBlock(((SlabBlock) ModBlocks.CUT_URANIUM_SLAB.get()), blockTexture(ModBlocks.CUT_URANIUM_BLOCK.get()), rl("block/metal/storage_uranium_side"));
        stairsBlock(((StairBlock) ModBlocks.PILLAR_URANIUM_STAIRS.get()), rl("block/metal/storage_uranium_top"), rl("block/metal/storage_uranium_side"), rl("block/metal/storage_uranium_side"));
        slabBlock(((SlabBlock) ModBlocks.PILLAR_URANIUM_SLAB.get()), blockTexture(ModBlocks.PILLAR_URANIUM_BLOCK.get()), rl("block/metal/storage_uranium_top"), rl("block/metal/storage_uranium_side"), rl("block/metal/storage_uranium_side"));



        for(EnumMetals m : EnumMetals.values())
        {
            String name = m.tagName();
            if(!m.isVanillaMetal() && m != EnumMetals.URANIUM)
            {
                    stairsBlock(((StairBlock) ModBlocks.STORAGE_STAIRS.get(m).get()), rl("block/metal/storage_"+name));
            }
            stairsBlock(((StairBlock) ModBlocks.SHEETMETAL_STAIRS.get(m).get()), rl("block/metal/sheetmetal_"+name));
        }

        for(DyeColor dye : DyeColor.values())
        {
            String name = dye.getName();

            stairsBlock(((StairBlock) ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye).get()), rl("block/metal/sheetmetal_"+name));
        }
    }
}
