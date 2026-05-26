/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.KnockKnockMod;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AngryPlayerCollidesWithThisEntityProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null) {
            return;
        }
        if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
        }
        if (!(world instanceof Level)) { /* goto L124; */ }
        Level _level = world;
        if (!_level.m_5776_()) {
            _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:screamer")), SoundSource.NEUTRAL, 1f, 1f);
        } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:screamer")), SoundSource.NEUTRAL, 1f, 1f, false);
        }
        if (world instanceof ServerLevel) {
            ServerLevel _level = world;
            _level.m_7654_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), null).m_81324_(), "stopsound @a * knock_knock:chase");
        }
        KnockKnockModVariables.MapVariables.get(world).screamer = true;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).seeking = false;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockMod.queueServerWork(20, AngryPlayerCollidesWithThisEntityProcedure::lambda$execute$0 /* captured: sourceentity, world */);
    }
}
