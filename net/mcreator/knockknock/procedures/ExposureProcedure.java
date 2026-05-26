/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import javax.annotation.Nullable;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ExposureProcedure {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            ExposureProcedure.execute(event, event.player.m_9236_(), event.player);
        }
    }

    public static void execute(LevelAccessor world, Entity entity) {
        ExposureProcedure.execute((Event)null, world, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
        if (entity == null) {
            return;
        }
        double random = 0;
        KnockKnockModVariables.MapVariables.get(world).exposure = KnockKnockModVariables.MapVariables.get(world).basic_exposure + KnockKnockModVariables.MapVariables.get(world).light_exposure + KnockKnockModVariables.MapVariables.get(world).moving_exposure + KnockKnockModVariables.MapVariables.get(world).place_block_exposure + KnockKnockModVariables.MapVariables.get(world).break_block_exposure;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).accuracy = KnockKnockModVariables.MapVariables.get(world).accuracy_basic - (KnockKnockModVariables.MapVariables.get(world).accuracy_moving + KnockKnockModVariables.MapVariables.get(world).accuracy_light + KnockKnockModVariables.MapVariables.get(world).accuracy_block_place + KnockKnockModVariables.MapVariables.get(world).accuracy_block_break);
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).light_exposure = 0;
        if (world.m_46803_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_())) >= 0 && world.m_46803_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_())) <= 7) {
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockModVariables.MapVariables.get(world).accuracy_light = 0;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
        }
        KnockKnockModVariables.MapVariables.get(world).light_exposure = 15;
        if (world.m_46803_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_())) >= 8 && world.m_46803_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_())) <= 12) {
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockModVariables.MapVariables.get(world).accuracy_light = 3;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
        }
        KnockKnockModVariables.MapVariables.get(world).light_exposure = 20;
        if (world.m_46803_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_())) >= 13 && world.m_46803_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_())) <= 15) {
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockModVariables.MapVariables.get(world).accuracy_light = 5;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
        }
        if (entity.m_20184_().m_7096_() <= 0) {
            if (entity.m_20184_().m_7098_() <= 0) {
                if (entity.m_20184_().m_7094_() > 0) {
                    if (entity.m_20142_()) { /* goto @459; */ }
                }
            }
        }
        KnockKnockModVariables.MapVariables.get(world).moving_exposure = 10;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).accuracy_moving = 3;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        if (entity.m_20142_()) {
            KnockKnockModVariables.MapVariables.get(world).moving_exposure = 20;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockModVariables.MapVariables.get(world).accuracy_moving = 5;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
        }
        if (entity.m_6144_()) {
            KnockKnockModVariables.MapVariables.get(world).moving_exposure = -5;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
        }
        KnockKnockModVariables.MapVariables.get(world).moving_exposure = 0;
        if (!entity.m_20142_() && !entity.m_6144_()) {
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockModVariables.MapVariables.get(world).accuracy_moving = 0;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
        }
        if (KnockKnockModVariables.MapVariables.get(world).accuracy < 0) {
            KnockKnockModVariables.MapVariables.get(world).accuracy = 0;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
        }
    }
}
