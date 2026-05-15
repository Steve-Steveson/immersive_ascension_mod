package net.steveson.immersiveascension.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
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
