package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
        registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS, IEBlocks.StoneDecoration.SLAG_GLASS, ModBlocks.SLAG_GLASS_STAIRS, consumer);
        registerSlabCraftingRecipe(RecipeCategory.BUILDING_BLOCKS, IEBlocks.StoneDecoration.SLAG_GLASS, ModBlocks.SLAG_GLASS_SLAB,consumer);


        for(EnumMetals m : EnumMetals.values())
        {
            if(!m.isVanillaMetal())
            {
                registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS,IEBlocks.Metals.STORAGE.get(m), ModBlocks.STORAGE_STAIRS.get(m), consumer);
            }
            registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS,IEBlocks.Metals.SHEETMETAL.get(m), ModBlocks.SHEETMETAL_STAIRS.get(m), consumer);
        }

        for(DyeColor dye : DyeColor.values())
        {
            registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS,IEBlocks.MetalDecoration.COLORED_SHEETMETAL.get(dye), ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye), consumer);
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
    private static void registerSlabCraftingRecipe(RecipeCategory category, ItemLike input, RegistryObject<Block> output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(category, output.get(),6)
                .pattern("III")
                .define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(consumer,  ImmersiveAscension.MOD_ID + ":" + "crafting/" + getItemName(output.get()));
    }
}
