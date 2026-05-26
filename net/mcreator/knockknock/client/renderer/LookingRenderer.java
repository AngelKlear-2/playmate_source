/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.knockknock.entity.LookingEntity;
import net.mcreator.knockknock.entity.layer.LookingLayer;
import net.mcreator.knockknock.entity.model.LookingModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LookingRenderer
extends GeoEntityRenderer<LookingEntity> {
    public LookingRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LookingModel());
        this.f_114477_ = 0.5f;
        this.addRenderLayer(new LookingLayer(this));
    }

    public RenderType getRenderType(LookingEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.m_110473_(this.m_5478_(animatable));
    }

    public void preRender(PoseStack poseStack, LookingEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        float scale = 0.9f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
