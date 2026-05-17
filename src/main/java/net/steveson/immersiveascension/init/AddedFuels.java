package net.steveson.immersiveascension.init;

import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;


@EventBusSubscriber
public class AddedFuels {
    @SubscribeEvent
    public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
        ItemStack itemstack = event.getItemStack();
        if  (itemstack.getItem() == IEBlocks.TO_SLAB.get(BuiltInRegistries.BLOCK.getKey(IEBlocks.StoneDecoration.COKE.get())).asItem()) {
            event.setBurnTime(16000);
        }
    }
}
