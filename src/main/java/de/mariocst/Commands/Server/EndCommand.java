package de.mariocst.Commands.Server;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class EndCommand extends Command {
    private MarioMain plugin;

    public EndCommand(MarioMain plugin) {
        super("end", "Teleportiert dich ins End", "end");
        this.setPermission("mario.end");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] strings) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("mario.end") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                if (MarioMain.getInstance().getServer().getLevelByName("endfw") != null) {
                    player.teleport(new Location(100.5, 56, 39.5, MarioMain.getInstance().getServer().getLevelByName("endfw")));
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "Die Welt des Ends wurde umbenannt, oder existiert nicht mehr! Frage im Support nach Hilfe!");
                    player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                }
            } else {
                player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
                player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
            }
        } else {
            sender.sendMessage("Bitte führe den Command InGame aus!");
        }

        return false;
    }
}
