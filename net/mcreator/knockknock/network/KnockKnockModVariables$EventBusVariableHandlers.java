/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.network;

import net.mcreator.knockknock.KnockKnockMod;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;

@Mod.EventBusSubscriber
public static class KnockKnockModVariables.EventBusVariableHandlers {
    @SubscribeEvent
    public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.getEntity().m_9236_().m_5776_()) {
            ((KnockKnockModVariables.PlayerVariables)event.getEntity().getCapability(KnockKnockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KnockKnockModVariables.PlayerVariables())).syncPlayerVariables(event.getEntity());
        }
    }

    @SubscribeEvent
    public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
        if (!event.getEntity().m_9236_().m_5776_()) {
            ((KnockKnockModVariables.PlayerVariables)event.getEntity().getCapability(KnockKnockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KnockKnockModVariables.PlayerVariables())).syncPlayerVariables(event.getEntity());
        }
    }

    @SubscribeEvent
    public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (!event.getEntity().m_9236_().m_5776_()) {
            ((KnockKnockModVariables.PlayerVariables)event.getEntity().getCapability(KnockKnockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KnockKnockModVariables.PlayerVariables())).syncPlayerVariables(event.getEntity());
        }
    }

    @SubscribeEvent
    public static void clonePlayer(PlayerEvent.Clone event) {
        event.getOriginal().revive();
        PlayerVariables original = event.getOriginal().getCapability(KnockKnockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KnockKnockModVariables.PlayerVariables());
        PlayerVariables clone = event.getEntity().getCapability(KnockKnockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KnockKnockModVariables.PlayerVariables());
        clone.notsleeping = original.notsleeping;
        clone.nightsnotslept = original.nightsnotslept;
        if (!(event.isWasDeath())) {
        }
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.getEntity().m_9236_().m_5776_()) {
            SavedData mapdata = KnockKnockModVariables.MapVariables.get(event.getEntity().m_9236_());
            SavedData worlddata = KnockKnockModVariables.WorldVariables.get(event.getEntity().m_9236_());
            if (mapdata != null) {
                KnockKnockMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(KnockKnockModVariables.EventBusVariableHandlers::lambda$onPlayerLoggedIn$0 /* captured: event */), new KnockKnockModVariables.SavedDataSyncMessage(0, mapdata));
            }
            if (worlddata != null) {
                KnockKnockMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(KnockKnockModVariables.EventBusVariableHandlers::lambda$onPlayerLoggedIn$1 /* captured: event */), new KnockKnockModVariables.SavedDataSyncMessage(1, worlddata));
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (!event.getEntity().m_9236_().m_5776_()) {
            SavedData worlddata = KnockKnockModVariables.WorldVariables.get(event.getEntity().m_9236_());
            if (worlddata != null) {
                KnockKnockMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(KnockKnockModVariables.EventBusVariableHandlers::lambda$onPlayerChangedDimension$2 /* captured: event */), new KnockKnockModVariables.SavedDataSyncMessage(1, worlddata));
            }
        }
    }
}
