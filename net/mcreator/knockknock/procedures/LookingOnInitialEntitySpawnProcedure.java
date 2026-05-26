/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.KnockKnockMod;
import net.mcreator.knockknock.entity.LookingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class LookingOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null) {
            return;
        }
        if (entity instanceof LivingEntity) {
            LivingEntity _entity = entity;
            if (!_entity.m_9236_().m_5776_()) {
                _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 480, 100, false, false));
            }
        }
        KnockKnockMod.queueServerWork(481, LookingOnInitialEntitySpawnProcedure::lambda$execute$0 /* captured: entity */);
        entity.m_274367_(1.8f);
        if (entity instanceof LookingEntity) {
            ((LookingEntity)entity).setAnimation("count");
        }
    }
}
