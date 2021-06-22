package de.mariocst.Commands.Server;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class WorldTPCommand extends Command {
    private MarioMain plugin;

    public WorldTPCommand(MarioMain plugin) {
        super("worldtp", "Öffnet eine UI zum Teleportieren!", "worldtp", new String[]{"wtp"});
        this.setPermission("mario.worldtp");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] strings) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("mario.worldtp") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                final FormWindowSimple wui = new FormWindowSimple("§aWorld Teleport", "§6Suche dir eine Welt aus!");

                wui.addButton(new ElementButton("Lobby"));
                wui.addButton(new ElementButton("§1Citybuild 1"));
                wui.addButton(new ElementButton("§2Farmwelt"));
                wui.addButton(new ElementButton("§4Nether"));
                wui.addButton(new ElementButton("§eEnd"));

                player.showFormWindow(wui);
            } else {
                player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
                player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
            }
        } else {
            sender.sendMessage("Bitte führe den InGame aus!");
        }

        return false;
    }
}
