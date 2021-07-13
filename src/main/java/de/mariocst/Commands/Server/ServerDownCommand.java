package de.mariocst.Commands.Server;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import de.mariocst.AntiCheat.Config.MasterConfig;
import de.mariocst.MarioMain;

public class ServerDownCommand extends Command {
    private MarioMain plugin;

    public ServerDownCommand(MarioMain plugin) {
        super("serverdown", "", "", new String[]{"sd"});
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if(!(sender instanceof Player)) {
            try {
                if (args.length == 1) {
                    switch (args[0].toLowerCase()) {
                        case "true" -> {
                            sender.sendMessage(MarioMain.getPrefix() + "Server ist nun auf Down!");
                            MasterConfig.getMasterConfig().setDown(true);
                            MasterConfig.getMasterConfig().save();

                            for (Player players : MarioMain.getInstance().getServer().getOnlinePlayers().values()) {
                                players.kick("§4§lDer Server ist nun geschlossen.\n§a§lVielen Dank für's Spielen!\n§b§lUm 16:40 Uhr wird dieser Server nie wieder erreichbar sein.\n§c§l- Die Server Leitung", false);
                            }
                        }
                        case "false" -> {
                            sender.sendMessage(MarioMain.getPrefix() + "Server ist nun nicht mehr auf Down!");
                            MasterConfig.getMasterConfig().setDown(false);
                            MasterConfig.getMasterConfig().save();
                        }
                        case "get" -> sender.sendMessage(MarioMain.getPrefix() + MasterConfig.getMasterConfig().isDown());
                        default -> sender.sendMessage(MarioMain.getPrefix() + "/serverdown <true|false|get>");
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "/serverdown <true|false|get>");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage(MarioMain.getPrefix() + "/serverdown <true|false|get>");
            }
        }
        return false;
    }
}
