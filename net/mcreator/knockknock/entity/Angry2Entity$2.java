/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

class Angry2Entity.2
extends MeleeAttackGoal {
    Angry2Entity.2(PathfinderMob arg0, double arg1, boolean arg2) {
        super(Angry2Entity.this, arg0, arg1);
    }

    protected double m_6639_(LivingEntity entity) {
        return 4;
    }
}
