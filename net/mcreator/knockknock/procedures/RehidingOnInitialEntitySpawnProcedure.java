/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.KnockKnockMod;
import net.mcreator.knockknock.entity.RehidingEntity;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class RehidingOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }
        if (entity instanceof RehidingEntity) {
            ((RehidingEntity)entity).setAnimation("spotted");
        }
        if (entity instanceof LivingEntity) {
            LivingEntity _entity = entity;
            if (!_entity.m_9236_().m_5776_()) {
                _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 100, false, false));
            }
        }
        KnockKnockModVariables.MapVariables.get(world).canseek = false;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockMod.queueServerWork(40, RehidingOnInitialEntitySpawnProcedure::lambda$execute$0 /* captured: entity */);
        if (!(world instanceof Level)) { /* goto L199; */ }
        Level _level = world;
        if (!_level.m_5776_()) {
            _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_03")), SoundSource.NEUTRAL, 10f, 1f);
        } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_03")), SoundSource.NEUTRAL, 10f, 1f, false);
        }
        entity.m_274367_(2f);
        if (entity instanceof LivingEntity) {
            LivingEntity _entity = entity;
            if (!_entity.m_9236_().m_5776_()) {
                _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 99999, 1, false, false));
            }
        }
    }
}
