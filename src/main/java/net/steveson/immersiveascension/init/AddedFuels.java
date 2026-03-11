package net.steveson.immersiveascension.init;

import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class AddedFuels {
    @SubscribeEvent
    public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
        ItemStack itemstack = event.getItemStack();
        if  (itemstack.getItem() == IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.COKE.get())).asItem()) {
            event.setBurnTime(16000);
        }
    }
}
