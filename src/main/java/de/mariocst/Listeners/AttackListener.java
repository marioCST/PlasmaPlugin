package de.mariocst.Listeners;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEntityEvent;
import de.mariocst.MarioMain;

public class AttackListener implements Listener {
    @EventHandler
    public void onAttack(PlayerInteractEntityEvent event) {
        Player attacker = event.getPlayer();

        if (event.getEntity() instanceof Player) {
            if (!attacker.hasPermission("mario.fly.bypass") && !attacker.hasPermission("mario.*") &&
                    !attacker.hasPermission("*") && !attacker.isOp() && attacker.getGamemode() != 1 &&
                    attacker.getGamemode() != 3) {
                if (MarioMain.hasFly(attacker)) {
                    attacker.getAdventureSettings().set(AdventureSettings.Type.ALLOW_FLIGHT, false);
                    attacker.sendMessage(MarioMain.getPrefix() + "§cDu hast jemanden angegriffen. Dein Fly wurde deaktiviert!");
                    attacker.getAdventureSettings().update();
                }
            }
        }
    }
}
