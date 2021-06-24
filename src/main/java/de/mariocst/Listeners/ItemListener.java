package de.mariocst.Listeners;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerItemHeldEvent;
import cn.nukkit.item.Item;

public class ItemListener implements Listener {
    @EventHandler
    public void PlayerItemHeldEvent(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPermission("mario.pickup.bypass") && !player.hasPermission("mario.*") && !player.hasPermission("*") &&
            !player.isOp() && !player.hasPermission("mario.adminitems")) {
            if (event.getItem().getId() == -161) {
                player.getInventory().remove(Item.get(-161));
            }
            else if (event.getItem().getId() == 252) {
                player.getInventory().remove(Item.get(252));
            }
            else if (event.getItem().getId() == 217) {
                player.getInventory().remove(Item.get(217));
            }
            else if (event.getItem().getId() == 210) {
                player.getInventory().remove(Item.get(210));
            }
            else if (event.getItem().getId() == 211) {
                player.getInventory().remove(Item.get(211));
            }
            else if (event.getItem().getId() == 212) {
                player.getInventory().remove(Item.get(212));
            }
        }
    }
}
