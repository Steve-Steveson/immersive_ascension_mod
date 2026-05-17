package net.steveson.immersiveascension.block;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.steveson.immersiveascension.ImmersiveAscensionMod;
import net.steveson.immersiveascension.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ImmersiveAscensionMod.MOD_ID);



    public static final DeferredBlock<StairBlock> INSULATING_GLASS_STAIRS = registerBlock("insulating_glass_stairs",
            ()-> new StairBlock( IEBlocks.StoneDecoration.INSULATING_GLASS.defaultBlockState(),
                    BlockBehaviour.Properties.ofLegacyCopy(IEBlocks.StoneDecoration.INSULATING_GLASS.get())));

    public static final DeferredBlock<StairBlock> SLAG_GLASS_STAIRS = registerBlock("slag_glass_stairs",
            ()-> new StairBlock( IEBlocks.StoneDecoration.SLAG_GLASS.defaultBlockState(),
                    BlockBehaviour.Properties.ofLegacyCopy(IEBlocks.StoneDecoration.SLAG_GLASS.get())){
                @Override
                protected int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
                    return 8;
                }
            });
    public static final DeferredBlock<SlabBlock> SLAG_GLASS_SLAB = registerBlock("slag_glass_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.ofLegacyCopy(IEBlocks.StoneDecoration.SLAG_GLASS.get())){
                @Override
                protected int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
                    return 8;
                }
            });


    public static final DeferredBlock<Block> CUT_URANIUM_BLOCK = registerBlock("cut_uranium_block",
            ()-> new Block(BlockBehaviour.Properties.ofLegacyCopy(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM).get())));

    public static final DeferredBlock<StairBlock> CUT_URANIUM_STAIRS = registerBlock("cut_uranium_stairs",
            ()-> new StairBlock( ModBlocks.CUT_URANIUM_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofLegacyCopy(ModBlocks.CUT_URANIUM_BLOCK.get())));

    public static final DeferredBlock<SlabBlock> CUT_URANIUM_SLAB = registerBlock("cut_uranium_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.ofLegacyCopy(ModBlocks.CUT_URANIUM_BLOCK.get())));

    public static final DeferredBlock<Block> PILLAR_URANIUM_BLOCK = registerBlock("pillar_uranium_block",
            ()-> new Block(BlockBehaviour.Properties.ofLegacyCopy(IEBlocks.Metals.STORAGE.get(EnumMetals.URANIUM).get())));

    public static final DeferredBlock<StairBlock> PILLAR_URANIUM_STAIRS = registerBlock("pillar_uranium_stairs",
            ()-> new StairBlock( ModBlocks.PILLAR_URANIUM_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofLegacyCopy(ModBlocks.PILLAR_URANIUM_BLOCK.get())));

    public static final DeferredBlock<SlabBlock> PILLAR_URANIUM_SLAB = registerBlock("pillar_uranium_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.ofLegacyCopy(ModBlocks.PILLAR_URANIUM_BLOCK.get())));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }


    private static <T extends Block> DeferredBlock<T> registerFuelBlock(String name, Supplier<T> block, int burnTime) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerFuelBlockItem(name, toReturn, burnTime);
        return toReturn;
    }
    private static <T extends Block> void registerFuelBlockItem(String name, DeferredBlock<T> block, int burnTime) {
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()){
            @Override
            public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                return burnTime;
            }
        });
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
