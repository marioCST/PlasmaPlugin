package de.mariocst.Listeners;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import de.mariocst.MarioMain;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.getName().equals("marioCST")) {
            event.setJoinMessage(MarioMain.getPrefix() + "marioCST der dumme Developer ist Online!");
        }
        else if (player.getName().equals("siwoke")) {
            event.setJoinMessage(MarioMain.getPrefix() + "Der !Chief Siwoke ist Online!");
        }
        else if (player.getName().equals("Manwoke")) {
            event.setJoinMessage(MarioMain.getPrefix() + "Der !Chief Manwoke ist Online!");
        }
        else if (player.getName().equals("SonneFeuer48409")) {
            event.setJoinMessage(MarioMain.getPrefix() + "Der !Chief SonneFeuer48409 ist Online!");
        }
        else if (player.getName().equals("SlyLuca2121")) {
            event.setJoinMessage(MarioMain.getPrefix() + "Der !Chief SlyLuca2121 ist Online!");
        }
        else {
            event.setJoinMessage("");
        }
    }
}
