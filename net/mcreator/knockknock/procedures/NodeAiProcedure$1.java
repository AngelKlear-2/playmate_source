/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import java.util.Comparator;
import net.minecraft.world.entity.Entity;

class NodeAiProcedure.1 {
    NodeAiProcedure.1() {
    }

    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
        return Comparator.comparingDouble(NodeAiProcedure.1::lambda$compareDistOf$0 /* captured: _x, _y, _z */);
    }
}
