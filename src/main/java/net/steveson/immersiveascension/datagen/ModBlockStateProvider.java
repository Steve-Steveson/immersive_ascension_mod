package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.steveson.immersiveascension.ImmersiveAscension;
import net.steveson.immersiveascension.block.ModBlocks;

import static blusunrize.immersiveengineering.ImmersiveEngineering.rl;
import static net.minecraft.client.renderer.RenderType.translucent;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ImmersiveAscension.MOD_ID, exFileHelper);
    }




    @Override
    protected void registerStatesAndModels() {
//        stairsBlock(((StairBlock) ModBlocks.INSULATING_GLASS_STAIRS.get()), rl("block/stone_decoration/insulating_glass"));
//        cubeAll(ModBlocks.INSULATING_GLASS_STAIRS.get(), rl("block/stone_decoration/insulating_glass"), translucent() );



        for(EnumMetals m : EnumMetals.values())
        {
            String name = m.tagName();
            if(!m.isVanillaMetal())
            {
                if(m != EnumMetals.URANIUM)
                {
                    stairsBlock(((StairBlock) ModBlocks.STORAGE_STAIRS.get(m).get()), rl("block/metal/storage_"+name));
                }
//                else {
//                    //temp code for U
//                    stairsBlock(((StairBlock) ModBlocks.STORAGE_STAIRS.get(m).get()), rl("block/metal/storage_"+name+"_side"));
//                }
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
