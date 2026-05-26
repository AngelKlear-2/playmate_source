/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.entity.model;

import net.mcreator.knockknock.entity.Trailerdummy2Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class Trailerdummy2Model
extends GeoModel<Trailerdummy2Entity> {
    public ResourceLocation getAnimationResource(Trailerdummy2Entity entity) {
        return new ResourceLocation("knock_knock", "animations/silly.animation.json");
    }

    public ResourceLocation getModelResource(Trailerdummy2Entity entity) {
        return new ResourceLocation("knock_knock", "geo/silly.geo.json");
    }

    public ResourceLocation getTextureResource(Trailerdummy2Entity entity) {
        return new ResourceLocation("knock_knock", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(Trailerdummy2Entity animatable, long instanceId, AnimationState animationState) {
        CoreGeoBone head = this.getAnimationProcessor().getBone("head");
        if (head == null) { /* goto L83; */ }
        int unpausedMultiplier = !Minecraft.m_91087_().m_91104_() ? 1 : 0;
        EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        head.setRotX(entityData.headPitch() * 0.017453292f * (float)unpausedMultiplier);
        head.setRotY(entityData.netHeadYaw() * 0.017453292f * (float)unpausedMultiplier);
    }
}
