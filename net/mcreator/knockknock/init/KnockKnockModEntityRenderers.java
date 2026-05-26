/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.init;

import net.mcreator.knockknock.client.renderer.Angry2Renderer;
import net.mcreator.knockknock.client.renderer.AngryRenderer;
import net.mcreator.knockknock.client.renderer.HidingRenderer;
import net.mcreator.knockknock.client.renderer.LookingRenderer;
import net.mcreator.knockknock.client.renderer.NodeRenderer;
import net.mcreator.knockknock.client.renderer.RehidingRenderer;
import net.mcreator.knockknock.client.renderer.Trailerdummy2Renderer;
import net.mcreator.knockknock.client.renderer.TrailerdummyRenderer;
import net.mcreator.knockknock.init.KnockKnockModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD, value={Dist.CLIENT})
public class KnockKnockModEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer((EntityType)KnockKnockModEntities.LOOKING.get(), LookingRenderer::new);
        event.registerEntityRenderer((EntityType)KnockKnockModEntities.HIDING.get(), HidingRenderer::new);
        event.registerEntityRenderer((EntityType)KnockKnockModEntities.ANGRY.get(), AngryRenderer::new);
        event.registerEntityRenderer((EntityType)KnockKnockModEntities.REHIDING.get(), RehidingRenderer::new);
        event.registerEntityRenderer((EntityType)KnockKnockModEntities.NODE.get(), NodeRenderer::new);
        event.registerEntityRenderer((EntityType)KnockKnockModEntities.ANGRY_2.get(), Angry2Renderer::new);
        event.registerEntityRenderer((EntityType)KnockKnockModEntities.TRAILERDUMMY.get(), TrailerdummyRenderer::new);
        event.registerEntityRenderer((EntityType)KnockKnockModEntities.TRAILERDUMMY_2.get(), Trailerdummy2Renderer::new);
    }
}
