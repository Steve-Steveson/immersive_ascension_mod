package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
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
        evenSimplerBlockItem(ModBlocks.SLAG_GLASS_STAIRS);
        evenSimplerBlockItem(ModBlocks.SLAG_GLASS_SLAB);


        for(EnumMetals m : EnumMetals.values())
        {
            if(!m.isVanillaMetal())
            {
                evenSimplerBlockItem(ModBlocks.STORAGE_STAIRS.get(m));
            }
            evenSimplerBlockItem(ModBlocks.SHEETMETAL_STAIRS.get(m));
        }

        for(DyeColor dye : DyeColor.values())
        {
            evenSimplerBlockItem(ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye));
        }
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ImmersiveAscension.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
}
