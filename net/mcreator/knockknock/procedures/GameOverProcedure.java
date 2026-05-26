/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class GameOverProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        KnockKnockModVariables.MapVariables.get(world).Game_started = false;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).start = false;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).hiding = false;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).seeking = false;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).countover = false;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).player_founded = false;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).player_won = false;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).found = false;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).canseek = false;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).count = 60;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).count2 = 60;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).times_founded = 0;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        if (!(world instanceof Level)) { /* goto L295; */ }
        Level _level = world;
        if (!_level.m_5776_()) {
            _level.m_5594_(null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:game_over")), SoundSource.NEUTRAL, 100f, 1f);
        } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("knock_knock:game_over")), SoundSource.NEUTRAL, 100f, 1f, false);
        }
        if (world instanceof ServerLevel) {
            ServerLevel _level = world;
            _level.m_7654_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), null).m_81324_(), "title @a times 20 20 20");
        }
        if (world instanceof ServerLevel) {
            ServerLevel _level = world;
            _level.m_7654_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), null).m_81324_(), "title @a title {\"text\":\"Game Over\"}");
        }
        if (world instanceof ServerLevel) {
            ServerLevel _level = world;
            _level.m_7654_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), null).m_81324_(), "stopsound @a * knock_knock:game_ost1");
        }
    }
}
