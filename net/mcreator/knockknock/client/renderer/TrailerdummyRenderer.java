/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.knockknock.entity.TrailerdummyEntity;
import net.mcreator.knockknock.entity.layer.TrailerdummyLayer;
import net.mcreator.knockknock.entity.model.TrailerdummyModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TrailerdummyRenderer
extends GeoEntityRenderer<TrailerdummyEntity> {
    public TrailerdummyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TrailerdummyModel());
        this.f_114477_ = 0.5f;
        this.addRenderLayer(new TrailerdummyLayer(this));
    }

    public RenderType getRenderType(TrailerdummyEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.m_110473_(this.m_5478_(animatable));
    }

    public void preRender(PoseStack poseStack, TrailerdummyEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        float scale = 0.9f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
