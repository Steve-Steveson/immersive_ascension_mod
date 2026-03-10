package net.steveson.immersiveascension.block;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.common.blocks.IEBaseBlock;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.steveson.immersiveascension.ImmersiveAscension;
import net.steveson.immersiveascension.item.ModItems;

import javax.annotation.Nullable;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocks {

    private static final Supplier<BlockBehaviour.Properties> SHEETMETAL_PROPERTIES = () -> Block.Properties.of()
            .mapColor(MapColor.METAL)
            .sound(SoundType.METAL)
            .strength(2, 2); //Cauldron props are 2,2 and sheetmetal is similar


    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ImmersiveAscension.MOD_ID);


    public static final RegistryObject<Block> INSULATING_GLASS_STAIRS = registerBlock("insulating_glass_stairs",
            ()-> new StairBlock(()-> IEBlocks.StoneDecoration.INSULATING_GLASS.defaultBlockState(),
                    IEBlocks.StoneDecoration.INSULATING_GLASS.getProperties()));



    public static final Map<EnumMetals,  RegistryObject<Block>> STORAGE_STAIRS = new EnumMap<>(EnumMetals.class);
    public static final Map<EnumMetals,  RegistryObject<Block>> SHEETMETAL_STAIRS = new EnumMap<>(EnumMetals.class);
    public static final Map<DyeColor, RegistryObject<Block>> COLORED_SHEETMETAL_STAIRS = new EnumMap<>(DyeColor.class);

    private static void metalInit()
    {
        for(EnumMetals m : EnumMetals.values())
        {
            String name = m.tagName();

            if(!m.isVanillaMetal())
            {
                RegistryObject<Block> metalStair = registerBlock("stairs_storage_"+name,
                        ()-> new StairBlock(()-> {
                            IEBlocks.BlockEntry<Block> blockEntry = IEBlocks.Metals.STORAGE.get(m);
                            return blockEntry.defaultBlockState();
                        },
                                Block.Properties.of()
                                        .mapColor(MapColor.METAL)
                                        .sound(m==EnumMetals.STEEL?SoundType.NETHERITE_BLOCK: SoundType.METAL)
                                        .strength(5, 10)
                                        .requiresCorrectToolForDrops())
                );
                STORAGE_STAIRS.put(m, metalStair);
            }

            RegistryObject<Block> sheetmetalStair = registerBlock("stairs_sheetmetal_"+name,
                    ()-> new StairBlock(()-> {
                        IEBlocks.BlockEntry<IEBaseBlock> blockEntry = IEBlocks.Metals.SHEETMETAL.get(m);
                        return blockEntry.defaultBlockState();
                        },
                            SHEETMETAL_PROPERTIES.get())
            );
            SHEETMETAL_STAIRS.put(m, sheetmetalStair);
        }

        for(DyeColor dye : DyeColor.values())
        {
            String name = dye.getName();

            RegistryObject<Block> coloredSheetmetalStair = registerBlock("colored_stairs_sheetmetal_"+name,
                    ()-> new StairBlock(()-> {
                        IEBlocks.BlockEntry<IEBaseBlock> blockEntry = IEBlocks.MetalDecoration.COLORED_SHEETMETAL.get(dye);
                        return blockEntry.defaultBlockState();
                    },
                            SHEETMETAL_PROPERTIES.get())
            );
            COLORED_SHEETMETAL_STAIRS.put(dye, coloredSheetmetalStair);
        }
    }







    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerFuelBlock(String name, Supplier<T> block, int burnTime) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerFuelBlockItem(name, toReturn, burnTime);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerFuelBlockItem(String name, RegistryObject<T> block, int burnTime) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()) {
            @Override
            public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                return burnTime;
            }
        });
    }


    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        metalInit();
    }

}
