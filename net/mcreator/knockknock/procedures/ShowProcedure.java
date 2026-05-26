/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.world.level.LevelAccessor;

public class ShowProcedure {
    public static String execute(LevelAccessor world) {
        if (KnockKnockModVariables.MapVariables.get(world).hiding == 1 && !KnockKnockModVariables.MapVariables.get(world).seeking && !KnockKnockModVariables.MapVariables.get(world).player_founded) {
            return Math.round(KnockKnockModVariables.MapVariables.get(world).count2);
        }
        if (!KnockKnockModVariables.MapVariables.get(world).hiding && KnockKnockModVariables.MapVariables.get(world).seeking == 1) {
            return Math.round(KnockKnockModVariables.MapVariables.get(world).count);
        }
        return "";
    }
}
