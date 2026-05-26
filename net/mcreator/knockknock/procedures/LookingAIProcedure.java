/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.KnockKnockMod;
import net.mcreator.knockknock.entity.NodeEntity;
import net.mcreator.knockknock.init.KnockKnockModEntities;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class LookingAIProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }
        String found_entity_name = "";
        boolean entity_found = false;
        boolean found = false;
        double raytrace_distance = 0;
        double yaw = 0;
        double xpos = 0;
        double ypos = 0;
        double zpos = 0;
        double random = 0;
        double sx = 0;
        double sy = 0;
        double sz = 0;
        if (KnockKnockModVariables.MapVariables.get(world).hiding == 1) {
            if (KnockKnockModVariables.MapVariables.get(world).count2 == 0) {
                if (!entity.m_9236_().m_5776_()) {
                    entity.m_146870_();
                }
            }
        }
        if (KnockKnockModVariables.MapVariables.get(world).countover == 1) {
            random = Math.round(Math.random() * 1000);
        }
        if (random == 1) {
            if (!(world instanceof Level)) { /* goto @212; */ }
            Level _level = world;
            if (!_level.m_5776_()) {
                _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_01")), SoundSource.NEUTRAL, 10f, 1f);
            } else {
                _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_01")), SoundSource.NEUTRAL, 10f, 1f, false);
            }
        } else {
            if (random == 2) {
                if (!(world instanceof Level)) { /* goto @323; */ }
                Level _level = world;
                if (!_level.m_5776_()) {
                    _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_02")), SoundSource.NEUTRAL, 10f, 1f);
                } else {
                    _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_02")), SoundSource.NEUTRAL, 10f, 1f, false);
                }
            } else {
                if (random == 3) {
                    if (!(world instanceof Level)) { /* goto @434; */ }
                    Level _level = world;
                    if (!_level.m_5776_()) {
                        _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_03")), SoundSource.NEUTRAL, 10f, 1f);
                    } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_03")), SoundSource.NEUTRAL, 10f, 1f, false);
                    }
                } else {
                    if (random == 4) {
                        if (!(world instanceof Level)) { /* goto @545; */ }
                        Level _level = world;
                        if (!_level.m_5776_()) {
                            _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_04")), SoundSource.NEUTRAL, 10f, 1f);
                        } else {
                            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:laugh_04")), SoundSource.NEUTRAL, 10f, 1f, false);
                        }
                    } else {
                        if (random == 5) {
                            KnockKnockModVariables.MapVariables.get(world).movingtoplayerpos = true;
                            KnockKnockModVariables.MapVariables.get(world).syncData(world);
                            KnockKnockMod.queueServerWork((int)Mth.m_216263_(RandomSource.m_216327_(), 60, 120), LookingAIProcedure::lambda$execute$0 /* captured: world */);
                        }
                    }
                }
            }
        }
        raytrace_distance = 0;
        entity_found = false;
        for (int index0 = 0; index0 < (int)KnockKnockModVariables.MapVariables.get(world).exposure; index0++) {
            if (!world.m_6443_(Player.class, AABB.m_165882_(new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123343_()), 1, 1, 1), LookingAIProcedure::lambda$execute$1).isEmpty()) {
                if ((Entity)world.m_6443_(LivingEntity.class, AABB.m_165882_(new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123343_()), 1, 1, 1), LookingAIProcedure::lambda$execute$2).stream().sorted(new LookingAIProcedure.1().compareDistOf((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123343_())).findFirst().orElse(null) != entity) {
                    entity_found = true;
                    if ((Entity)world.m_6443_(LivingEntity.class, AABB.m_165882_(new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123343_()), 1, 1, 1), LookingAIProcedure::lambda$execute$3).stream().sorted(new LookingAIProcedure.2().compareDistOf((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123343_())).findFirst().orElse(null) == null) continue;
                    found_entity_name = ((Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123343_()), 1, 1, 1), LookingAIProcedure::lambda$execute$4).stream().sorted(new LookingAIProcedure.3().compareDistOf((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123343_())).findFirst().orElse(null)).m_5446_().getString();
                }
            } else {
                entity_found = false;
                raytrace_distance = raytrace_distance + 1;
            }
        }
        if (entity_found) {
            if (((Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123343_()), 1, 1, 1), LookingAIProcedure::lambda$execute$5).stream().sorted(new LookingAIProcedure.4().compareDistOf((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1f), entity.m_20299_(1f).m_82549_(entity.m_20252_(1f).m_82490_(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).m_82425_().m_123343_())).findFirst().orElse(null)) instanceof Player) {
                xpos = entity.m_20185_();
                ypos = entity.m_20186_();
                zpos = entity.m_20189_();
                yaw = entity.m_146908_();
                if (!entity.m_9236_().m_5776_()) {
                    entity.m_146870_();
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = world;
                    Entity entityToSpawn = ((EntityType)KnockKnockModEntities.ANGRY.get()).m_262496_(_level, BlockPos.m_274561_(xpos, ypos, zpos), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.m_146922_((float)yaw);
                        entityToSpawn.m_5618_((float)yaw);
                        entityToSpawn.m_5616_((float)yaw);
                        entityToSpawn.m_20334_(0, 0, 0);
                    }
                }
            }
        }
        if (KnockKnockModVariables.MapVariables.get(world).accuracy <= 15) {
            Mob _entity = entity;
            if (!world.m_6443_(NodeEntity.class, AABB.m_165882_(new Vec3(x, y, z), 500, 500, 500), LookingAIProcedure::lambda$execute$6).isEmpty() && world.m_6443_(NodeEntity.class, AABB.m_165882_(new Vec3(x, y, z), KnockKnockModVariables.MapVariables.get(world).accuracy, KnockKnockModVariables.MapVariables.get(world).accuracy, KnockKnockModVariables.MapVariables.get(world).accuracy), LookingAIProcedure::lambda$execute$7).isEmpty() && entity instanceof Mob) {
                _entity.m_21573_().m_26519_(((Entity)world.m_6443_(NodeEntity.class, AABB.m_165882_(new Vec3(x, y, z), 500, 500, 500), LookingAIProcedure::lambda$execute$8).stream().sorted(new LookingAIProcedure.5().compareDistOf(x, y, z)).findFirst().orElse(null)).m_20185_(), ((Entity)world.m_6443_(NodeEntity.class, AABB.m_165882_(new Vec3(x, y, z), 500, 500, 500), LookingAIProcedure::lambda$execute$9).stream().sorted(new LookingAIProcedure.6().compareDistOf(x, y, z)).findFirst().orElse(null)).m_20186_(), ((Entity)world.m_6443_(NodeEntity.class, AABB.m_165882_(new Vec3(x, y, z), 500, 500, 500), LookingAIProcedure::lambda$execute$10).stream().sorted(new LookingAIProcedure.7().compareDistOf(x, y, z)).findFirst().orElse(null)).m_20189_(), 1);
            }
            if (!world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 500, 500, 500), LookingAIProcedure::lambda$execute$11).isEmpty()) {
                if (KnockKnockModVariables.MapVariables.get(world).movingtoplayerpos == 1) {
                    if (entity instanceof Mob) {
                        Mob _entity = entity;
                        _entity.m_21573_().m_26519_(((Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 500, 500, 500), LookingAIProcedure::lambda$execute$12).stream().sorted(new LookingAIProcedure.8().compareDistOf(x, y, z)).findFirst().orElse(null)).m_20185_(), ((Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 500, 500, 500), LookingAIProcedure::lambda$execute$13).stream().sorted(new LookingAIProcedure.9().compareDistOf(x, y, z)).findFirst().orElse(null)).m_20186_(), ((Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 500, 500, 500), LookingAIProcedure::lambda$execute$14).stream().sorted(new LookingAIProcedure.10().compareDistOf(x, y, z)).findFirst().orElse(null)).m_20189_(), 1);
                    }
                }
            }
        }
        sx = -3;
        found = false;
        for (int index1 = 0; index1 < 6; index1++) {
            sy = -3;
            for (int index2 = 0; index2 < 6; index2++) {
                sz = -3;
                for (int index3 = 0; index3 < 6; index3++) {
                    if (!world.m_8055_(BlockPos.m_274561_(x + sx, y + sy, z + sz)).m_204336_(BlockTags.create(new ResourceLocation("minecraft:doors")))) continue;
                    KnockKnockModVariables.MapVariables.get(world).xdoor = x + sx;
                    KnockKnockModVariables.MapVariables.get(world).syncData(world);
                    KnockKnockModVariables.MapVariables.get(world).ydoor = y + sy;
                    KnockKnockModVariables.MapVariables.get(world).syncData(world);
                    KnockKnockModVariables.MapVariables.get(world).zdoor = z + sz;
                    KnockKnockModVariables.MapVariables.get(world).syncData(world);
                    Level _level = world.m_8055_(BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor)).m_60734_().m_49965_().m_61081_("open");
                    BooleanProperty _getbp57 = _level;
                    if (!((Boolean)world.m_8055_(BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor)).m_61143_(_getbp57)).booleanValue()) { /* goto @3499; */ }
                    if (_level instanceof BooleanProperty ? 1 : 0 != 0) { /* goto L3834; */ }
                    if (!(world instanceof Level)) continue;
                    _level = world;
                    if (!_level.m_5776_()) {
                        _level.m_5594_(null, BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.NEUTRAL, 1f, 1f);
                    } else {
                        _level.m_7785_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.NEUTRAL, 1f, 1f, false);
                    }
                    BlockPos _pos = BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor);
                    BlockState _bs = world.m_8055_(_pos);
                    Property var36 = _bs.m_60734_().m_49965_().m_61081_("open");
                    if (var36 instanceof BooleanProperty) {
                        BooleanProperty _booleanProp = var36;
                        world.m_7731_(_pos, (BlockState)_bs.m_61124_(_booleanProp, true), 3);
                    }
                    Mob _entity = entity;
                    if (world.m_6443_(Player.class, AABB.m_165882_(new Vec3(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor), 16, 16, 16), LookingAIProcedure::lambda$execute$15).isEmpty() && entity instanceof Mob) continue;
                    _entity.m_21573_().m_26519_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor, 1);
                    found = true;
                    sz = sz + 1;
                }
                sy = sy + 1;
            }
            sx = sx + 1;
        }
    }
}
