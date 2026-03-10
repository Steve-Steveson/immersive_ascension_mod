package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.steveson.immersiveascension.ImmersiveAscension;
import net.steveson.immersiveascension.block.ModBlocks;

import static blusunrize.immersiveengineering.ImmersiveEngineering.rl;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ImmersiveAscension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        evenSimplerBlockItem(ModBlocks.INSULATING_GLASS_STAIRS);

        for(EnumMetals m : EnumMetals.values())
        {
//            String name = m.tagName();
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

//            stairsBlock(((StairBlock) ModBlocks.SHEETMETAL_STAIRS.get(m).get()), rl("block/metal/sheetmetal_"+name));
            evenSimplerBlockItem(ModBlocks.SHEETMETAL_STAIRS.get(m));
        }

    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ImmersiveAscension.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
}
