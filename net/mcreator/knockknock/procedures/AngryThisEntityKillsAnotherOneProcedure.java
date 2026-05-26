/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AngryThisEntityKillsAnotherOneProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
        if (sourceentity == null) {
            return;
        }
        if (!sourceentity.m_9236_().m_5776_()) {
            sourceentity.m_146870_();
        }
        if (world instanceof ServerLevel) {
            ServerLevel _level = world;
            _level.m_7654_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), null).m_81324_(), "stopsound @a * knock_knock:chase");
        }
        KnockKnockModVariables.MapVariables.get(world).player_founded = false;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
    }
}
