/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import javax.annotation.Nullable;
import net.mcreator.knockknock.KnockKnockMod;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BlockbrokenprocedureProcedure {
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        BlockbrokenprocedureProcedure.execute(event, event.getLevel());
    }

    public static void execute(LevelAccessor world) {
        BlockbrokenprocedureProcedure.execute((Event)null, world);
    }

    private static void execute(@Nullable Event event, LevelAccessor world) {
        KnockKnockModVariables.MapVariables.get(world).break_block_exposure = 10;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockModVariables.MapVariables.get(world).accuracy_block_break = 5;
        KnockKnockModVariables.MapVariables.get(world).syncData(world);
        KnockKnockMod.queueServerWork(120, BlockbrokenprocedureProcedure::lambda$execute$0 /* captured: world */);
    }
}
