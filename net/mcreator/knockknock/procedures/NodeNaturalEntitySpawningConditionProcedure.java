/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.entity.NodeEntity;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class NodeNaturalEntitySpawningConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        if (KnockKnockModVariables.MapVariables.get(world).seeking == 1 || KnockKnockModVariables.MapVariables.get(world).hiding == 1) {
            if (world.m_6443_(NodeEntity.class, AABB.m_165882_(new Vec3(x, y, z), 9000, 9000, 9000), NodeNaturalEntitySpawningConditionProcedure::lambda$execute$0).isEmpty()) {
                if (world.m_46861_(BlockPos.m_274561_(x, y, z))) {
                    return true;
                }
            }
        }
        return false;
    }
}
