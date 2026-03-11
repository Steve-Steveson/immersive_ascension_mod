package net.steveson.immersiveascension.datagen;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.api.IETags;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.crafting.Ingredient;
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

        registerStonecuttingRecipe(IEBlocks.StoneDecoration.INSULATING_GLASS, ModBlocks.INSULATING_GLASS_STAIRS, consumer);
        registerStonecuttingRecipeIE(IEBlocks.StoneDecoration.INSULATING_GLASS, IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.INSULATING_GLASS.get())).get(), consumer, 2);
        registerStonecuttingRecipe(IEBlocks.StoneDecoration.SLAG_GLASS, ModBlocks.SLAG_GLASS_STAIRS, consumer);
        registerStonecuttingRecipe(IEBlocks.StoneDecoration.SLAG_GLASS, ModBlocks.SLAG_GLASS_SLAB, consumer, 2);


        for(EnumMetals m : EnumMetals.values())
        {
            if(!m.isVanillaMetal())
            {
                registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS,IEBlocks.Metals.STORAGE.get(m), ModBlocks.STORAGE_STAIRS.get(m), consumer);
                //more code goes here
            }
            registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS,IEBlocks.Metals.SHEETMETAL.get(m), ModBlocks.SHEETMETAL_STAIRS.get(m), consumer);
            registerStonecuttingRecipe(IEBlocks.Metals.SHEETMETAL.get(m), ModBlocks.SHEETMETAL_STAIRS.get(m), consumer);
            registerStonecuttingRecipeIE(IEBlocks.Metals.SHEETMETAL.get(m), IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.Metals.SHEETMETAL.get(m).get())).get(), consumer, 2);
        }
        for(DyeColor dye : DyeColor.values())
        {
            registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS,IEBlocks.MetalDecoration.COLORED_SHEETMETAL.get(dye), ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye), consumer);
            registerStonecuttingRecipe(IEBlocks.MetalDecoration.COLORED_SHEETMETAL.get(dye), ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye), consumer);
            registerStonecuttingRecipeIE(IEBlocks.MetalDecoration.COLORED_SHEETMETAL.get(dye), IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.MetalDecoration.COLORED_SHEETMETAL.get(dye).get())).get(), consumer, 2);
        }


        registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS, IEBlocks.StoneDecoration.COKE, ModBlocks.COKE_STAIRS, consumer);
        registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS, IEBlocks.StoneDecoration.COKEBRICK, ModBlocks.COKEBRICK_STAIRS, consumer);
        registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS, IEBlocks.StoneDecoration.BLASTBRICK, ModBlocks.BLASTBRICK_STAIRS, consumer);
        registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS, IEBlocks.StoneDecoration.BLASTBRICK_REINFORCED, ModBlocks.BLASTBRICK_REINFORCED_STAIRS, consumer);
        registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS, IEBlocks.StoneDecoration.ALLOYBRICK, ModBlocks.ALLOYBRICK_STAIRS, consumer);

        registerStonecuttingRecipe(IEBlocks.StoneDecoration.COKE, ModBlocks.COKE_STAIRS, consumer);
        registerStonecuttingRecipeIE(IEBlocks.StoneDecoration.COKE, IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.COKE.get())).get(), consumer, 2);
        registerStonecuttingRecipe(IEBlocks.StoneDecoration.COKEBRICK, ModBlocks.COKEBRICK_STAIRS, consumer);
        registerStonecuttingRecipeIE(IEBlocks.StoneDecoration.COKEBRICK, IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.COKEBRICK.get())).get(), consumer, 2);
        registerStonecuttingRecipe(IEBlocks.StoneDecoration.BLASTBRICK, ModBlocks.BLASTBRICK_STAIRS, consumer);
        registerStonecuttingRecipeIE(IEBlocks.StoneDecoration.BLASTBRICK, IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.BLASTBRICK.get())).get(), consumer, 2);
        registerStonecuttingRecipe(IEBlocks.StoneDecoration.BLASTBRICK_REINFORCED, ModBlocks.BLASTBRICK_REINFORCED_STAIRS, consumer);
        registerStonecuttingRecipeIE(IEBlocks.StoneDecoration.BLASTBRICK_REINFORCED, IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.BLASTBRICK_REINFORCED.get())).get(), consumer, 2);
        registerStonecuttingRecipe(IEBlocks.StoneDecoration.ALLOYBRICK, ModBlocks.ALLOYBRICK_STAIRS, consumer);
        registerStonecuttingRecipeIE(IEBlocks.StoneDecoration.ALLOYBRICK, IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.ALLOYBRICK.get())).get(), consumer, 2);




        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_BLOCK.get(), 4)
                .pattern("UU")
                .pattern("UU")
                .define('U', IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage))
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(consumer, ImmersiveAscension.MOD_ID + ":" + "crafting/" + getItemName(ModBlocks.CUT_URANIUM_BLOCK.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PILLAR_URANIUM_BLOCK.get(), 2)
                .pattern("U")
                .pattern("U")
                .define('U', IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage))
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(consumer, ImmersiveAscension.MOD_ID + ":" + "crafting/" + getItemName(ModBlocks.PILLAR_URANIUM_BLOCK.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PILLAR_URANIUM_BLOCK.get())
                .pattern("U")
                .pattern("U")
                .define('U', ModBlocks.PILLAR_URANIUM_SLAB.get())
                .unlockedBy(getHasName(ModBlocks.PILLAR_URANIUM_SLAB.get()), has(ModBlocks.PILLAR_URANIUM_SLAB.get()))
                .save(consumer, ImmersiveAscension.MOD_ID + ":" + "crafting/" + getItemName(ModBlocks.PILLAR_URANIUM_BLOCK.get()) + "_from_slab");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_BLOCK.get())
                .pattern("U")
                .pattern("U")
                .define('U', ModBlocks.CUT_URANIUM_SLAB.get())
                .unlockedBy(getHasName(ModBlocks.CUT_URANIUM_SLAB.get()), has(ModBlocks.CUT_URANIUM_SLAB.get()))
                .save(consumer, ImmersiveAscension.MOD_ID + ":" + "crafting/" + getItemName(ModBlocks.CUT_URANIUM_BLOCK.get()) + "_from_slab");


        registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_BLOCK.get(), ModBlocks.CUT_URANIUM_STAIRS, consumer);
        registerSlabCraftingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_BLOCK.get(), ModBlocks.CUT_URANIUM_SLAB,consumer);
        registerStairsCraftingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PILLAR_URANIUM_BLOCK.get(), ModBlocks.PILLAR_URANIUM_STAIRS, consumer);
        registerSlabCraftingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PILLAR_URANIUM_BLOCK.get(), ModBlocks.PILLAR_URANIUM_SLAB,consumer);




        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM), 1)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(consumer,  ImmersiveAscension.MOD_ID + ":" + "stonecutting/" + getItemName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_BLOCK.get(), 1)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(consumer,  ImmersiveAscension.MOD_ID + ":" + "stonecutting/" + getItemName(ModBlocks.CUT_URANIUM_BLOCK.get()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_STAIRS.get(), 1)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(consumer,  ImmersiveAscension.MOD_ID + ":" + "stonecutting/" + getItemName(ModBlocks.CUT_URANIUM_STAIRS.get()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_SLAB.get(), 2)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(consumer,  ImmersiveAscension.MOD_ID + ":" + "stonecutting/" + getItemName(ModBlocks.CUT_URANIUM_SLAB.get()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, ModBlocks.PILLAR_URANIUM_BLOCK.get(), 1)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(consumer,  ImmersiveAscension.MOD_ID + ":" + "stonecutting/" + getItemName(ModBlocks.PILLAR_URANIUM_BLOCK.get()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, ModBlocks.PILLAR_URANIUM_STAIRS.get(), 1)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(consumer,  ImmersiveAscension.MOD_ID + ":" + "stonecutting/" + getItemName(ModBlocks.PILLAR_URANIUM_STAIRS.get()));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IETags.getItemTag(IETags.getTagsFor(EnumMetals.URANIUM).storage)), RecipeCategory.BUILDING_BLOCKS, ModBlocks.PILLAR_URANIUM_SLAB.get(), 2)
                .unlockedBy(getHasName(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)), has(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM)))
                .save(consumer,  ImmersiveAscension.MOD_ID + ":" + "stonecutting/" + getItemName(ModBlocks.PILLAR_URANIUM_SLAB.get()));
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


