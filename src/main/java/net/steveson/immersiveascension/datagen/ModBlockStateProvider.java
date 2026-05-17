package net.steveson.immersiveascension.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.steveson.immersiveascension.ImmersiveAscensionMod;
import net.steveson.immersiveascension.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ImmersiveAscensionMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockItem(ModBlocks.INSULATING_GLASS_STAIRS);
        blockItem(ModBlocks.SLAG_GLASS_STAIRS);
        blockItem(ModBlocks.SLAG_GLASS_SLAB);

    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(ImmersiveAscensionMod.MOD_ID + ":block/" + deferredBlock.getId().getPath()));
    }


}
