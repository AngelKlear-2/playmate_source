/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.entity;

import net.mcreator.knockknock.procedures.ReturnlProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

class RehidingEntity.1
extends AvoidEntityGoal<Player> {
    RehidingEntity.1(PathfinderMob arg0, Class arg1, float arg2, double arg3, double arg4) {
        super(RehidingEntity.this, arg0, arg1, arg2, arg3);
    }

    public boolean m_8036_() {
        double x = RehidingEntity.this.m_20185_();
        double y = RehidingEntity.this.m_20186_();
        double z = RehidingEntity.this.m_20189_();
        Entity entity = RehidingEntity.this;
        Level world = RehidingEntity.this.m_9236_();
        return super.m_8036_() && ReturnlProcedure.execute(world);
    }

    public boolean m_8045_() {
        double x = RehidingEntity.this.m_20185_();
        double y = RehidingEntity.this.m_20186_();
        double z = RehidingEntity.this.m_20189_();
        Entity entity = RehidingEntity.this;
        Level world = RehidingEntity.this.m_9236_();
        return super.m_8045_() && ReturnlProcedure.execute(world);
    }
}
