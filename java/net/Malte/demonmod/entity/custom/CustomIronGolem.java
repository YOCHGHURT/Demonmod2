package net.Malte.demonmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

public class CustomIronGolem extends IronGolemEntity {

    public CustomIronGolem(EntityType<? extends IronGolemEntity> type, World WorldIn) {super(type, WorldIn);}




    // Implementierung der Angriffsverhalten

    int attackTicks = 0;
    int attackCount = 0;

    private int getAttackTicks = 0;
    private int getAttackCount = 0;



    @Override
    public void livingTick() {
        super.livingTick();

        if (this.getAttackTarget() == null || this.getAttackTarget().isAlive()) {
            return;
        }

        attackTicks++;
        if (attackTicks >= 60) { // Alle 3 Sekunden angreifen
            attackTicks = 0;
            attackCount++;

            if (attackCount > 3) {
                attackCount = 1;
            }

            switch (attackCount) {
                case 1:
                    // Spieler mit Schlag in die Luft befördern und Schaden zufügen
                    Vector3d lookVector = this.getAttackTarget().getLookVec();
                    this.getAttackTarget().addVelocity(lookVector.x * 2, 1.2D, lookVector.z * 2);
                    this.getAttackTarget().attackEntityFrom(DamageSource.MAGIC, 12.0F);
                    break;
                case 2:
                    // Spieler schwächen und verlangsamen
                    this.getAttackTarget().addPotionEffect(new EffectInstance(Effects.WEAKNESS, 100, 1));
                    this.getAttackTarget().addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 1));
                    break;
                case 3:
                    // Spieler für 5 Sekunden immobilisieren
                    this.getAttackTarget().addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 255));
                    this.world.playSound(null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_ENDER_DRAGON_GROWL, this.getSoundCategory(), 1.0F, 1.0F);
                    break;
            }
        }
    }
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.33D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 13.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 50.0D);
    }
}







