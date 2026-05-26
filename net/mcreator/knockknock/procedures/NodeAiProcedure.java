/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.entity.RehidingEntity;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class NodeAiProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }
        if (entity instanceof LivingEntity) {
            LivingEntity _entity = entity;
            if (!_entity.m_9236_().m_5776_()) {
                _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 60, 1, false, false));
            }
        }
        if (KnockKnockModVariables.MapVariables.get(world).hiding != 1) { /* goto L322; */ }
        if (!world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 1, 1, 1), NodeAiProcedure::lambda$execute$0).isEmpty()) { /* goto L322; */ }
        if (world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 100, 100, 100), NodeAiProcedure::lambda$execute$1).isEmpty()) { /* goto L322; */ }
        Entity _ent = world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 100, 100, 100), NodeAiProcedure::lambda$execute$2).stream().sorted(new NodeAiProcedure.1().compareDistOf(x, y, z)).findFirst().orElse(null);
        if (!(_ent.m_9236_().m_5776_()) && _ent.m_20194_() != null) {
            _ent.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, _ent.m_20182_(), _ent.m_20155_(), _ent.m_9236_() instanceof ServerLevel ? (ServerLevel)_ent.m_9236_() : null, 4, _ent.m_7755_().getString(), _ent.m_5446_(), _ent.m_9236_().m_7654_(), _ent), "tp @e[type=knock_knock:node] ~ ~ ~");
        }
        if (KnockKnockModVariables.MapVariables.get(world).player_founded == 1) {
            if (!entity.m_9236_().m_5776_()) {
                entity.m_146870_();
            }
        }
        if (!world.m_6443_(RehidingEntity.class, AABB.m_165882_(new Vec3(x, y, z), 16, 16, 16), NodeAiProcedure::lambda$execute$3).isEmpty()) {
            if (!entity.m_9236_().m_5776_()) {
                entity.m_146870_();
            }
        }
        if (KnockKnockModVariables.MapVariables.get(world).seeking == 1) {
            LivingEntity _livEnt8 = entity;
            if (!(entity instanceof LivingEntity)|| !_livEnt8.m_21023_(MobEffects.f_19621_)) {
                if (!entity.m_9236_().m_5776_()) {
                    entity.m_146870_();
                }
            }
        }
    }
}
