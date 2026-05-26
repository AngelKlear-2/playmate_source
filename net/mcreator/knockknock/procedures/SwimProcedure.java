/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import javax.annotation.Nullable;
import net.mcreator.knockknock.entity.Angry2Entity;
import net.mcreator.knockknock.entity.AngryEntity;
import net.mcreator.knockknock.entity.RehidingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SwimProcedure {
    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event) {
        SwimProcedure.execute(event, event.getEntity());
    }

    public static void execute(Entity entity) {
        SwimProcedure.execute((Event)null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity == null) {
            return;
        }
        if (entity instanceof RehidingEntity) {
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = entity;
                if (!_entity.m_9236_().m_5776_()) {
                    _entity.m_7292_(new MobEffectInstance(MobEffects.f_19593_, 20, 1, false, false));
                }
            }
        }
        if (entity instanceof AngryEntity) {
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = entity;
                if (!_entity.m_9236_().m_5776_()) {
                    _entity.m_7292_(new MobEffectInstance(MobEffects.f_19593_, 20, 1, false, false));
                }
            }
        }
        if (entity instanceof Angry2Entity) {
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = entity;
                if (!_entity.m_9236_().m_5776_()) {
                    _entity.m_7292_(new MobEffectInstance(MobEffects.f_19593_, 20, 1, false, false));
                }
            }
        }
    }
}
