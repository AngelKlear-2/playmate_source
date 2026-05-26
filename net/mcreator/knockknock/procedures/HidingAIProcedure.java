/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class HidingAIProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }
        double random = 0;
        double xp = 0;
        double yp = 0;
        double zp = 0;
        if (KnockKnockModVariables.MapVariables.get(world).canseek == 1) {
            random = Math.round(Math.random() * 1250);
        }
        if (random == 1) {
            if (!(world instanceof Level)) { /* goto @148; */ }
            Level _level = world;
            if (!_level.m_5776_()) {
                _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_01")), SoundSource.NEUTRAL, 100f, 1f);
            } else {
                _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_01")), SoundSource.NEUTRAL, 100f, 1f, false);
            }
        } else {
            if (random == 1) {
                if (!(world instanceof Level)) { /* goto @257; */ }
                Level _level = world;
                if (!_level.m_5776_()) {
                    _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_02")), SoundSource.NEUTRAL, 100f, 1f);
                } else {
                    _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_02")), SoundSource.NEUTRAL, 100f, 1f, false);
                }
            } else {
                if (random == 1) {
                    if (!(world instanceof Level)) { /* goto @366; */ }
                    Level _level = world;
                    if (!_level.m_5776_()) {
                        _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_03")), SoundSource.NEUTRAL, 100f, 1f);
                    } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_03")), SoundSource.NEUTRAL, 100f, 1f, false);
                    }
                } else {
                    if (random != 1) { /* goto @475; */ }
                    if (!(world instanceof Level)) { /* goto @475; */ }
                    Level _level = world;
                    if (!_level.m_5776_()) {
                        _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_04")), SoundSource.NEUTRAL, 100f, 1f);
                    } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_04")), SoundSource.NEUTRAL, 100f, 1f, false);
                    }
                }
            }
        }
        if (!world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 4, 4, 4), HidingAIProcedure::lambda$execute$0).isEmpty()) {
            KnockKnockModVariables.MapVariables.get(world).found = true;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
        } else {
            if (world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 4, 4, 4), HidingAIProcedure::lambda$execute$1).isEmpty()) {
                KnockKnockModVariables.MapVariables.get(world).found = false;
                KnockKnockModVariables.MapVariables.get(world).syncData(world);
            }
        }
        if (!KnockKnockModVariables.MapVariables.get(world).seeking) {
            if (!entity.m_9236_().m_5776_()) {
                entity.m_146870_();
            }
        }
    }
}
