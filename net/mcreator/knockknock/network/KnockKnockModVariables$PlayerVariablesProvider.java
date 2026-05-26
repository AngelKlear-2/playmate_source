/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.network;

import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.core.Direction;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
private static class KnockKnockModVariables.PlayerVariablesProvider
implements ICapabilitySerializable<Tag> {
    private final KnockKnockModVariables.PlayerVariables playerVariables = new KnockKnockModVariables.PlayerVariables();
    private final LazyOptional<KnockKnockModVariables.PlayerVariables> instance;

    private KnockKnockModVariables.PlayerVariablesProvider() {
        this.instance = LazyOptional.of(this::lambda$new$0);
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            if (!(event.getObject() instanceof FakePlayer)) {
                event.addCapability(new ResourceLocation("knock_knock", "player_variables"), new KnockKnockModVariables.PlayerVariablesProvider());
            }
        }
    }

    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == KnockKnockModVariables.PLAYER_VARIABLES_CAPABILITY ? this.instance.cast() : LazyOptional.empty();
    }

    public Tag serializeNBT() {
        return this.playerVariables.writeNBT();
    }

    public void deserializeNBT(Tag nbt) {
        this.playerVariables.readNBT(nbt);
    }
}
