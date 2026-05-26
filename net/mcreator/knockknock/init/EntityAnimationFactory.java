/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.init;

import net.mcreator.knockknock.entity.Angry2Entity;
import net.mcreator.knockknock.entity.AngryEntity;
import net.mcreator.knockknock.entity.HidingEntity;
import net.mcreator.knockknock.entity.LookingEntity;
import net.mcreator.knockknock.entity.NodeEntity;
import net.mcreator.knockknock.entity.RehidingEntity;
import net.mcreator.knockknock.entity.Trailerdummy2Entity;
import net.mcreator.knockknock.entity.TrailerdummyEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EntityAnimationFactory {
    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event) {
        if (event != null) {
            if (event.getEntity() != null) {
                String animation = event.getEntity();
                if (animation instanceof LookingEntity) {
                    LookingEntity syncable = animation;
                    animation = syncable.getSyncedAnimation();
                    if (!animation.equals("undefined")) {
                        syncable.setAnimation("undefined");
                        syncable.animationprocedure = animation;
                    }
                }
                String animation = event.getEntity();
                if (animation instanceof HidingEntity) {
                    HidingEntity syncable = animation;
                    animation = syncable.getSyncedAnimation();
                    if (!animation.equals("undefined")) {
                        syncable.setAnimation("undefined");
                        syncable.animationprocedure = animation;
                    }
                }
                String animation = event.getEntity();
                if (animation instanceof AngryEntity) {
                    AngryEntity syncable = animation;
                    animation = syncable.getSyncedAnimation();
                    if (!animation.equals("undefined")) {
                        syncable.setAnimation("undefined");
                        syncable.animationprocedure = animation;
                    }
                }
                String animation = event.getEntity();
                if (animation instanceof RehidingEntity) {
                    RehidingEntity syncable = animation;
                    animation = syncable.getSyncedAnimation();
                    if (!animation.equals("undefined")) {
                        syncable.setAnimation("undefined");
                        syncable.animationprocedure = animation;
                    }
                }
                String animation = event.getEntity();
                if (animation instanceof NodeEntity) {
                    NodeEntity syncable = animation;
                    animation = syncable.getSyncedAnimation();
                    if (!animation.equals("undefined")) {
                        syncable.setAnimation("undefined");
                        syncable.animationprocedure = animation;
                    }
                }
                String animation = event.getEntity();
                if (animation instanceof Angry2Entity) {
                    Angry2Entity syncable = animation;
                    animation = syncable.getSyncedAnimation();
                    if (!animation.equals("undefined")) {
                        syncable.setAnimation("undefined");
                        syncable.animationprocedure = animation;
                    }
                }
                String animation = event.getEntity();
                if (animation instanceof TrailerdummyEntity) {
                    TrailerdummyEntity syncable = animation;
                    animation = syncable.getSyncedAnimation();
                    if (!animation.equals("undefined")) {
                        syncable.setAnimation("undefined");
                        syncable.animationprocedure = animation;
                    }
                }
                String animation = event.getEntity();
                if (animation instanceof Trailerdummy2Entity) {
                    Trailerdummy2Entity syncable = animation;
                    animation = syncable.getSyncedAnimation();
                    if (!animation.equals("undefined")) {
                        syncable.setAnimation("undefined");
                        syncable.animationprocedure = animation;
                    }
                }
            }
        }
    }
}
