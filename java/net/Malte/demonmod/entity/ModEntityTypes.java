package net.Malte.demonmod.entity;

import net.Malte.demonmod.DemonMod;
import net.Malte.demonmod.entity.custom.BuffZombieEntity;
import net.Malte.demonmod.entity.custom.CustomIronGolemEntity;
import net.Malte.demonmod.entity.custom.PigeonEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, DemonMod.MOD_ID);

    public static final RegistryObject<EntityType<BuffZombieEntity>> BUFF_ZOMBIE =
            ENTITY_TYPES.register("buff_zombie",
                    () -> EntityType.Builder.create(BuffZombieEntity::new,
                    EntityClassification.MONSTER).size(1f, 3f)
                    .build(new ResourceLocation(DemonMod.MOD_ID, "buff_zombie").toString()));

    public static final RegistryObject<EntityType<PigeonEntity>>PIGEON =
            ENTITY_TYPES.register("pigeon", () -> EntityType.Builder.create(PigeonEntity::new,
                            EntityClassification.CREATURE).size(0.4f, 0.3f)
                    .build(new ResourceLocation(DemonMod.MOD_ID, "pigeon").toString()));

    public static final RegistryObject<EntityType<CustomIronGolemEntity>> CUSTOM_IRONGOLEM =
        ENTITY_TYPES.register("custom_iron_golem",
                () -> EntityType.Builder.create(CustomIronGolemEntity::new,
                EntityClassification.CREATURE).size(2f,6f)
                .build(new ResourceLocation(DemonMod.MOD_ID,"custom_iron_golem").toString()));



    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
