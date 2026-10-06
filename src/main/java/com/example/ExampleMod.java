package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
    public static final String MOD_ID = "modid";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // ลงทะเบียน Entity ม็อบ Max
    public static final EntityType<MaxEntity> MAX_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "max"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MaxEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 1.95F))
                    .build()
    );

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Max Design Mod!");
        FabricDefaultAttributeRegistry.register(MAX_ENTITY, MaxEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D));
    }

    // ตัวละคร Max
    public static class MaxEntity extends PathAwareEntity {
        public MaxEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
            super(entityType, world);
        }
    }
}
