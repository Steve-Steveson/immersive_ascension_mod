package net.steveson.immersiveascension.item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.steveson.immersiveascension.ImmersiveAscensionMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ImmersiveAscensionMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

