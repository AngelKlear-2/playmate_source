/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.procedures;

import javax.annotation.Nullable;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BedclickProcedure {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != event.getEntity().m_7655_()) {
            return;
        }
        BedclickProcedure.execute(event, event.getLevel(), (double)event.getPos().m_123341_(), (double)event.getPos().m_123342_(), (double)event.getPos().m_123343_());
    }

    public static void execute(LevelAccessor world, double x, double y, double z) {
        BedclickProcedure.execute((Event)null, world, x, y, z);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
        if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_204336_(BlockTags.create(new ResourceLocation("minecraft:beds")))) {
            KnockKnockModVariables.MapVariables.get(world).xbed = x;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockModVariables.MapVariables.get(world).ybed = y;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockModVariables.MapVariables.get(world).zbed = z;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
            KnockKnockModVariables.MapVariables.get(world).bed_exist = true;
            KnockKnockModVariables.MapVariables.get(world).syncData(world);
        }
    }
}
