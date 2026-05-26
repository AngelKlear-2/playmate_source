/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.entity.model;

import net.mcreator.knockknock.entity.RehidingEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RehidingModel
extends GeoModel<RehidingEntity> {
    public ResourceLocation getAnimationResource(RehidingEntity entity) {
        return new ResourceLocation("knock_knock", "animations/silly.animation.json");
    }

    public ResourceLocation getModelResource(RehidingEntity entity) {
        return new ResourceLocation("knock_knock", "geo/silly.geo.json");
    }

    public ResourceLocation getTextureResource(RehidingEntity entity) {
        return new ResourceLocation("knock_knock", "textures/entities/" + entity.getTexture() + ".png");
    }
}
