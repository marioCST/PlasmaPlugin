package de.mariocst.Commands.Server;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class FarmweltCommand extends Command {
    private MarioMain plugin;

    public FarmweltCommand(MarioMain plugin) {
        super("farmwelt", "Teleportiert dich in die Farmwelt!", "farmwelt", new String[]{"fw"});
        this.setPermission("mario.farmwelt");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] strings) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("mario.farmwelt") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                if (MarioMain.getInstance().getServer().getLevelByName("farmwelt") != null) {
                    player.teleport(new Location(-51.5, 64, 239.5, MarioMain.getInstance().getServer().getLevelByName("farmwelt")));
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "Die Welt der Farmwelt wurde umbenannt, oder existiert nicht mehr! Frage im Support nach Hilfe!");
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
