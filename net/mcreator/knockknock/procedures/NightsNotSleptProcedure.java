/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import javax.annotation.Nullable;
import net.mcreator.knockknock.KnockKnockMod;
import net.mcreator.knockknock.entity.LookingEntity;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.mcreator.knockknock.procedures.GameOverProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class NightsNotSleptProcedure {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            NightsNotSleptProcedure.execute(event, event.player.m_9236_(), event.player.m_20185_(), event.player.m_20186_(), event.player.m_20189_(), event.player);
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        NightsNotSleptProcedure.execute((Event)null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }
        double random = 0;
        double randomgame = 0;
        if (!KnockKnockModVariables.MapVariables.get(world).Game_started) {
            Level _lvl0 = world;
            if (!(world instanceof Level)|| !_lvl0.m_46461_()) {
                boolean _setval = true;
                entity.getCapability(KnockKnockModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(NightsNotSleptProcedure::lambda$execute$0 /* captured: _setval, entity */);
                KnockKnockModVariables.MapVariables.get(world).plusone = false;
                KnockKnockModVariables.MapVariables.get(world).syncData(world);
                if (((KnockKnockModVariables.PlayerVariables)entity.getCapability(KnockKnockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KnockKnockModVariables.PlayerVariables())).nightsnotslept >= 2) {
                    random = Math.round(Math.random() * 100);
                    if (random == 1) {
                        KnockKnockModVariables.MapVariables.get(world).Game_started = true;
                        KnockKnockModVariables.MapVariables.get(world).syncData(world);
                        double _setval = false;
                        entity.getCapability(KnockKnockModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(NightsNotSleptProcedure::lambda$execute$1 /* captured: _setval, entity */);
                    }
                }
            }
            if (world instanceof Level) {
                Level _lvl1 = world;
                if (_lvl1.m_46461_()) {
                    if (((KnockKnockModVariables.PlayerVariables)entity.getCapability(KnockKnockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KnockKnockModVariables.PlayerVariables())).notsleeping == 1) {
                        if (!KnockKnockModVariables.MapVariables.get(world).plusone) {
                            KnockKnockModVariables.MapVariables.get(world).plusone = true;
                            KnockKnockModVariables.MapVariables.get(world).syncData(world);
                            double _setval = ((KnockKnockModVariables.PlayerVariables)entity.getCapability(KnockKnockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KnockKnockModVariables.PlayerVariables())).nightsnotslept + 1;
                            entity.getCapability(KnockKnockModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(NightsNotSleptProcedure::lambda$execute$2 /* captured: _setval, entity */);
                        }
                    }
                }
            }
        }
        if (KnockKnockModVariables.MapVariables.get(world).Game_started == 1) {
            randomgame = Math.round(Math.random() * 1);
        }
        if (randomgame == 0) {
            if (!(KnockKnockModVariables.MapVariables.get(world).start)) {
                KnockKnockModVariables.MapVariables.get(world).start = true;
            }
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            if (!(world instanceof Level)) { /* goto L457; */ }
            Level _level = world;
            if (!_level.m_5776_()) {
                _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:hide")), SoundSource.NEUTRAL, 100f, 1f);
            } else {
                _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:hide")), SoundSource.NEUTRAL, 100f, 1f, false);
            }
            if (world instanceof ServerLevel) {
                ServerLevel _level = world;
                _level.m_7654_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), null).m_81324_(), "title @a times 20 20 20");
            }
            if (world instanceof ServerLevel) {
                ServerLevel _level = world;
                _level.m_7654_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), null).m_81324_(), "title @a title {\"text\":\"You are...\"}");
            }
            KnockKnockMod.queueServerWork(60, NightsNotSleptProcedure::lambda$execute$5 /* captured: world, x, y, z, entity */);
        } else {
            if (randomgame == 1 && !(KnockKnockModVariables.MapVariables.get(world).start)) {
                KnockKnockModVariables.MapVariables.get(world).start = true;
            }
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            if (!(world instanceof Level)) { /* goto L762; */ }
            Level _level = world;
            if (!_level.m_5776_()) {
                _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:youseeking")), SoundSource.NEUTRAL, 100f, 1f);
            } else {
                _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:youseeking")), SoundSource.NEUTRAL, 100f, 1f, false);
            }
            if (world instanceof ServerLevel) {
                ServerLevel _level = world;
                _level.m_7654_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), null).m_81324_(), "title @a times 20 20 20");
            }
            if (world instanceof ServerLevel) {
                ServerLevel _level = world;
                _level.m_7654_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), null).m_81324_(), "title @a title {\"text\":\"You are...\"}");
            }
            KnockKnockMod.queueServerWork(60, NightsNotSleptProcedure::lambda$execute$6 /* captured: world, x, y, z */);
        }
        KnockKnockModVariables.MapVariables.get(world).Countcooldown = true;
        if (KnockKnockModVariables.MapVariables.get(world).canseek == 1 && KnockKnockModVariables.MapVariables.get(world).seeking == 1 && !KnockKnockModVariables.MapVariables.get(world).Countcooldown) {
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockModVariables.MapVariables.get(world).count = KnockKnockModVariables.MapVariables.get(world).count - 1;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockMod.queueServerWork(20, NightsNotSleptProcedure::lambda$execute$7 /* captured: world */);
        }
        KnockKnockModVariables.MapVariables.get(world).count = 60;
        if (!KnockKnockModVariables.MapVariables.get(world).seeking && !KnockKnockModVariables.MapVariables.get(world).hiding) {
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockModVariables.MapVariables.get(world).count2 = 60;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
        }
        if (KnockKnockModVariables.MapVariables.get(world).hiding == 1) {
            if (KnockKnockModVariables.MapVariables.get(world).count2 == 0) {
                KnockKnockModVariables.MapVariables.get(world).countover = false;
                KnockKnockModVariables.MapVariables.get(world).syncData(world);
                GameOverProcedure.execute(world, x, y, z);
                if (!world.m_6443_(LookingEntity.class, AABB.m_165882_(new Vec3(x, y, z), 5000, 5000, 5000), NightsNotSleptProcedure::lambda$execute$8).isEmpty()) {
                    if (!((Entity)world.m_6443_(LookingEntity.class, AABB.m_165882_(new Vec3(x, y, z), 5000, 5000, 5000), NightsNotSleptProcedure::lambda$execute$9).stream().sorted(new NightsNotSleptProcedure.1().compareDistOf(x, y, z)).findFirst().orElse(null)).m_9236_().m_5776_()) {
                        ((Entity)world.m_6443_(LookingEntity.class, AABB.m_165882_(new Vec3(x, y, z), 5000, 5000, 5000), NightsNotSleptProcedure::lambda$execute$10).stream().sorted(new NightsNotSleptProcedure.2().compareDistOf(x, y, z)).findFirst().orElse(null)).m_146870_();
                    }
                }
                KnockKnockMod.queueServerWork(60, NightsNotSleptProcedure::lambda$execute$12 /* captured: world, x, y, z */);
            }
        }
        KnockKnockModVariables.MapVariables.get(world).countover = false;
        if (KnockKnockModVariables.MapVariables.get(world).seeking == 1 && KnockKnockModVariables.MapVariables.get(world).count == 0) {
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            GameOverProcedure.execute(world, x, y, z);
            KnockKnockMod.queueServerWork(60, NightsNotSleptProcedure::lambda$execute$15 /* captured: world, x, y, z */);
        }
    }
}
