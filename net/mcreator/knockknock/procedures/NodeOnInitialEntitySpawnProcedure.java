/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class NodeOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity == null) {
            return;
        }
        if (entity instanceof LivingEntity) {
            LivingEntity _entity = entity;
            if (!_entity.m_9236_().m_5776_()) {
                _entity.m_7292_(new MobEffectInstance(MobEffects.f_19621_, 300, 1, false, false));
            }
        }
    }
}
