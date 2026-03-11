package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.api.IETags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.steveson.immersiveascension.ImmersiveAscension;
import net.steveson.immersiveascension.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, ImmersiveAscension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {


        this.tag(ItemTags.STAIRS).add(
                ModBlocks.INSULATING_GLASS_STAIRS.get().asItem(),
                ModBlocks.SLAG_GLASS_STAIRS.get().asItem(),
                ModBlocks.CUT_URANIUM_STAIRS.get().asItem()
        );
        this.tag(ItemTags.SLABS).add(
                ModBlocks.SLAG_GLASS_SLAB.get().asItem(),
                ModBlocks.CUT_URANIUM_SLAB.get().asItem()
        );

        this.tag(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)).add(
                ModBlocks.CUT_URANIUM_BLOCK.get().asItem(),
                ModBlocks.PILLAR_URANIUM_BLOCK.get().asItem()
        );

    }
}
