package net.Malte.demonmod.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import java.util.Random;

public class CustomIronGolemEntity extends IronGolemEntity {

    public CustomIronGolemEntity(EntityType<? extends IronGolemEntity> type, World WorldIn) {
        super(type, WorldIn);
    }


    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 2000.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.33D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 15.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 50.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.TARGET_DRY_BABY));
        this.goalSelector.addGoal(0, new LookAtGoal(this, PlayerEntity.class, 8.0F));
    }


    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 3 + this.world.rand.nextInt(5);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_HOGLIN_AMBIENT;
    }


    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_HOGLIN_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_IRON_GOLEM_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_HOGLIN_STEP, 0.20F, 0.5F);
    }

    private int getAttackTicks = 0;
    private int getAttackCount = 0;
    private final Random random = new Random();

    private int attackTicks = 0;
    private static final int ATTACK_INTERVAL_TICKS = 100; // 5 Sekunden * 20 ticks/Sekunde

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if (flag && this.attackTicks == 0) {
            // wählt eine zufällige Attacke
            int randomAttack = this.rand.nextInt(3);
            switch (randomAttack) {
                case 0: // Angriffsart 1: Spieler wird 5 Blöcke in die Luft geschmissen
                    if (this.world.getGameRules().getBoolean(GameRules.MOB_GRIEFING)) {
                        entityIn.addVelocity(0, 1, 0);
                    }
                    break;
                case 1: // Angriffsart 2: Spieler wird verlangsamt und geschwächt
                    if (entityIn instanceof LivingEntity) {
                        ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 1));
                        ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.WEAKNESS, 200, 1));
                    }
                    break;
                case 2: // Angriffsart 3: Spieler ist für 5 Sekunden betäubt aufgrund eines Schreis.
                    this.world.getEntitiesWithinAABBExcludingEntity(this, getBoundingBox().grow(20.0D)).stream()
                            .filter(entity -> entity instanceof PlayerEntity)
                            .forEach(player -> {
                                ((PlayerEntity) player).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 100));
                                player.playSound(SoundEvents.ENTITY_ENDER_DRAGON_GROWL, 10.0F, 2.0F);
                            });
                    break;
            }

            // Timer wird zurückgesetzt um wieder angreifen zu können
            this.attackTicks = ATTACK_INTERVAL_TICKS;
        }
        return flag;
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if (this.attackTicks > 0) {
            this.attackTicks--;
        }
    }
}










