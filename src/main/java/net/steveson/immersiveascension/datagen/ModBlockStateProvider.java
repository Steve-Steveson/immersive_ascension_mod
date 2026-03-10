package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.steveson.immersiveascension.ImmersiveAscension;
import net.steveson.immersiveascension.block.ModBlocks;

import static blusunrize.immersiveengineering.ImmersiveEngineering.rl;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ImmersiveAscension.MOD_ID, exFileHelper);
    }




    @Override
    protected void registerStatesAndModels() {
//        stairsBlock(((StairBlock) ModBlocks.SLAG_GLASS_STAIRS.get()), rl("block/stone_decoration/slag_glass"));
//        slabBlock(((SlabBlock) ModBlocks.SLAG_GLASS_SLAB.get()), rl("block/stone_decoration/slag_glass"), rl("block/stone_decoration/slag_glass"));


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
