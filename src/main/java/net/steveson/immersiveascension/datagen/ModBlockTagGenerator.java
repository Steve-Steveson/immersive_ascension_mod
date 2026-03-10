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
                ModBlocks.INSULATING_GLASS_STAIRS.get()
        );
        this.tag(BlockTags.STAIRS).add(
                ModBlocks.INSULATING_GLASS_STAIRS.get()
        );


        for(EnumMetals metal : EnumMetals.values())
        {
//            MetalTags tags = IETags.getTagsFor(metal);

//            if(!metal.isVanillaMetal())
//            {
//                tag(tags.storage).add(IEBlocks.Metals.STORAGE.get(metal).get());
//                tag(Tags.Blocks.STORAGE_BLOCKS).addTag(tags.storage);
//                if(metal.shouldAddOre())
//                {
//                    Preconditions.checkNotNull(tags.ore);
//                    tag(tags.ore)
//                            .add(IEBlocks.Metals.ORES.get(metal).get())
//                            .add(IEBlocks.Metals.DEEPSLATE_ORES.get(metal).get());
//                    tag(Tags.Blocks.ORES).addTag(tags.ore);
//                    Preconditions.checkNotNull(tags.rawBlock);
//                    tag(tags.rawBlock).add(IEBlocks.Metals.RAW_ORES.get(metal).get());
//                    tag(Tags.Blocks.STORAGE_BLOCKS).addTag(tags.rawBlock);
//                    tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(Metals.ORES.get(metal).get());
//                    tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(Metals.DEEPSLATE_ORES.get(metal).get());
//                    tag(Tags.Blocks.ORE_RATES_SINGULAR).add(Metals.ORES.get(metal).get())
//                            .add(Metals.DEEPSLATE_ORES.get(metal).get());
//                }
//            }
            this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                    ModBlocks.SHEETMETAL_STAIRS.get(metal).get()
            );
            this.tag(BlockTags.STAIRS).add(
                    ModBlocks.SHEETMETAL_STAIRS.get(metal).get()
            );
            this.tag(IETags.grindingDiskHarvestable).add(
                    ModBlocks.SHEETMETAL_STAIRS.get(metal).get()
            );


//            tag(IETags.sheetmetalSlabs).add(IEBlocks.TO_SLAB.get(Metals.SHEETMETAL.get(metal).getId()).get());
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
        }
    }
}
