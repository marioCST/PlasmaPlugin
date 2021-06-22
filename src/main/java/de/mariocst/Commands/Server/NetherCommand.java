package de.mariocst.Commands.Server;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class NetherCommand extends Command {
    private MarioMain plugin;

    public NetherCommand(MarioMain plugin) {
        super("nether", "Teleportiert dich in den Nether!", "nether", new String[]{"ne"});
        this.setPermission("mario.nether");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] strings) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("mario.nether") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                if (MarioMain.getInstance().getServer().getLevelByName("netherfw") != null) {
                    player.teleport(new Location(121.5, 71, 130.5, MarioMain.getInstance().getServer().getLevelByName("netherfw")));
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "Die Welt des Nethers wurde umbenannt, oder existiert nicht mehr! Frage im Support nach Hilfe!");
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
