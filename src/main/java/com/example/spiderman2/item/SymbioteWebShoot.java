package com.example.spiderman2.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SymbioteWebShoot extends Item {
    public SymbioteWebShoot(Item.Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Player player, int slotId, boolean isSelected) {
        if (!world.isClientSide && !isSelected) {
            player.getInventory().setItem(slotId, new ItemStack(Items.AIR));
        }
    }
}