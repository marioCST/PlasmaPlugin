package de.mariocst.Listeners;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import de.mariocst.AntiCheat.Config.MasterConfig;
import de.mariocst.MarioMain;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (MasterConfig.getMasterConfig().isDown()) {
            player.kick("§4§lDer Server ist nun geschlossen.\n§a§lVielen Dank für's Spielen!\n§b§lUm 16:40 Uhr wird dieser Server nie wieder erreichbar sein.\n§c§l- Die Server Leitung", false);
        }

        if (player.getName().equals("marioCST")) {
            event.setJoinMessage(MarioMain.getPrefix() + "marioCST der inkompetente Developer ist Online!");
        }
        else if (player.getName().equals("siwoke")) {
            event.setJoinMessage(MarioMain.getPrefix() + "Der !Chief Siwoke ist Online!");
        }
        else if (player.getName().equals("manwoke")) {
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
            MarioMain.getInstance().log("Der Spieler " + player.getName() + " ist Online!");
        }
    }
}
