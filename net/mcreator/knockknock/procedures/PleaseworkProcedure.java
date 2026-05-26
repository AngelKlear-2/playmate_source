/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import javax.annotation.Nullable;
import net.mcreator.knockknock.KnockKnockMod;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.mcreator.knockknock.procedures.GameOverProcedure;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class PleaseworkProcedure {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            PleaseworkProcedure.execute(event, event.player.m_9236_(), event.player.m_20185_(), event.player.m_20186_(), event.player.m_20189_(), event.player);
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        PleaseworkProcedure.execute((Event)null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }
        String found_entity_name = "";
        boolean entity_found = false;
        boolean found = false;
        boolean close = false;
        double raytrace_distance = 0;
        double yaw = 0;
        double rs = 0;
        double random = 0;
        double sx = 0;
        double sy = 0;
        double sz = 0;
        double randomsound = 0;
        double randombedonfire = 0;
        KnockKnockModVariables.MapVariables.get(world).count2 = KnockKnockModVariables.MapVariables.get(world).count2 - 1;
        if (KnockKnockModVariables.MapVariables.get(world).countover == 1 && !KnockKnockModVariables.MapVariables.get(world).countcooldown2) {
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockModVariables.MapVariables.get(world).countcooldown2 = true;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockMod.queueServerWork(20, PleaseworkProcedure::lambda$execute$0 /* captured: world */);
        }
        if (!KnockKnockModVariables.MapVariables.get(world).canseek) {
            if (KnockKnockModVariables.MapVariables.get(world).seeking == 1) {
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity = entity;
                    if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 3, false, false));
                    }
                }
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity = entity;
                    if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19610_, 40, 1, false, false));
                    }
                }
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity = entity;
                    if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 40, 10, false, false));
                    }
                }
            }
        }
        if (KnockKnockModVariables.MapVariables.get(world).player_won == 1) {
            GameOverProcedure.execute(world, x, y, z);
            KnockKnockModVariables.MapVariables.get(world).player_won = false;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockModVariables.MapVariables.get(world).times_founded = 0;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockMod.queueServerWork(60, PleaseworkProcedure::lambda$execute$2 /* captured: world, x, y, z */);
        }
        if (KnockKnockModVariables.MapVariables.get(world).player_lose == 1) {
            KnockKnockModVariables.MapVariables.get(world).player_lose = false;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = entity;
                if (!_entity.m_9236_().m_5776_()) {
                    _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 1200, 5, false, false));
                }
            }
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = entity;
                if (!_entity.m_9236_().m_5776_()) {
                    _entity.m_7292_(new MobEffectInstance(MobEffects.f_19610_, 1200, 1, false, false));
                }
            }
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = entity;
                if (!_entity.m_9236_().m_5776_()) {
                    _entity.m_7292_(new MobEffectInstance(MobEffects.f_19599_, 1200, 1, false, false));
                }
            }
            KnockKnockMod.queueServerWork(80, PleaseworkProcedure::lambda$execute$3 /* captured: world, x, y, z */);
        }
        if (KnockKnockModVariables.MapVariables.get(world).bedfiregamerule == 1 && KnockKnockModVariables.MapVariables.get(world).bed_exist == 1) {
            random = Math.round(Math.random() * 50000);
        }
        if (random == 1) {
            KnockKnockModVariables.MapVariables.get(world).bed_exist = false;
        }
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        if (!(world instanceof Level)) { /* goto L695; */ }
        Level _level = world;
        if (!_level.m_5776_()) {
            _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:yourhouseisonfire")), SoundSource.NEUTRAL, 10f, 1f);
        } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:yourhouseisonfire")), SoundSource.NEUTRAL, 10f, 1f, false);
        }
        world.m_46961_(BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xbed, KnockKnockModVariables.MapVariables.get(world).ybed, KnockKnockModVariables.MapVariables.get(world).zbed), false);
        world.m_7731_(BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xbed - 1, KnockKnockModVariables.MapVariables.get(world).ybed, KnockKnockModVariables.MapVariables.get(world).zbed), Blocks.f_50083_.m_49966_(), 3);
        world.m_7731_(BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xbed + 1, KnockKnockModVariables.MapVariables.get(world).ybed, KnockKnockModVariables.MapVariables.get(world).zbed), Blocks.f_50083_.m_49966_(), 3);
        world.m_7731_(BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xbed, KnockKnockModVariables.MapVariables.get(world).ybed, KnockKnockModVariables.MapVariables.get(world).zbed + 1), Blocks.f_50083_.m_49966_(), 3);
        world.m_7731_(BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xbed, KnockKnockModVariables.MapVariables.get(world).ybed, KnockKnockModVariables.MapVariables.get(world).zbed - 1), Blocks.f_50083_.m_49966_(), 3);
        world.m_7731_(BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xbed, KnockKnockModVariables.MapVariables.get(world).ybed, KnockKnockModVariables.MapVariables.get(world).zbed), Blocks.f_50083_.m_49966_(), 3);
    }
}
