/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import java.util.Comparator;
import net.minecraft.world.entity.Entity;

class LookingAIProcedure.4 {
    LookingAIProcedure.4() {
    }

    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
        return Comparator.comparingDouble(LookingAIProcedure.4::lambda$compareDistOf$0 /* captured: _x, _y, _z */);
    }
}
