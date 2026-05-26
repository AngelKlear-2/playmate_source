/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.entity.NodeEntity;
import net.mcreator.knockknock.init.KnockKnockModEntities;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class RehidingAIProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }
        boolean found = false;
        double xpos = 0;
        double ypos = 0;
        double zpos = 0;
        double xp = 0;
        double yp = 0;
        double zp = 0;
        double sx = 0;
        double sy = 0;
        double sz = 0;
        Mob _entity = entity;
        if (!world.m_6443_(NodeEntity.class, AABB.m_165882_(new Vec3(x, y, z), 1000, 1000, 1000), RehidingAIProcedure::lambda$execute$0).isEmpty() && entity instanceof Mob) {
            _entity.m_21573_().m_26519_(((Entity)world.m_6443_(NodeEntity.class, AABB.m_165882_(new Vec3(x, y, z), 1000, 1000, 1000), RehidingAIProcedure::lambda$execute$1).stream().sorted(new RehidingAIProcedure.1().compareDistOf(x, y, z)).findFirst().orElse(null)).m_20185_(), ((Entity)world.m_6443_(NodeEntity.class, AABB.m_165882_(new Vec3(x, y, z), 1000, 1000, 1000), RehidingAIProcedure::lambda$execute$2).stream().sorted(new RehidingAIProcedure.2().compareDistOf(x, y, z)).findFirst().orElse(null)).m_20186_(), ((Entity)world.m_6443_(NodeEntity.class, AABB.m_165882_(new Vec3(x, y, z), 1000, 1000, 1000), RehidingAIProcedure::lambda$execute$3).stream().sorted(new RehidingAIProcedure.3().compareDistOf(x, y, z)).findFirst().orElse(null)).m_20189_(), 1);
        }
        if (!world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 48, 48, 48), RehidingAIProcedure::lambda$execute$4).isEmpty()) {
            KnockKnockModVariables.MapVariables.get(world).returnl = true;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
        }
        if (world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 48, 48, 48), RehidingAIProcedure::lambda$execute$5).isEmpty()) {
            xpos = entity.m_20185_();
            ypos = entity.m_20186_();
            zpos = entity.m_20189_();
            if (world instanceof ServerLevel) {
                ServerLevel _level = world;
                Entity entityToSpawn = ((EntityType)KnockKnockModEntities.HIDING.get()).m_262496_(_level, BlockPos.m_274561_(xpos, ypos, zpos), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.m_20334_(0, 0, 0);
                }
            }
            if (!entity.m_9236_().m_5776_()) {
                entity.m_146870_();
            }
        }
        if (!KnockKnockModVariables.MapVariables.get(world).seeking) {
            if (!entity.m_9236_().m_5776_()) {
                entity.m_146870_();
            }
        }
        sx = -3;
        found = false;
        for (int index0 = 0; index0 < 6; index0++) {
            sy = -3;
            for (int index1 = 0; index1 < 6; index1++) {
                sz = -3;
                for (int index2 = 0; index2 < 6; index2++) {
                    if (!world.m_8055_(BlockPos.m_274561_(x + sx, y + sy, z + sz)).m_204336_(BlockTags.create(new ResourceLocation("minecraft:doors")))) continue;
                    KnockKnockModVariables.MapVariables.get(world).xdoor = x + sx;
                    KnockKnockModVariables.MapVariables.get(world).syncData(world);
                    KnockKnockModVariables.MapVariables.get(world).ydoor = y + sy;
                    KnockKnockModVariables.MapVariables.get(world).syncData(world);
                    KnockKnockModVariables.MapVariables.get(world).zdoor = z + sz;
                    KnockKnockModVariables.MapVariables.get(world).syncData(world);
                    Level _level = world.m_8055_(BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor)).m_60734_().m_49965_().m_61081_("open");
                    BooleanProperty _getbp19 = _level;
                    if (!((Boolean)world.m_8055_(BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor)).m_61143_(_getbp19)).booleanValue()) { /* goto @804; */ }
                    if (_level instanceof BooleanProperty ? 1 : 0 != 0) { /* goto L1032; */ }
                    if (!(world instanceof Level)) continue;
                    _level = world;
                    if (!_level.m_5776_()) {
                        _level.m_5594_(null, BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.NEUTRAL, 1f, 1f);
                    } else {
                        _level.m_7785_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.NEUTRAL, 1f, 1f, false);
                    }
                    BlockPos _pos = BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor);
                    BlockState _bs = world.m_8055_(_pos);
                    Property var34 = _bs.m_60734_().m_49965_().m_61081_("open");
                    if (var34 instanceof BooleanProperty) {
                        BooleanProperty _booleanProp = var34;
                        world.m_7731_(_pos, (BlockState)_bs.m_61124_(_booleanProp, true), 3);
                    }
                    found = true;
                    sz = sz + 1;
                }
                sy = sy + 1;
            }
            sx = sx + 1;
        }
    }
}
