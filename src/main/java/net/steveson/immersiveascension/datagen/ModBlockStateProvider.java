package net.steveson.immersiveascension.datagen;

import net.minecraft.data.PackOutput;
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

        stairsBlock(ModBlocks.CUT_URANIUM_STAIRS.get(), rl("block/metal/storage_uranium_side"));
        slabBlock(ModBlocks.CUT_URANIUM_SLAB.get(), blockTexture(ModBlocks.CUT_URANIUM_BLOCK.get()), rl("block/metal/storage_uranium_side"));
        stairsBlock(ModBlocks.PILLAR_URANIUM_STAIRS.get(), rl("block/metal/storage_uranium_top"), rl("block/metal/storage_uranium_side"), rl("block/metal/storage_uranium_side"));
        slabBlock(ModBlocks.PILLAR_URANIUM_SLAB.get(), blockTexture(ModBlocks.PILLAR_URANIUM_BLOCK.get()), rl("block/metal/storage_uranium_top"), rl("block/metal/storage_uranium_side"), rl("block/metal/storage_uranium_side"));

        blockItem(ModBlocks.INSULATING_GLASS_STAIRS);
        blockItem(ModBlocks.SLAG_GLASS_STAIRS);
        blockItem(ModBlocks.SLAG_GLASS_SLAB);

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
