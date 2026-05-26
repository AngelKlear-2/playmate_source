/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.world.level.LevelAccessor;

public class BALLS2Procedure {
    public static void execute(LevelAccessor world) {
        KnockKnockModVariables.MapVariables.get(world).bedfiregamerule = true;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
    }
}
