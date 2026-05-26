/*
 * Decompiled with https://jar.tools
 */
package net.mcreator.knockknock.init;

import net.mcreator.knockknock.entity.Angry2Entity;
import net.mcreator.knockknock.entity.AngryEntity;
import net.mcreator.knockknock.entity.HidingEntity;
import net.mcreator.knockknock.entity.LookingEntity;
import net.mcreator.knockknock.entity.NodeEntity;
import net.mcreator.knockknock.entity.RehidingEntity;
import net.mcreator.knockknock.entity.Trailerdummy2Entity;
import net.mcreator.knockknock.entity.TrailerdummyEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class KnockKnockModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "knock_knock");
    public static final RegistryObject<EntityType<LookingEntity>> LOOKING = KnockKnockModEntities.register("looking", EntityType.Builder.m_20704_(LookingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LookingEntity::new).m_20719_().m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<HidingEntity>> HIDING = KnockKnockModEntities.register("hiding", EntityType.Builder.m_20704_(HidingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HidingEntity::new).m_20719_().m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<AngryEntity>> ANGRY = KnockKnockModEntities.register("angry", EntityType.Builder.m_20704_(AngryEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AngryEntity::new).m_20719_().m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<RehidingEntity>> REHIDING = KnockKnockModEntities.register("rehiding", EntityType.Builder.m_20704_(RehidingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RehidingEntity::new).m_20719_().m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<NodeEntity>> NODE = KnockKnockModEntities.register("node", EntityType.Builder.m_20704_(NodeEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NodeEntity::new).m_20719_().m_20699_(0.1f, 0.1f));
    public static final RegistryObject<EntityType<Angry2Entity>> ANGRY_2 = KnockKnockModEntities.register("angry_2", EntityType.Builder.m_20704_(Angry2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Angry2Entity::new).m_20719_().m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<TrailerdummyEntity>> TRAILERDUMMY = KnockKnockModEntities.register("trailerdummy", EntityType.Builder.m_20704_(TrailerdummyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TrailerdummyEntity::new).m_20719_().m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<Trailerdummy2Entity>> TRAILERDUMMY_2 = KnockKnockModEntities.register("trailerdummy_2", EntityType.Builder.m_20704_(Trailerdummy2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Trailerdummy2Entity::new).m_20719_().m_20699_(0.6f, 1.8f));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, KnockKnockModEntities::lambda$register$0 /* captured: entityTypeBuilder, registryname */);
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(KnockKnockModEntities::lambda$init$1);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put((EntityType)LOOKING.get(), LookingEntity.createAttributes().m_22265_());
        event.put((EntityType)HIDING.get(), HidingEntity.createAttributes().m_22265_());
        event.put((EntityType)ANGRY.get(), AngryEntity.createAttributes().m_22265_());
        event.put((EntityType)REHIDING.get(), RehidingEntity.createAttributes().m_22265_());
        event.put((EntityType)NODE.get(), NodeEntity.createAttributes().m_22265_());
        event.put((EntityType)ANGRY_2.get(), Angry2Entity.createAttributes().m_22265_());
        event.put((EntityType)TRAILERDUMMY.get(), TrailerdummyEntity.createAttributes().m_22265_());
        event.put((EntityType)TRAILERDUMMY_2.get(), Trailerdummy2Entity.createAttributes().m_22265_());
    }
}
