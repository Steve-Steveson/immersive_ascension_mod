package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import net.steveson.immersiveascension.ImmersiveAscension;
import net.steveson.immersiveascension.block.ModBlocks;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS, IEBlocks.StoneDecoration.INSULATING_GLASS, ModBlocks.INSULATING_GLASS_STAIRS, consumer);


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
//            this.dropSelf(ModBlocks.SHEETMETAL_STAIRS.get(m).get());
            registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS,IEBlocks.Metals.SHEETMETAL.get(m), ModBlocks.SHEETMETAL_STAIRS.get(m), consumer);
        }


    }

    private static void registerStairsCraftingRecipe(RecipeCategory category, ItemLike input, RegistryObject<Block> output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(category, output.get(),4)
                .pattern("I  ")
                .pattern("II ")
                .pattern("III")
                .define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(consumer,  ImmersiveAscension.MOD_ID + ":" + "crafting/" + getItemName(output.get()));
    }
}
