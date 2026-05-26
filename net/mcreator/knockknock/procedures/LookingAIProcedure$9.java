/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import java.util.Comparator;
import net.minecraft.world.entity.Entity;

class LookingAIProcedure.9 {
    LookingAIProcedure.9() {
    }

    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
        return Comparator.comparingDouble(LookingAIProcedure.9::lambda$compareDistOf$0 /* captured: _x, _y, _z */);
    }
}