//    private static void registerTaggedStonecuttingRecipe(TagKey input, RegistryObject<Block> output, IEBlocks.BlockEntry unlocker, Consumer<FinishedRecipe> consumer, int resultCount) {
//        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, output.get(), resultCount)
//                .unlockedBy(getHasName(unlocker), has(unlocker))
//                .save(consumer,  ImmersiveAscension.MOD_ID + ":" + "stonecutting/" + getItemName(output.get()));
//    }

    private static void registerStonecuttingRecipeIE(ItemLike input, Block output, Consumer<FinishedRecipe> consumer, int resultCount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, output, resultCount)
                .unlockedBy(getHasName(input), has(input))
                .save(consumer,  ImmersiveAscension.MOD_ID + ":" + "stonecutting/" + getItemName(output));
    }

    private static void registerStonecuttingRecipe(ItemLike input, RegistryObject<Block> output, Consumer<FinishedRecipe> consumer, int resultCount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, output.get(), resultCount)
                .unlockedBy(getHasName(input), has(input))
                .save(consumer,  ImmersiveAscension.MOD_ID + ":" + "stonecutting/" + getItemName(output.get()));
    }
    private static void registerStonecuttingRecipe(ItemLike input, RegistryObject<Block> output, Consumer<FinishedRecipe> consumer) {
        registerStonecuttingRecipe(input, output, consumer,1);
    }
}
