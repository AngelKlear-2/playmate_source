/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.network;

import java.util.Objects;
import net.mcreator.knockknock.KnockKnockMod;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.network.PacketDistributor;

public static class KnockKnockModVariables.WorldVariables
extends SavedData {
    public static final String DATA_NAME = "knock_knock_worldvars";
    static KnockKnockModVariables.WorldVariables clientSide = new KnockKnockModVariables.WorldVariables();

    public static KnockKnockModVariables.WorldVariables load(CompoundTag tag) {
        WorldVariables data = new KnockKnockModVariables.WorldVariables();
        data.read(tag);
        return data;
    }

    public void read(CompoundTag nbt) {
    }

    public CompoundTag m_7176_(CompoundTag nbt) {
        return nbt;
    }

    public void syncData(LevelAccessor world) {
        this.m_77762_();
        if (world instanceof Level) {
            Level level = world;
            if (!level.m_5776_()) {
                Objects.requireNonNull(level);
                KnockKnockMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::m_46472_), new KnockKnockModVariables.SavedDataSyncMessage(1, this));
            }
        }
    }

    public static KnockKnockModVariables.WorldVariables get(LevelAccessor world) {
        if (world instanceof ServerLevel) {
            ServerLevel level = world;
            return (KnockKnockModVariables.WorldVariables)level.m_8895_().m_164861_(KnockKnockModVariables.WorldVariables::lambda$get$0, KnockKnockModVariables.WorldVariables::new, "knock_knock_worldvars");
        }
        return clientSide;
    }
}
