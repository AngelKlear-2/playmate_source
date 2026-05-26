/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.client.screens;

import net.mcreator.knockknock.procedures.ShowProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value={Dist.CLIENT})
public class SeekingcountdownOverlay {
    @SubscribeEvent(priority=EventPriority.NORMAL)
    public static void eventHandler(RenderGuiEvent.Pre event) {
        int w = event.getWindow().m_85445_();
        int h = event.getWindow().m_85446_();
        int posX = w / 2;
        int posY = h / 2;
        Level world = null;
        double x = 0;
        double y = 0;
        double z = 0;
        Player entity = Minecraft.m_91087_().f_91074_;
        if (entity != null) {
            world = entity.m_9236_();
            x = entity.m_20185_();
            y = entity.m_20186_();
            z = entity.m_20189_();
        }
        event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, ShowProcedure.execute(world), posX + -13, posY + -101, -1, false);
    }
}
