package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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
        stairsBlock(((StairBlock) ModBlocks.INSULATING_GLASS_STAIRS.get()), rl("block/stone_decoration/insulating_glass"));
//        cubeAll(ModBlocks.INSULATING_GLASS_STAIRS.get(), rl("block/stone_decoration/insulating_glass"), translucent() );



        for(EnumMetals m : EnumMetals.values())
        {
            String name = m.tagName();
//            if(!m.isVanillaMetal())
//            {
//                if(m.shouldAddOre())
//                {
//                    cubeAll(Metals.ORES.get(m), modLoc("block/metal/ore_"+name));
//                    cubeAll(Metals.DEEPSLATE_ORES.get(m), modLoc("block/metal/deepslate_ore_"+name));
//                    cubeAll(Metals.RAW_ORES.get(m), modLoc("block/metal/raw_"+name));
//                }
//                ResourceLocation defaultStorageTexture = modLoc("block/metal/storage_"+name);
//                BlockEntry<Block> storage = Metals.STORAGE.get(m);
//                String storageName = name(storage);
//                BlockModelBuilder storageModel;
//                if(m==EnumMetals.URANIUM)
//                {
//                    ResourceLocation side = modLoc("block/metal/storage_"+name+"_side");
//                    ResourceLocation top = modLoc("block/metal/storage_"+name+"_top");
//                    storageModel = models().cubeBottomTop(storageName, side, top, top);
//                    slabFor(storage, side, top, top);
//                }
//                else
//                {
//                    storageModel = models().cubeAll(storageName, defaultStorageTexture);
//                    slabFor(storage, defaultStorageTexture);
//                }
//                simpleBlockAndItem(storage, storageModel);
//            }

            stairsBlock(((StairBlock) ModBlocks.SHEETMETAL_STAIRS.get(m).get()), rl("block/metal/sheetmetal_"+name));
        }
    }
}
