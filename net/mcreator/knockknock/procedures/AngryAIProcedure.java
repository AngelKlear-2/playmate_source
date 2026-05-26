/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AngryAIProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }
        boolean found = false;
        double sx = 0;
        double sy = 0;
        double sz = 0;
        if (!world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 500, 500, 500), AngryAIProcedure::lambda$execute$0).isEmpty()) {
            if (entity instanceof Mob) {
                Mob _entity = entity;
                int index2 = (Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 500, 500, 500), AngryAIProcedure::lambda$execute$1).stream().sorted(new AngryAIProcedure.1().compareDistOf(x, y, z)).findFirst().orElse(null);
                if (index2 instanceof LivingEntity) {
                    LivingEntity _ent = index2;
                    _entity.m_6710_(_ent);
                }
            }
        }
        sx = -3;
        found = false;
        for (int index0 = 0; index0 < 6; index0++) {
            sy = -3;
            for (int index1 = 0; index1 < 6; index1++) {
                sz = -3;
                for (index2 = 0; index2 < 6; index2++) {
                    if (!world.m_8055_(BlockPos.m_274561_(x + sx, y + sy, z + sz)).m_204336_(BlockTags.create(new ResourceLocation("minecraft:doors")))) continue;
                    KnockKnockModVariables.MapVariables.get(world).xdoor = x + sx;
                    KnockKnockModVariables.MapVariables.get(world).syncData(world);
                    KnockKnockModVariables.MapVariables.get(world).ydoor = y + sy;
                    KnockKnockModVariables.MapVariables.get(world).syncData(world);
                    KnockKnockModVariables.MapVariables.get(world).zdoor = z + sz;
                    KnockKnockModVariables.MapVariables.get(world).syncData(world);
                    Level _level = world.m_8055_(BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor)).m_60734_().m_49965_().m_61081_("open");
                    BooleanProperty _getbp6 = _level;
                    if (!((Boolean)world.m_8055_(BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor)).m_61143_(_getbp6)).booleanValue()) { /* goto @425; */ }
                    if (_level instanceof BooleanProperty ? 1 : 0 != 0) { /* goto L759; */ }
                    if (!(world instanceof Level)) continue;
                    _level = world;
                    if (!_level.m_5776_()) {
                        _level.m_5594_(null, BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.NEUTRAL, 1f, 1f);
                    } else {
                        _level.m_7785_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.NEUTRAL, 1f, 1f, false);
                    }
                    BlockPos _pos = BlockPos.m_274561_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor);
                    BlockState _bs = world.m_8055_(_pos);
                    Property var22 = _bs.m_60734_().m_49965_().m_61081_("open");
                    if (var22 instanceof BooleanProperty) {
                        BooleanProperty _booleanProp = var22;
                        world.m_7731_(_pos, (BlockState)_bs.m_61124_(_booleanProp, true), 3);
                    }
                    Mob _entity = entity;
                    if (world.m_6443_(Player.class, AABB.m_165882_(new Vec3(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor), 16, 16, 16), AngryAIProcedure::lambda$execute$2).isEmpty() && entity instanceof Mob) continue;
                    _entity.m_21573_().m_26519_(KnockKnockModVariables.MapVariables.get(world).xdoor, KnockKnockModVariables.MapVariables.get(world).ydoor, KnockKnockModVariables.MapVariables.get(world).zdoor, 0.75);
                    found = true;
                    sz = sz + 1;
                }
                sy = sy + 1;
            }
            sx = sx + 1;
        }
    }
}
