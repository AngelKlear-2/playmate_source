/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.world.level.LevelAccessor;

public class ScreamerpProcedure {
    public static boolean execute(LevelAccessor world) {
        if (KnockKnockModVariables.MapVariables.get(world).screamer == 1) {
            return true;
        }
        return false;
    }
}
