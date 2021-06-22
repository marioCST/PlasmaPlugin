package de.mariocst.Commands.Server;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class AdminshopCommand extends Command {
    private MarioMain plugin;

    public AdminshopCommand(MarioMain plugin) {
        super("adminshop", "Öffnet die UI des Adminshops!", "adminshop", new String[]{"as"});
        this.setPermission("mario.adminshop");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] strings) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("mario.adminshop") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                MarioMain.getInstance().getFormWindows().openAdminshop(player);
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
