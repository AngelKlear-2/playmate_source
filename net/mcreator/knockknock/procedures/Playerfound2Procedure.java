/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.KnockKnockMod;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class Playerfound2Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }
        KnockKnockMod.queueServerWork(40, Playerfound2Procedure::lambda$execute$0 /* captured: world, x, y, z */);
        if (entity instanceof LivingEntity) {
            LivingEntity _entity = entity;
            if (!_entity.m_9236_().m_5776_()) {
                _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 99999, 5, false, false));
            }
        }
        entity.m_274367_(2f);
        if (world instanceof ServerLevel) {
            ServerLevel _level = world;
            _level.m_7654_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), null).m_81324_(), "stopsound @a * knock_knock:game_ost1");
        }
    }
}
