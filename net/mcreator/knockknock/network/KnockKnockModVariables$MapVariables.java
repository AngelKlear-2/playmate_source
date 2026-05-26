/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.network;

import net.mcreator.knockknock.KnockKnockMod;
import net.mcreator.knockknock.network.KnockKnockModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.network.PacketDistributor;

public static class KnockKnockModVariables.MapVariables
extends SavedData {
    public static final String DATA_NAME = "knock_knock_mapvars";
    public boolean plusone = false;
    public boolean Game_started = false;
    public boolean start = false;
    public double count = 60;
    public boolean Countcooldown = false;
    public boolean hiding = false;
    public boolean seeking = false;
    public boolean countover = false;
    public double count2 = 0;
    public boolean countcooldown2 = false;
    public boolean seek = false;
    public double basic_exposure = 30;
    public double light_exposure = 0;
    public double moving_exposure = 0;
    public double place_block_exposure = 0;
    public double break_block_exposure = 0;
    public double accuracy_basic = 20;
    public double accuracy_light = 0;
    public double accuracy_moving = 0;
    public double accuracy_block_place = 0;
    public double accuracy_block_break = 0;
    public double exposure = 0;
    public double accuracy = 0;
    public boolean moving = false;
    public boolean player_founded = false;
    public boolean canseek = false;
    public boolean found = false;
    public double times_founded = 0;
    public boolean player_won = false;
    public boolean player_lose = false;
    public boolean kill = false;
    public boolean returnl = true;
    public boolean movingtoplayerpos = false;
    public double xdoor = 0;
    public double ydoor = 0;
    public double zdoor = 0;
    public boolean screamer = false;
    public double xbed = 0;
    public double ybed = 0;
    public double zbed = 0;
    public boolean setonfire = false;
    public boolean bed_exist = false;
    public boolean recoil = false;
    public boolean bedfiregamerule = true;
    static KnockKnockModVariables.MapVariables clientSide = new KnockKnockModVariables.MapVariables();

    public static KnockKnockModVariables.MapVariables load(CompoundTag tag) {
        MapVariables data = new KnockKnockModVariables.MapVariables();
        data.read(tag);
        return data;
    }

    public void read(CompoundTag nbt) {
        this.plusone = nbt.m_128471_("plusone");
        this.Game_started = nbt.m_128471_("Game_started");
        this.start = nbt.m_128471_("start");
        this.count = nbt.m_128459_("count");
        this.Countcooldown = nbt.m_128471_("Countcooldown");
        this.hiding = nbt.m_128471_("hiding");
        this.seeking = nbt.m_128471_("seeking");
        this.countover = nbt.m_128471_("countover");
        this.count2 = nbt.m_128459_("count2");
        this.countcooldown2 = nbt.m_128471_("countcooldown2");
        this.seek = nbt.m_128471_("seek");
        this.basic_exposure = nbt.m_128459_("basic_exposure");
        this.light_exposure = nbt.m_128459_("light_exposure");
        this.moving_exposure = nbt.m_128459_("moving_exposure");
        this.place_block_exposure = nbt.m_128459_("place_block_exposure");
        this.break_block_exposure = nbt.m_128459_("break_block_exposure");
        this.accuracy_basic = nbt.m_128459_("accuracy_basic");
        this.accuracy_light = nbt.m_128459_("accuracy_light");
        this.accuracy_moving = nbt.m_128459_("accuracy_moving");
        this.accuracy_block_place = nbt.m_128459_("accuracy_block_place");
        this.accuracy_block_break = nbt.m_128459_("accuracy_block_break");
        this.exposure = nbt.m_128459_("exposure");
        this.accuracy = nbt.m_128459_("accuracy");
        this.moving = nbt.m_128471_("moving");
        this.player_founded = nbt.m_128471_("player_founded");
        this.canseek = nbt.m_128471_("canseek");
        this.found = nbt.m_128471_("found");
        this.times_founded = nbt.m_128459_("times_founded");
        this.player_won = nbt.m_128471_("player_won");
        this.player_lose = nbt.m_128471_("player_lose");
        this.kill = nbt.m_128471_("kill");
        this.returnl = nbt.m_128471_("returnl");
        this.movingtoplayerpos = nbt.m_128471_("movingtoplayerpos");
        this.xdoor = nbt.m_128459_("xdoor");
        this.ydoor = nbt.m_128459_("ydoor");
        this.zdoor = nbt.m_128459_("zdoor");
        this.screamer = nbt.m_128471_("screamer");
        this.xbed = nbt.m_128459_("xbed");
        this.ybed = nbt.m_128459_("ybed");
        this.zbed = nbt.m_128459_("zbed");
        this.setonfire = nbt.m_128471_("setonfire");
        this.bed_exist = nbt.m_128471_("bed_exist");
        this.recoil = nbt.m_128471_("recoil");
        this.bedfiregamerule = nbt.m_128471_("bedfiregamerule");
    }

    public CompoundTag m_7176_(CompoundTag nbt) {
        nbt.m_128379_("plusone", this.plusone);
        nbt.m_128379_("Game_started", this.Game_started);
        nbt.m_128379_("start", this.start);
        nbt.m_128347_("count", this.count);
        nbt.m_128379_("Countcooldown", this.Countcooldown);
        nbt.m_128379_("hiding", this.hiding);
        nbt.m_128379_("seeking", this.seeking);
        nbt.m_128379_("countover", this.countover);
        nbt.m_128347_("count2", this.count2);
        nbt.m_128379_("countcooldown2", this.countcooldown2);
        nbt.m_128379_("seek", this.seek);
        nbt.m_128347_("basic_exposure", this.basic_exposure);
        nbt.m_128347_("light_exposure", this.light_exposure);
        nbt.m_128347_("moving_exposure", this.moving_exposure);
        nbt.m_128347_("place_block_exposure", this.place_block_exposure);
        nbt.m_128347_("break_block_exposure", this.break_block_exposure);
        nbt.m_128347_("accuracy_basic", this.accuracy_basic);
        nbt.m_128347_("accuracy_light", this.accuracy_light);
        nbt.m_128347_("accuracy_moving", this.accuracy_moving);
        nbt.m_128347_("accuracy_block_place", this.accuracy_block_place);
        nbt.m_128347_("accuracy_block_break", this.accuracy_block_break);
        nbt.m_128347_("exposure", this.exposure);
        nbt.m_128347_("accuracy", this.accuracy);
        nbt.m_128379_("moving", this.moving);
        nbt.m_128379_("player_founded", this.player_founded);
        nbt.m_128379_("canseek", this.canseek);
        nbt.m_128379_("found", this.found);
        nbt.m_128347_("times_founded", this.times_founded);
        nbt.m_128379_("player_won", this.player_won);
        nbt.m_128379_("player_lose", this.player_lose);
        nbt.m_128379_("kill", this.kill);
        nbt.m_128379_("returnl", this.returnl);
        nbt.m_128379_("movingtoplayerpos", this.movingtoplayerpos);
        nbt.m_128347_("xdoor", this.xdoor);
        nbt.m_128347_("ydoor", this.ydoor);
        nbt.m_128347_("zdoor", this.zdoor);
        nbt.m_128379_("screamer", this.screamer);
        nbt.m_128347_("xbed", this.xbed);
        nbt.m_128347_("ybed", this.ybed);
        nbt.m_128347_("zbed", this.zbed);
        nbt.m_128379_("setonfire", this.setonfire);
        nbt.m_128379_("bed_exist", this.bed_exist);
        nbt.m_128379_("recoil", this.recoil);
        nbt.m_128379_("bedfiregamerule", this.bedfiregamerule);
        return nbt;
    }

    public void syncData(LevelAccessor world) {
        this.m_77762_();
        if (world instanceof Level) {
            if (!world.m_5776_()) {
                KnockKnockMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new KnockKnockModVariables.SavedDataSyncMessage(0, this));
            }
        }
    }

    public static KnockKnockModVariables.MapVariables get(LevelAccessor world) {
        if (world instanceof ServerLevelAccessor) {
            ServerLevelAccessor serverLevelAcc = world;
            return (KnockKnockModVariables.MapVariables)serverLevelAcc.m_6018_().m_7654_().m_129880_(Level.f_46428_).m_8895_().m_164861_(KnockKnockModVariables.MapVariables::lambda$get$0, KnockKnockModVariables.MapVariables::new, "knock_knock_mapvars");
        }
        return clientSide;
    }
}
