/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KnockKnockModSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "knock_knock");
    public static final RegistryObject<SoundEvent> PLAYMATE_COUNTING = REGISTRY.register("playmate_counting", KnockKnockModSounds::lambda$static$0);
    public static final RegistryObject<SoundEvent> PLAYMATE_SEEKING = REGISTRY.register("playmate_seeking", KnockKnockModSounds::lambda$static$1);
    public static final RegistryObject<SoundEvent> PLAYMATE_HIDING = REGISTRY.register("playmate_hiding", KnockKnockModSounds::lambda$static$2);
    public static final RegistryObject<SoundEvent> GAME_OVER = REGISTRY.register("game_over", KnockKnockModSounds::lambda$static$3);
    public static final RegistryObject<SoundEvent> LOOSE = REGISTRY.register("loose", KnockKnockModSounds::lambda$static$4);
    public static final RegistryObject<SoundEvent> WIN = REGISTRY.register("win", KnockKnockModSounds::lambda$static$5);
    public static final RegistryObject<SoundEvent> LETS_PLAY_AGAIN = REGISTRY.register("lets_play_again", KnockKnockModSounds::lambda$static$6);
    public static final RegistryObject<SoundEvent> LAUGH_01 = REGISTRY.register("laugh_01", KnockKnockModSounds::lambda$static$7);
    public static final RegistryObject<SoundEvent> LAUGH_02 = REGISTRY.register("laugh_02", KnockKnockModSounds::lambda$static$8);
    public static final RegistryObject<SoundEvent> LAUGH_03 = REGISTRY.register("laugh_03", KnockKnockModSounds::lambda$static$9);
    public static final RegistryObject<SoundEvent> LAUGH_04 = REGISTRY.register("laugh_04", KnockKnockModSounds::lambda$static$10);
    public static final RegistryObject<SoundEvent> YOURHOUSEISONFIRE = REGISTRY.register("yourhouseisonfire", KnockKnockModSounds::lambda$static$11);
    public static final RegistryObject<SoundEvent> PLAYER_SPOTTED = REGISTRY.register("player_spotted", KnockKnockModSounds::lambda$static$12);
    public static final RegistryObject<SoundEvent> YOUSEEKING = REGISTRY.register("youseeking", KnockKnockModSounds::lambda$static$13);
    public static final RegistryObject<SoundEvent> GAME_OST = REGISTRY.register("game_ost", KnockKnockModSounds::lambda$static$14);
    public static final RegistryObject<SoundEvent> HIDE = REGISTRY.register("hide", KnockKnockModSounds::lambda$static$15);
    public static final RegistryObject<SoundEvent> TIME_IS_UP = REGISTRY.register("time_is_up", KnockKnockModSounds::lambda$static$16);
    public static final RegistryObject<SoundEvent> GAME_OST1 = REGISTRY.register("game_ost1", KnockKnockModSounds::lambda$static$17);
    public static final RegistryObject<SoundEvent> CHASE = REGISTRY.register("chase", KnockKnockModSounds::lambda$static$18);
    public static final RegistryObject<SoundEvent> SCREAMER = REGISTRY.register("screamer", KnockKnockModSounds::lambda$static$19);
    public static final RegistryObject<SoundEvent> ON_FIRE = REGISTRY.register("on_fire", KnockKnockModSounds::lambda$static$20);
}
