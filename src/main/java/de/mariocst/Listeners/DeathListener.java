package de.mariocst.Listeners;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.item.Item;

public class DeathListener implements Listener {
    @EventHandler
    public void PlayerDeathEvent(PlayerDeathEvent event) {
        event.setDrops(Item.EMPTY_ARRAY);
        event.setDeathMessage("");
    }
}
