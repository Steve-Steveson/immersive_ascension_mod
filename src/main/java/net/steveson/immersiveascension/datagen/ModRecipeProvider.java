package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.api.IETags;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.steveson.immersiveascension.ImmersiveAscensionMod;
import net.steveson.immersiveascension.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        registerStairsCraftingRecipe(IEBlocks.StoneDecoration.INSULATING_GLASS, ModBlocks.INSULATING_GLASS_STAIRS, recipeOutput);
        registerStairsCraftingRecipe(IEBlocks.StoneDecoration.SLAG_GLASS, ModBlocks.SLAG_GLASS_STAIRS, recipeOutput);
        registerSlabCraftingRecipe(IEBlocks.StoneDecoration.SLAG_GLASS, ModBlocks.SLAG_GLASS_SLAB, recipeOutput);

        registerStonecuttingRecipe(IEBlocks.StoneDecoration.INSULATING_GLASS, ModBlocks.INSULATING_GLASS_STAIRS, recipeOutput);
        registerStonecuttingRecipeIE(IEBlocks.StoneDecoration.INSULATING_GLASS, IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.INSULATING_GLASS.get())).get(), recipeOutput, 2);
        registerStonecuttingRecipe(IEBlocks.StoneDecoration.SLAG_GLASS, ModBlocks.SLAG_GLASS_STAIRS, recipeOutput);
        registerStonecuttingRecipe(IEBlocks.StoneDecoration.SLAG_GLASS, ModBlocks.SLAG_GLASS_SLAB, recipeOutput, 2);



        registerStairsCraftingRecipe(IEBlocks.StoneDecoration.COKE, ModBlocks.COKE_STAIRS, recipeOutput);
        registerStairsCraftingRecipe(IEBlocks.StoneDecoration.COKEBRICK, ModBlocks.COKEBRICK_STAIRS, recipeOutput);
        registerStairsCraftingRecipe(IEBlocks.StoneDecoration.BLASTBRICK, ModBlocks.BLASTBRICK_STAIRS, recipeOutput);
        registerStairsCraftingRecipe(IEBlocks.StoneDecoration.BLASTBRICK_REINFORCED, ModBlocks.BLASTBRICK_REINFORCED_STAIRS, recipeOutput);
        registerStairsCraftingRecipe(IEBlocks.StoneDecoration.ALLOYBRICK, ModBlocks.ALLOYBRICK_STAIRS, recipeOutput);

        registerStonecuttingRecipe(IEBlocks.StoneDecoration.COKE, ModBlocks.COKE_STAIRS, recipeOutput);
        registerStonecuttingRecipeIE(IEBlocks.StoneDecoration.COKE, IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.COKE.get())).get(), recipeOutput, 2);
        registerStonecuttingRecipe(IEBlocks.StoneDecoration.COKEBRICK, ModBlocks.COKEBRICK_STAIRS, recipeOutput);
        registerStonecuttingRecipeIE(IEBlocks.StoneDecoration.COKEBRICK, IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.COKEBRICK.get())).get(), recipeOutput, 2);
        registerStonecuttingRecipe(IEBlocks.StoneDecoration.BLASTBRICK, ModBlocks.BLASTBRICK_STAIRS, recipeOutput);
        registerStonecuttingRecipeIE(IEBlocks.StoneDecoration.BLASTBRICK, IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.BLASTBRICK.get())).get(), recipeOutput, 2);
        registerStonecuttingRecipe(IEBlocks.StoneDecoration.BLASTBRICK_REINFORCED, ModBlocks.BLASTBRICK_REINFORCED_STAIRS, recipeOutput);
        registerStonecuttingRecipeIE(IEBlocks.StoneDecoration.BLASTBRICK_REINFORCED, IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.BLASTBRICK_REINFORCED.get())).get(), recipeOutput, 2);
        registerStonecuttingRecipe(IEBlocks.StoneDecoration.ALLOYBRICK, ModBlocks.ALLOYBRICK_STAIRS, recipeOutput);
        registerStonecuttingRecipeIE(IEBlocks.StoneDecoration.ALLOYBRICK, IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.ALLOYBRICK.get())).get(), recipeOutput, 2);




        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_BLOCK.get(), 4)
                .pattern("UU")
                .pattern("UU")
                .define('U', IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage))
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)))
                .save(recipeOutput, ImmersiveAscensionMod.MOD_ID + ":crafting/" + getItemName(ModBlocks.CUT_URANIUM_BLOCK.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PILLAR_URANIUM_BLOCK.get(), 2)
                .pattern("U")
                .pattern("U")
                .define('U', IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage))
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)))
                .save(recipeOutput, ImmersiveAscensionMod.MOD_ID + ":crafting/" + getItemName(ModBlocks.PILLAR_URANIUM_BLOCK.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PILLAR_URANIUM_BLOCK.get())
                .pattern("U")
                .pattern("U")
                .define('U', ModBlocks.PILLAR_URANIUM_SLAB.get())
                .unlockedBy(getHasName(ModBlocks.PILLAR_URANIUM_SLAB.get()), has(ModBlocks.PILLAR_URANIUM_SLAB.get()))
                .save(recipeOutput, ImmersiveAscensionMod.MOD_ID + ":" + "crafting/" + getItemName(ModBlocks.PILLAR_URANIUM_BLOCK.get()) + "_from_slab");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_BLOCK.get())
                .pattern("U")
                .pattern("U")
                .define('U', ModBlocks.CUT_URANIUM_SLAB.get())
                .unlockedBy(getHasName(ModBlocks.CUT_URANIUM_SLAB.get()), has(ModBlocks.CUT_URANIUM_SLAB.get()))
                .save(recipeOutput, ImmersiveAscensionMod.MOD_ID + ":" + "crafting/" + getItemName(ModBlocks.CUT_URANIUM_BLOCK.get()) + "_from_slab");


        registerStairsCraftingRecipe(ModBlocks.CUT_URANIUM_BLOCK.get(), ModBlocks.CUT_URANIUM_STAIRS, recipeOutput);
        registerSlabCraftingRecipe(ModBlocks.CUT_URANIUM_BLOCK.get(), ModBlocks.CUT_URANIUM_SLAB, recipeOutput);
        registerStairsCraftingRecipe(ModBlocks.PILLAR_URANIUM_BLOCK.get(), ModBlocks.PILLAR_URANIUM_STAIRS, recipeOutput);
        registerSlabCraftingRecipe(ModBlocks.PILLAR_URANIUM_BLOCK.get(), ModBlocks.PILLAR_URANIUM_SLAB, recipeOutput);




        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM), 1)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(recipeOutput,  ImmersiveAscensionMod.MOD_ID + ":" + "stonecutting/" + getItemName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_BLOCK.get(), 1)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(recipeOutput,  ImmersiveAscensionMod.MOD_ID + ":" + "stonecutting/" + getItemName(ModBlocks.CUT_URANIUM_BLOCK.get()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_STAIRS.get(), 1)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(recipeOutput,  ImmersiveAscensionMod.MOD_ID + ":" + "stonecutting/" + getItemName(ModBlocks.CUT_URANIUM_STAIRS.get()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_SLAB.get(), 2)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(recipeOutput,  ImmersiveAscensionMod.MOD_ID + ":" + "stonecutting/" + getItemName(ModBlocks.CUT_URANIUM_SLAB.get()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, ModBlocks.PILLAR_URANIUM_BLOCK.get(), 1)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(recipeOutput,  ImmersiveAscensionMod.MOD_ID + ":" + "stonecutting/" + getItemName(ModBlocks.PILLAR_URANIUM_BLOCK.get()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, ModBlocks.PILLAR_URANIUM_STAIRS.get(), 1)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(recipeOutput,  ImmersiveAscensionMod.MOD_ID + ":" + "stonecutting/" + getItemName(ModBlocks.PILLAR_URANIUM_STAIRS.get()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, ModBlocks.PILLAR_URANIUM_SLAB.get(), 2)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(recipeOutput,  ImmersiveAscensionMod.MOD_ID + ":" + "stonecutting/" + getItemName(ModBlocks.PILLAR_URANIUM_SLAB.get()));
    }

    private static void registerStairsCraftingRecipe(ItemLike input, DeferredBlock<StairBlock> output, RecipeOutput recipeOutput){
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output.get(), 4)
                .pattern("I  ")
                .pattern("II ")
                .pattern("III")
                .define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, ImmersiveAscensionMod.MOD_ID + ":crafting/" + getItemName(output.get()));
    }
    private static void registerSlabCraftingRecipe(ItemLike input, DeferredBlock<SlabBlock> output, RecipeOutput recipeOutput){
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output.get(), 6)
                .pattern("III")
                .define('I', input)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, ImmersiveAscensionMod.MOD_ID + ":crafting/" + getItemName(output.get()));
    }

    private static void registerStonecuttingRecipeIE(ItemLike input, Block output, RecipeOutput recipeOutput, int resultCount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, output, resultCount)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, ImmersiveAscensionMod.MOD_ID + ":stonecutting/" + getItemName(output));
    }

    private static void registerStonecuttingRecipe(ItemLike input, DeferredBlock<?> output, RecipeOutput recipeOutput, int resultCount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, output.get(), resultCount)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, ImmersiveAscensionMod.MOD_ID + ":stonecutting/" + getItemName(output.get()));
    }
    private static void registerStonecuttingRecipe(ItemLike input, DeferredBlock<?> output, RecipeOutput recipeOutput) {
        registerStonecuttingRecipe(input, output, recipeOutput, 1);
    }
}
