package de.mariocst.Listeners;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;
import de.mariocst.MarioMain;

public class QuitListener implements Listener {
    @EventHandler
    public void PlayerQuitEvent(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        if (MarioMain.hasFly(player) && player.getGamemode() != 1 && player.getGamemode() != 3) {
            player.getAdventureSettings().set(AdventureSettings.Type.ALLOW_FLIGHT, false);
            player.getAdventureSettings().update();
        }

        if (player.getName().equals("marioCST")) {
            e.setQuitMessage(MarioMain.getPrefix() + "marioCST der inkompetente Developer ist Offline!");
        }
        else if (player.getName().equals("siwoke")) {
            e.setQuitMessage(MarioMain.getPrefix() + "Der !Chief Siwoke ist Offline!");
        }
        else if (player.getName().equals("Manwoke")) {
            e.setQuitMessage(MarioMain.getPrefix() + "Der !Chief Manwoke ist Offline!");
        }
        else if (player.getName().equals("SonneFeuer48409")) {
            e.setQuitMessage(MarioMain.getPrefix() + "Der !Chief SonneFeuer48409 ist Offline!");
        }
        else if (player.getName().equals("SlyLuca2121")) {
            e.setQuitMessage(MarioMain.getPrefix() + "Der !Chief SlyLuca2121 ist Offline!");
        }
        else {
            e.setQuitMessage("");
        }
    }
}
