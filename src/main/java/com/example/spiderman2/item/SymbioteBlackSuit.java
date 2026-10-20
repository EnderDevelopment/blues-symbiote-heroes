package com.example.spiderman2.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SymbioteBlackSuit extends ArmorItem {
    public SymbioteBlackSuit(ArmorMaterial material, EquipmentSlot slot, Item.Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide) {
            player.getAttribute(Attributes.ATTACK_DAMAGE).addTransientModifier(new AttributeModifier("Strength III", 3.0, AttributeModifier.Operation.ADDITION));
            player.getAttribute(Attributes.MOVEMENT_SPEED).addTransientModifier(new AttributeModifier("Speed II", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL));
            player.getAttribute(Attributes.JUMP_STRENGTH).addTransientModifier(new AttributeModifier("Jump Boost II", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
    }

    @Override
    public boolean canElytraFly(ItemStack stack, net.minecraft.world.entity.LivingEntity entity) {
        return true;
    }
}