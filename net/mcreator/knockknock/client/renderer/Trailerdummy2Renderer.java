/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.knockknock.entity.Trailerdummy2Entity;
import net.mcreator.knockknock.entity.layer.Trailerdummy2Layer;
import net.mcreator.knockknock.entity.model.Trailerdummy2Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class Trailerdummy2Renderer
extends GeoEntityRenderer<Trailerdummy2Entity> {
    public Trailerdummy2Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Trailerdummy2Model());
        this.f_114477_ = 0.5f;
        this.addRenderLayer(new Trailerdummy2Layer(this));
    }

    public RenderType getRenderType(Trailerdummy2Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.m_110473_(this.m_5478_(animatable));
    }

    public void preRender(PoseStack poseStack, Trailerdummy2Entity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        float scale = 0.9f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
