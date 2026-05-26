/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.network;

import java.util.function.Supplier;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.network.NetworkEvent;

public static class KnockKnockModVariables.SavedDataSyncMessage {
    public int type;
    public SavedData data;

    public KnockKnockModVariables.SavedDataSyncMessage(FriendlyByteBuf buffer) {
        this.type = buffer.readInt();
        this.data = this.type == 0 ? new KnockKnockModVariables.MapVariables() : new KnockKnockModVariables.WorldVariables();
        var var4 = this.data;
        if (var4 instanceof KnockKnockModVariables.MapVariables) {
            MapVariables _mapvars = var4;
            _mapvars.read(buffer.m_130260_());
        } else {
            var4 = this.data;
            if (var4 instanceof KnockKnockModVariables.WorldVariables) {
                WorldVariables _worldvars = var4;
                _worldvars.read(buffer.m_130260_());
            }
        }
    }

    public KnockKnockModVariables.SavedDataSyncMessage(int type, SavedData data) {
        this.type = type;
        this.data = data;
    }

    public static void buffer(KnockKnockModVariables.SavedDataSyncMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.type);
        buffer.m_130079_(message.data.m_7176_(new CompoundTag()));
    }

    public static void handler(KnockKnockModVariables.SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        Context context = contextSupplier.get();
        context.enqueueWork(KnockKnockModVariables.SavedDataSyncMessage::lambda$handler$0 /* captured: context, message */);
        context.setPacketHandled(true);
    }
}
