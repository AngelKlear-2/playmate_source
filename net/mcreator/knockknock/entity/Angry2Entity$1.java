/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

class Angry2Entity.1
extends MeleeAttackGoal {
    Angry2Entity.1(PathfinderMob arg0, double arg1, boolean arg2) {
        super(Angry2Entity.this, arg0, arg1);
    }

    protected double m_6639_(LivingEntity entity) {
        return this.f_25540_.m_20205_() * this.f_25540_.m_20205_() + entity.m_20205_();
    }
}
