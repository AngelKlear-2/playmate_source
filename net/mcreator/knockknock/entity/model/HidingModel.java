/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.entity.model;

import net.mcreator.knockknock.entity.HidingEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HidingModel
extends GeoModel<HidingEntity> {
    public ResourceLocation getAnimationResource(HidingEntity entity) {
        return new ResourceLocation("knock_knock", "animations/silly.animation.json");
    }

    public ResourceLocation getModelResource(HidingEntity entity) {
        return new ResourceLocation("knock_knock", "geo/silly.geo.json");
    }

    public ResourceLocation getTextureResource(HidingEntity entity) {
        return new ResourceLocation("knock_knock", "textures/entities/" + entity.getTexture() + ".png");
    }
}
