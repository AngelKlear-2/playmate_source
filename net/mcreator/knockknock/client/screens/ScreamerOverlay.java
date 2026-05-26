/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.client.screens;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.mcreator.knockknock.procedures.ScreamerpProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value={Dist.CLIENT})
public class ScreamerOverlay {
    @SubscribeEvent(priority=EventPriority.HIGHEST)
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
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::m_172817_);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        if (ScreamerpProcedure.execute(world)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("knock_knock:textures/screens/screenshot_20240710-150232_1_copy_1920x1782.png"), 0, 0, 0f, 0f, w, h, w, h);
        }
        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
    }
}
