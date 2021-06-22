package de.mariocst.Listeners;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.level.Location;
import de.mariocst.MarioMain;

public class CoordinatesListener implements Listener {
    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getLocation().getY() <= 0 && (!player.hasPermission("mario.coordinateslistener.bypass") ||
                !player.hasPermission("mario.*") || !player.hasPermission("*") || !player.isOp())) {
            if (MarioMain.getInstance().getServer().getLevelByName(player.getLevelName()) != null) {
                switch (player.getLevelName()) {
                    case "farmwelt" -> player.teleport(new Location(-51.5, 64, 239.5, MarioMain.getInstance().getServer().getLevelByName("farmwelt")));
                    case "netherfw" -> player.teleport(new Location(121.5, 71, 130.5, MarioMain.getInstance().getServer().getLevelByName("netherfw")));
                    case "endfw" -> player.teleport(new Location(100.5, 56, 39.5, MarioMain.getInstance().getServer().getLevelByName("endfw")));
                    case "cb01" -> player.teleport(new Location(-48.5, 71, -48.5, MarioMain.getInstance().getServer().getLevelByName("cb01")));
                    case "flatmap" -> player.teleport(new Location(-71.5, 7, 92.5, MarioMain.getInstance().getServer().getLevelByName("flatmap")));
                    default -> {
                    }
                }

                if (!player.getLevelName().equals("cb01")) {
                    if (!player.hasPermission("mario.fly.bypass") && !player.hasPermission("mario.*") &&
                            !player.hasPermission("*") && !player.isOp() && MarioMain.hasFly(player) &&
                            player.getGamemode() != 1 && player.getGamemode() != 3) {
                        player.getAdventureSettings().set(AdventureSettings.Type.ALLOW_FLIGHT, false);
                        player.getAdventureSettings().update();
                    }


                }

                player.sendMessage(MarioMain.getPrefix() + "Bitte bleibe überm Bedrock!");
            }
        }
    }
}
