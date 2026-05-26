/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.entity;

import javax.annotation.Nullable;
import net.mcreator.knockknock.init.KnockKnockModEntities;
import net.mcreator.knockknock.procedures.LookingAIProcedure;
import net.mcreator.knockknock.procedures.LookingOnInitialEntitySpawnProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class LookingEntity
extends Monster
implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.m_135353_(LookingEntity.class, EntityDataSerializers.f_135035_);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.m_135353_(LookingEntity.class, EntityDataSerializers.f_135030_);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.m_135353_(LookingEntity.class, EntityDataSerializers.f_135030_);
    private final AnimatableInstanceCache cache;
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure;

    public LookingEntity(PlayMessages.SpawnEntity packet, Level world) {
        this((EntityType)KnockKnockModEntities.LOOKING.get(), world);
    }

    public LookingEntity(EntityType<LookingEntity> type, Level world) {
        super(type, world);
        this.cache = GeckoLibUtil.createInstanceCache(this);
        this.animationprocedure = "empty";
        this.f_21364_ = 0;
        this.m_21557_(false);
        this.m_21530_();
    }

    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(SHOOT, false);
        this.f_19804_.m_135372_(ANIMATION, "undefined");
        this.f_19804_.m_135372_(TEXTURE, "realseeking");
    }

    public void setTexture(String texture) {
        this.f_19804_.m_135381_(TEXTURE, texture);
    }

    public String getTexture() {
        return this.f_19804_.m_135370_(TEXTURE);
    }

    protected float m_6431_(Pose poseIn, EntityDimensions sizeIn) {
        return 1.8f;
    }

    public Packet<ClientGamePacketListener> m_5654_() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    protected void m_8099_() {
        super.m_8099_();
        this.f_21346_.m_25352_(1, new NearestAttackableTargetGoal(this, Player.class, true, false));
        this.f_21345_.m_25352_(2, new LookingEntity.1(this, this, 1, false));
        this.f_21345_.m_25352_(3, new LookAtPlayerGoal(this, Player.class, 80f));
        this.f_21345_.m_25352_(4, new RandomStrollGoal(this, 1));
        this.f_21345_.m_25352_(5, new RandomLookAroundGoal(this));
        this.f_21345_.m_25352_(6, new FloatGoal(this));
    }

    public MobType m_6336_() {
        return MobType.f_21640_;
    }

    public boolean m_6785_(double distanceToClosestPlayer) {
        return false;
    }

    public SoundEvent m_7975_(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
    }

    public SoundEvent m_5592_() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
    }

    public boolean m_6469_(DamageSource source, float amount) {
        if (source.m_276093_(DamageTypes.f_268631_)) {
            return false;
        }
        if (source.m_7640_() instanceof AbstractArrow) {
            return false;
        }
        if (source.m_7640_() instanceof Player) {
            return false;
        }
        if (source.m_7640_() instanceof ThrownPotion || source.m_7640_() instanceof AreaEffectCloud) {
            return false;
        }
        if (source.m_276093_(DamageTypes.f_268671_)) {
            return false;
        }
        if (source.m_276093_(DamageTypes.f_268585_)) {
            return false;
        }
        if (source.m_276093_(DamageTypes.f_268722_)) {
            return false;
        }
        if (source.m_276093_(DamageTypes.f_268450_)) {
            return false;
        }
        if (source.m_276093_(DamageTypes.f_268565_)) {
            return false;
        }
        if (source.m_276093_(DamageTypes.f_268714_)) {
            return false;
        }
        if (source.m_276093_(DamageTypes.f_268526_)) {
            return false;
        }
        if (source.m_276093_(DamageTypes.f_268482_)) {
            return false;
        }
        if (source.m_276093_(DamageTypes.f_268493_)) {
            return false;
        }
        if (source.m_276093_(DamageTypes.f_268641_)) {
            return false;
        }
        return super.m_6469_(source, amount);
    }

    public SpawnGroupData m_6518_(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
        SpawnGroupData retval = super.m_6518_(world, difficulty, reason, livingdata, tag);
        LookingOnInitialEntitySpawnProcedure.execute(world, this);
        return retval;
    }

    public void m_6075_() {
        super.m_6075_();
        LookingAIProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
        this.m_6210_();
    }

    public EntityDimensions m_6972_(Pose p_33597_) {
        return super.m_6972_(p_33597_).m_20388_(0.8f);
    }

    public boolean m_6094_() {
        return false;
    }

    protected void m_7324_(Entity entityIn) {
    }

    protected void m_6138_() {
    }

    public static void init() {
    }

    public static AttributeSupplier.Builder createAttributes() {
        Builder builder = Mob.m_21552_();
        builder = builder.m_22268_(Attributes.f_22279_, 4.5);
        builder = builder.m_22268_(Attributes.f_22276_, 500);
        builder = builder.m_22268_(Attributes.f_22284_, 0);
        builder = builder.m_22268_(Attributes.f_22281_, 3);
        builder = builder.m_22268_(Attributes.f_22277_, 16);
        return builder;
    }

    private PlayState movementPredicate(AnimationState event) {
        if (this.animationprocedure.equals("empty")) {
            if (event.isMoving() || event.getLimbSwingAmount() <= -0.15f || event.getLimbSwingAmount() >= 0.15f) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
            }
            return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
        }
        return PlayState.STOP;
    }

    private PlayState procedurePredicate(AnimationState event) {
        Entity entity = this;
        Level world = entity.m_9236_();
        boolean loop = false;
        double x = entity.m_20185_();
        double y = entity.m_20186_();
        double z = entity.m_20189_();
        this.lastloop = false;
        if (!loop && this.lastloop) {
            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
            event.getController().forceAnimationReset();
            return PlayState.STOP;
        }
        if (this.animationprocedure.equals("empty")) return PlayState.CONTINUE;
        if (event.getController().getAnimationState() != AnimationController.State.STOPPED) return PlayState.CONTINUE;
        if (!loop) {
            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
            if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
                this.animationprocedure = "empty";
                event.getController().forceAnimationReset();
            }
        } else {
            event.getController().setAnimation(RawAnimation.begin().thenLoop(this.animationprocedure));
            this.lastloop = true;
        }
        return PlayState.CONTINUE;
    }

    protected void m_6153_() {
        this.f_20919_ = this.f_20919_ + 1;
        if (this.f_20919_ == 20) {
            this.m_142687_(Entity.RemovalReason.KILLED);
            this.m_21226_();
        }
    }

    public String getSyncedAnimation() {
        return this.f_19804_.m_135370_(ANIMATION);
    }

    public void setAnimation(String animation) {
        this.f_19804_.m_135381_(ANIMATION, animation);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        AnimationController[] tmp0 = new AnimationController[1];
        tmp0[0] = new AnimationController(this, "movement", 4, this::movementPredicate);
        data.add(tmp0);
        AnimationController[] tmp1 = new AnimationController[1];
        tmp1[0] = new AnimationController(this, "procedure", 4, this::procedurePredicate);
        data.add(tmp1);
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
