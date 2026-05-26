/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.world.level.LevelAccessor;

public class ReturnlProcedure {
    public static boolean execute(LevelAccessor world) {
        if (KnockKnockModVariables.MapVariables.get(world).returnl == 1) {
            return true;
        }
        return false;
    }
}
