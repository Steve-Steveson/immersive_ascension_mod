package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.api.IETags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.steveson.immersiveascension.ImmersiveAscension;
import net.steveson.immersiveascension.api.ATags;
import net.steveson.immersiveascension.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ImmersiveAscension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.INSULATING_GLASS_STAIRS.get(),
                ModBlocks.SLAG_GLASS_STAIRS.get(),
                ModBlocks.SLAG_GLASS_SLAB.get()
        );
        this.tag(BlockTags.STAIRS).add(
                ModBlocks.INSULATING_GLASS_STAIRS.get(),
                ModBlocks.SLAG_GLASS_STAIRS.get()
        );
        this.tag(BlockTags.SLABS).add(
                ModBlocks.SLAG_GLASS_SLAB.get()
        );



        for(EnumMetals metal : EnumMetals.values())
        {
            if(!metal.isVanillaMetal())
            {
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                        ModBlocks.STORAGE_STAIRS.get(metal).get()
                );
                this.tag(BlockTags.STAIRS).add(
                        ModBlocks.STORAGE_STAIRS.get(metal).get()
                );
                this.tag(IETags.grindingDiskHarvestable).add(
                        ModBlocks.STORAGE_STAIRS.get(metal).get()
                );
            }
            this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                    ModBlocks.SHEETMETAL_STAIRS.get(metal).get()
            );
            this.tag(BlockTags.STAIRS).add(
                    ModBlocks.SHEETMETAL_STAIRS.get(metal).get()
            );
            this.tag(IETags.grindingDiskHarvestable).add(
                    ModBlocks.SHEETMETAL_STAIRS.get(metal).get()
            );
            this.tag(ATags.STAIRS_SHEETMETAL).add(
                    ModBlocks.SHEETMETAL_STAIRS.get(metal).get()
            );
        }

        for(DyeColor dye : DyeColor.values())
        {
            this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                    ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye).get()
            );
            this.tag(BlockTags.STAIRS).add(
                    ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye).get()
            );
            this.tag(IETags.grindingDiskHarvestable).add(
                    ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye).get()
            );
            this.tag(ATags.STAIRS_SHEETMETAL).add(
                    ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye).get()
            );
        }
    }
}
