/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.KnockKnockMod;
import net.mcreator.knockknock.procedures.GameOverProcedure;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class PlayerfoundProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }
        GameOverProcedure.execute(world, x, y, z);
        if (entity instanceof LivingEntity) {
            LivingEntity _entity = entity;
            if (!_entity.m_9236_().m_5776_()) {
                _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 99999, 5, false, false));
            }
        }
        KnockKnockMod.queueServerWork(40, PlayerfoundProcedure::lambda$execute$2 /* captured: world, x, y, z, entity */);
    }
}
