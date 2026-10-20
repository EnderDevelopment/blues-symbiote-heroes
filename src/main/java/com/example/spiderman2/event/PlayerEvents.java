package com.example.spiderman2.event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

public class PlayerEvents {
    @SubscribeEvent
    public void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        Level world = player.level();
        if (!world.isClientSide && player.isFallFlying()) {
            // Trigger Elytra flight and render particles
        }
    }

    @SubscribeEvent
    public void onLivingFall(LivingFallEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack chestplate = player.getInventory().armor.get(2);
            if (chestplate.getItem() instanceof SymbioteBlackSuit) {
                event.setCanceled(true);
            }
        }
    }
}