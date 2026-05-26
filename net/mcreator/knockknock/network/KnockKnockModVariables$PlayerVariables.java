/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.network;

import net.mcreator.knockknock.KnockKnockMod;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.PacketDistributor;

public static class KnockKnockModVariables.PlayerVariables {
    public boolean notsleeping = false;
    public double nightsnotslept = 0;

    public void syncPlayerVariables(Entity entity) {
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            KnockKnockMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(KnockKnockModVariables.PlayerVariables::lambda$syncPlayerVariables$0 /* captured: serverPlayer */), new KnockKnockModVariables.PlayerVariablesSyncMessage(this));
        }
    }

    public Tag writeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.m_128379_("notsleeping", this.notsleeping);
        nbt.m_128347_("nightsnotslept", this.nightsnotslept);
        return nbt;
    }

    public void readNBT(Tag Tag) {
        CompoundTag nbt = Tag;
        this.notsleeping = nbt.m_128471_("notsleeping");
        this.nightsnotslept = nbt.m_128459_("nightsnotslept");
    }
}
