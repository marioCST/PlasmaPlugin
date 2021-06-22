package de.mariocst.Commands.Server;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class LobbyCommand extends Command {
    private MarioMain plugin;

    public LobbyCommand(MarioMain plugin) {
        super("lobby", "Teleportiert dich in die Lobby", "lobby", new String[]{"l"});
        this.setPermission("mario.lobby");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] strings) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("mario.lobby") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                if (MarioMain.getInstance().getServer().getLevelByName("flatmap") != null) {
                    player.teleport(new Location(-71.5, 7, 92.5, MarioMain.getInstance().getServer().getLevelByName("flatmap")));
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "Die Welt der Lobby wurde umbenannt, oder existiert nicht mehr! Frage im Support nach Hilfe!");
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
