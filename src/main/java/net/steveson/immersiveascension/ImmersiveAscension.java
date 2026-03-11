package net.steveson.immersiveascension;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.common.register.IECreativeTabs;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import net.steveson.immersiveascension.block.ModBlocks;
import net.steveson.immersiveascension.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ImmersiveAscension.MOD_ID)
public class ImmersiveAscension
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "immersive_ascension";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public ImmersiveAscension(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        for (RegistryObject<CreativeModeTab> tab : IECreativeTabs.REGISTER.getEntries()){
            if (event.getTabKey() == tab.getKey()) {
                event.accept(ModBlocks.INSULATING_GLASS_STAIRS);
                event.accept(ModBlocks.SLAG_GLASS_STAIRS);
                event.accept(ModBlocks.SLAG_GLASS_SLAB);
                for(EnumMetals m : EnumMetals.values())
                {
                    if(!m.isVanillaMetal())
                    {
                        event.accept(ModBlocks.STORAGE_STAIRS.get(m));
                    }
                    event.accept(ModBlocks.SHEETMETAL_STAIRS.get(m));
                }
                for(DyeColor dye : DyeColor.values()){
                    event.accept(ModBlocks.COLORED_SHEETMETAL_STAIRS.get(dye));
                }
                event.accept(ModBlocks.COKE_STAIRS);
                event.accept(ModBlocks.COKEBRICK_STAIRS);
                event.accept(ModBlocks.BLASTBRICK_STAIRS);
                event.accept(ModBlocks.BLASTBRICK_REINFORCED_STAIRS);
                event.accept(ModBlocks.ALLOYBRICK_STAIRS);
                event.accept(ModBlocks.CUT_URANIUM_BLOCK);
                event.accept(ModBlocks.CUT_URANIUM_STAIRS);
                event.accept(ModBlocks.CUT_URANIUM_SLAB);
                event.accept(ModBlocks.PILLAR_URANIUM_BLOCK);
                event.accept(ModBlocks.PILLAR_URANIUM_STAIRS);
                event.accept(ModBlocks.PILLAR_URANIUM_SLAB);
            }
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
