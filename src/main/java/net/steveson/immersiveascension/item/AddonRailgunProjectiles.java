package net.steveson.immersiveascension.item;

import blusunrize.immersiveengineering.api.tool.RailgunHandler;
import net.minecraftforge.common.Tags;

public class AddonRailgunProjectiles {

    public static void register(){

        // Stick
        RailgunHandler.registerStandardProjectile(Tags.Items.RODS_WOODEN, 8, 1.25).setColorMap(
                new RailgunHandler.RailgunRenderColors(0xff0000, 0x00ff00, 0x0000ff, 0xffff00, 0xff00ff, 0x00ffff)
        );




    }

}
