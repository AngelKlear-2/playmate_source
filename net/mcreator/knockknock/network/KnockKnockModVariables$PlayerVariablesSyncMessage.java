/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.network;

import java.util.function.Supplier;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public static class KnockKnockModVariables.PlayerVariablesSyncMessage {
    public KnockKnockModVariables.PlayerVariables data;

    public KnockKnockModVariables.PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
        this.data = new KnockKnockModVariables.PlayerVariables();
        this.data.readNBT(buffer.m_130260_());
    }

    public KnockKnockModVariables.PlayerVariablesSyncMessage(KnockKnockModVariables.PlayerVariables data) {
        this.data = data;
    }

    public static void buffer(KnockKnockModVariables.PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
        buffer.m_130079_((CompoundTag)message.data.writeNBT());
    }

    public static void handler(KnockKnockModVariables.PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        Context context = contextSupplier.get();
        context.enqueueWork(KnockKnockModVariables.PlayerVariablesSyncMessage::lambda$handler$0 /* captured: context, message */);
        context.setPacketHandled(true);
    }
}
