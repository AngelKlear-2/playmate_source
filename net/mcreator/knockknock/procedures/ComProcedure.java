/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.world.entity.Entity;

public class ComProcedure {
    public static void execute(Entity entity) {
        if (entity == null) {
            return;
        }
        double _setval = 3;
        entity.getCapability(KnockKnockModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(ComProcedure::lambda$execute$0 /* captured: _setval, entity */);
    }
}
