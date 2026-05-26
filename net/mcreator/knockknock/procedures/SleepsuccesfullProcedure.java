/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import javax.annotation.Nullable;
import net.mcreator.knockknock.KnockKnockMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SleepsuccesfullProcedure {
    @SubscribeEvent
    public static void onEntityEndSleep(PlayerWakeUpEvent event) {
        SleepsuccesfullProcedure.execute(event, event.getEntity().m_9236_(), event.getEntity());
    }

    public static void execute(LevelAccessor world, Entity entity) {
        SleepsuccesfullProcedure.execute((Event)null, world, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
        if (entity == null) {
            return;
        }
        KnockKnockMod.queueServerWork(10, SleepsuccesfullProcedure::lambda$execute$1 /* captured: world, entity */);
    }
}
