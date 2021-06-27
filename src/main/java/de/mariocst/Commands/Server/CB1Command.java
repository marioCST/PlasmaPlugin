package de.mariocst.Commands.Server;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class CB1Command extends Command {
    private MarioMain plugin;

    public CB1Command(MarioMain plugin) {
        super("cb1", "Teleportiert dich auf CityBuild 1", "cb1");
        this.setPermission("mario.cb1");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] strings) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("mario.cb1") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                if (MarioMain.getInstance().getServer().getLevelByName("cb01") != null) {
                    player.teleport(new Location(-48.5, 69.5, -48.5, MarioMain.getInstance().getServer().getLevelByName("cb01")));
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "Die Welt des CityBuild 1 wurde umbenannt, oder existiert nicht mehr! Frage im Support nach Hilfe!");
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
