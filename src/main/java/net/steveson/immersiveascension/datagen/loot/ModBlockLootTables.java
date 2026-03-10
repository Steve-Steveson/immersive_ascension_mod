package net.steveson.immersiveascension.datagen.loot;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.common.blocks.IEBaseBlock;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.registries.RegistryObject;
import net.steveson.immersiveascension.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.INSULATING_GLASS_STAIRS.get());

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
            this.dropSelf(ModBlocks.SHEETMETAL_STAIRS.get(m).get());
        }


        for(DyeColor dye : DyeColor.values())
        {
            this.dropSelf(ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye).get());
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
