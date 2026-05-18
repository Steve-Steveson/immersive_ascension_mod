package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.StairBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.steveson.immersiveascension.ImmersiveAscensionMod;
import net.steveson.immersiveascension.block.ModBlocks;

import static blusunrize.immersiveengineering.ImmersiveEngineering.rl;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ImmersiveAscensionMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        stairsBlock(ModBlocks.COKE_STAIRS.get(), rl("block/stone_decoration/coke"));
        stairsBlock(ModBlocks.COKEBRICK_STAIRS.get(), rl("block/stone_decoration/cokebrick"));
        stairsBlock(ModBlocks.BLASTBRICK_STAIRS.get(), rl("block/stone_decoration/blastbrick"));
        stairsBlock(ModBlocks.BLASTBRICK_REINFORCED_STAIRS.get(), rl("block/stone_decoration/blastbrick_reinforced"));
        stairsBlock(ModBlocks.ALLOYBRICK_STAIRS.get(), rl("block/stone_decoration/alloybrick"));

        stairsBlock(ModBlocks.CUT_URANIUM_STAIRS.get(), rl("block/metal/storage_uranium_side"));
        slabBlock(ModBlocks.CUT_URANIUM_SLAB.get(), blockTexture(ModBlocks.CUT_URANIUM_BLOCK.get()), rl("block/metal/storage_uranium_side"));
        stairsBlock(ModBlocks.PILLAR_URANIUM_STAIRS.get(), rl("block/metal/storage_uranium_top"), rl("block/metal/storage_uranium_side"), rl("block/metal/storage_uranium_side"));
        slabBlock(ModBlocks.PILLAR_URANIUM_SLAB.get(), blockTexture(ModBlocks.PILLAR_URANIUM_BLOCK.get()), rl("block/metal/storage_uranium_top"), rl("block/metal/storage_uranium_side"), rl("block/metal/storage_uranium_side"));

        for(EnumMetals m : EnumMetals.values())
        {
            String name = m.tagName();
            if(!m.isVanillaMetal())
            {
                if (m != EnumMetals.URANIUM){
                    stairsBlock(ModBlocks.STORAGE_STAIRS.get(m).get(), rl("block/metal/storage_"+name));
                }
                blockItem(ModBlocks.STORAGE_STAIRS.get(m));
            }
            stairsBlock(ModBlocks.SHEETMETAL_STAIRS.get(m).get(), rl("block/metal/sheetmetal_"+name));
            blockItem(ModBlocks.SHEETMETAL_STAIRS.get(m));
        }

        for(DyeColor dye : DyeColor.values())
        {
            String name = dye.getName();

            stairsBlock(ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye).get(), rl("block/metal/sheetmetal_"+name));
            blockItem(ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye));
        }

        blockItem(ModBlocks.INSULATING_GLASS_STAIRS);
        blockItem(ModBlocks.SLAG_GLASS_STAIRS);
        blockItem(ModBlocks.SLAG_GLASS_SLAB);

        blockItem(ModBlocks.COKE_STAIRS);
        blockItem(ModBlocks.COKEBRICK_STAIRS);
        blockItem(ModBlocks.BLASTBRICK_STAIRS);
        blockItem(ModBlocks.BLASTBRICK_REINFORCED_STAIRS);
        blockItem(ModBlocks.ALLOYBRICK_STAIRS);

        blockItem(ModBlocks.CUT_URANIUM_BLOCK);
        blockItem(ModBlocks.CUT_URANIUM_STAIRS);
        blockItem(ModBlocks.CUT_URANIUM_SLAB);
        blockItem(ModBlocks.PILLAR_URANIUM_BLOCK);
        blockItem(ModBlocks.PILLAR_URANIUM_STAIRS);
        blockItem(ModBlocks.PILLAR_URANIUM_SLAB);
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(ImmersiveAscensionMod.MOD_ID + ":block/" + deferredBlock.getId().getPath()));
    }


}
