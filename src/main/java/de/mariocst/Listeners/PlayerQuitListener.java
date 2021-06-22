package de.mariocst.Listeners;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;
import de.mariocst.MarioMain;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void PlayerQuitEvent(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        if (MarioMain.hasFly(player) && player.getGamemode() != 1 && player.getGamemode() != 3) {
            player.getAdventureSettings().set(AdventureSettings.Type.ALLOW_FLIGHT, false);
            player.getAdventureSettings().update();
        }
    }
}
