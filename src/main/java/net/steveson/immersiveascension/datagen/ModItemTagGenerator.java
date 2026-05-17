package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.api.IETags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.steveson.immersiveascension.ImmersiveAscension;
import net.steveson.immersiveascension.api.IAItemTags;
import net.steveson.immersiveascension.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, ImmersiveAscension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {


        this.tag(ItemTags.STAIRS).add(
                ModBlocks.INSULATING_GLASS_STAIRS.get().asItem(),
                ModBlocks.SLAG_GLASS_STAIRS.get().asItem(),
                ModBlocks.COKE_STAIRS.get().asItem(),
                ModBlocks.COKEBRICK_STAIRS.get().asItem(),
                ModBlocks.BLASTBRICK_STAIRS.get().asItem(),
                ModBlocks.BLASTBRICK_REINFORCED_STAIRS.get().asItem(),
                ModBlocks.ALLOYBRICK_STAIRS.get().asItem(),
                ModBlocks.CUT_URANIUM_STAIRS.get().asItem(),
                ModBlocks.PILLAR_URANIUM_STAIRS.get().asItem()
        );
        this.tag(ItemTags.SLABS).add(
                ModBlocks.SLAG_GLASS_SLAB.get().asItem(),
                ModBlocks.CUT_URANIUM_SLAB.get().asItem(),
                ModBlocks.PILLAR_URANIUM_SLAB.get().asItem()
        );

        this.tag(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)).add(
                ModBlocks.CUT_URANIUM_BLOCK.get().asItem(),
                ModBlocks.PILLAR_URANIUM_BLOCK.get().asItem()
        );


        for(EnumMetals metal : EnumMetals.values())
        {
            if(!metal.isVanillaMetal())
            {
                this.tag(ItemTags.STAIRS).add(
                        ModBlocks.STORAGE_STAIRS.get(metal).get().asItem()
                );
            }
            this.tag(ItemTags.STAIRS).add(
                    ModBlocks.SHEETMETAL_STAIRS.get(metal).get().asItem()
            );
            this.tag(IAItemTags.STAIRS_SHEETMETAL).add(
                    ModBlocks.SHEETMETAL_STAIRS.get(metal).get().asItem()
            );
        }

        for(DyeColor dye : DyeColor.values())
        {
            this.tag(ItemTags.STAIRS).add(
                    ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye).get().asItem()
            );
            this.tag(IAItemTags.STAIRS_SHEETMETAL).add(
                    ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye).get().asItem()
            );
        }
    }
}
