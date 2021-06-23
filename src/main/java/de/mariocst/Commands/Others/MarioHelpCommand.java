package de.mariocst.Commands.Others;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class MarioHelpCommand extends Command {
    private MarioMain plugin;

    public MarioHelpCommand(MarioMain plugin) {
        super("mariohelp", "Gibt dir Hilfe über das Plasma Plugin aus!", "mariohelp", new String[]{"mhelp"});
        this.setPermission("mario.mariohelp");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("mario.mariohelp") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                try {
                    if (args.length == 0) {
                        final FormWindowSimple mhui = new FormWindowSimple("§bPlasma Help", "§6Bitte wähle eine Kategorie.");

                        mhui.addButton(new ElementButton("§1Announcements"));
                        mhui.addButton(new ElementButton("§2Chat"));
                        mhui.addButton(new ElementButton("§3Inventory"));
                        mhui.addButton(new ElementButton("§4Others"));
                        mhui.addButton(new ElementButton("§5Player"));
                        mhui.addButton(new ElementButton("§6Movement"));
                        mhui.addButton(new ElementButton("§7Report"));
                        mhui.addButton(new ElementButton("§8Send"));
                        mhui.addButton(new ElementButton("§9Server"));
                        mhui.addButton(new ElementButton("§0World"));

                        player.showFormWindow(mhui);
                    }
                    else if (args.length == 1) {
                        switch (args[0]) {
                            case "1" -> {
                                sendHelpPage(player, 1);
                                player.sendMessage(MarioMain.getPrefix() + "§6-- Announcements --");
                                player.sendMessage(MarioMain.getPrefix() + "§6/broadcast5 <Text> - Einfacher Broadcast Command mit 5er Ausgabe");
                                player.sendMessage(MarioMain.getPrefix() + "§6/announcekick - Schreibt 5mal 'ALLE WERDEN GEKICKT! BITTE NACH KURZER ZEIT REJOINEN! NICHT DIREKT!'");
                                player.sendMessage(MarioMain.getPrefix() + "§6/announcerestart - Schreibt 5mal 'SERVER RESTART! Bitte in 20 Sek. wieder joinen!'");
                                player.sendMessage(MarioMain.getPrefix() + "§6/announcestop - Schreibt 5mal 'SERVER STOPP! Danke für's spielen!'");
                            }
                            case "2" -> {
                                sendHelpPage(player, 2);
                                player.sendMessage(MarioMain.getPrefix() + "§6-- Chat --");
                                player.sendMessage(MarioMain.getPrefix() + "§6/broadcast <Text> - Einfacher Broadcast Command");
                                player.sendMessage(MarioMain.getPrefix() + "§6/chatclear - Cleart den Chat");
                            }
                            case "3" -> {
                                sendHelpPage(player, 3);
                                player.sendMessage(MarioMain.getPrefix() + "§6-- Inventory --");
                                player.sendMessage(MarioMain.getPrefix() + "§6/clearinventory [Spieler] - Cleart dein Inventar");
                                player.sendMessage(MarioMain.getPrefix() + "§6/giveitems <add|remove> [Spieler] - Gibt dir gute Items! DEINE RÜSTUNG UND DIE ITEMS IN SLOT LINKS 1 BIS 6 WERDEN ERSETZT!!");
                                player.sendMessage(MarioMain.getPrefix() + "§6/id - Zeigt dir die ID des Items in deiner Hand!");
                                player.sendMessage(MarioMain.getPrefix() + "§6/invsee <inv|echest> <Spieler> - Öffnet das Inventar eines Anderen Spielers");
                                player.sendMessage(MarioMain.getPrefix() + "§6/tnt <add|remove> [Spieler] - Gibt dir TNT und Feuerzeug! DEIN INVENTAR UND DEIN HELM WIRD ERSETZT!");
                            }
                            case "4" -> {
                                sendHelpPage(player, 4);
                                player.sendMessage(MarioMain.getPrefix() + "§6-- Others --");
                                player.sendMessage(MarioMain.getPrefix() + "§6/discord - Zeigt den Discord Link an!");
                                player.sendMessage(MarioMain.getPrefix() + "§6/mariohelp [Seite] - Gibt dir Hilfe über das Plasma Plugin aus!");
                            }
                            case "5" -> {
                                sendHelpPage(player, 5);
                                player.sendMessage(MarioMain.getPrefix() + "§6-- Player --");
                                player.sendMessage(MarioMain.getPrefix() + "§6/die - Tötet dich");
                                player.sendMessage(MarioMain.getPrefix() + "§6/getgamemode <Spieler> - Lässt dich wissen, welchen Gamemode ein Spieler hat");
                                player.sendMessage(MarioMain.getPrefix() + "§6/gm [Gamemode] [Spieler] - Abkürzung für /gamemode");
                                player.sendMessage(MarioMain.getPrefix() + "§6/heal [Spieler] - Heilt und sättigt dich");
                                player.sendMessage(MarioMain.getPrefix() + "§6/nick <Nick> - Ändert deinen Nickname");
                                player.sendMessage(MarioMain.getPrefix() + "§6/nightvision [Spieler] - Gibt dir Nightvision");
                                player.sendMessage(MarioMain.getPrefix() + "§6/size [Größe] - Lässt dich größer oder kleiner werden");
                                player.sendMessage(MarioMain.getPrefix() + "§6/skin <Spieler> - Übernehme den Skin eines anderen Spielers!");
                                player.sendMessage(MarioMain.getPrefix() + "§6/troll <drop|damage|tnt> <Spieler> - Trolle jemanden!");
                                player.sendMessage(MarioMain.getPrefix() + "§6/unnick - Setzt deinen Nickname zurück");
                            }
                            case "6" -> {
                                sendHelpPage(player, 6);
                                player.sendMessage(MarioMain.getPrefix() + "§6-- Movement --");
                                player.sendMessage(MarioMain.getPrefix() + "§6/climb - Klettere überall, auch in der Luft");
                                player.sendMessage(MarioMain.getPrefix() + "§6/fly - Lässt dich auch im Survival Modus fliegen");
                                player.sendMessage(MarioMain.getPrefix() + "§6/freeze [Spieler] - Lässt dich einfrieren");
                                player.sendMessage(MarioMain.getPrefix() + "§6/speed <Value> [Spieler] - Gibt dir Speed");
                            }
                            case "7" -> {
                                sendHelpPage(player, 7);
                                player.sendMessage(MarioMain.getPrefix() + "§6-- Report --");
                                player.sendMessage(MarioMain.getPrefix() + "§6/marioacreport <iie> <Spieler> - Reporte einen Spieler für das ''AntiCheat'' (Illegal Items)");
                            }
                            case "8" -> {
                                sendHelpPage(player, 8);
                                player.sendMessage(MarioMain.getPrefix() + "§6-- Send --");
                                player.sendMessage(MarioMain.getPrefix() + "§6/sendactionbar <Spieler> <Text> - Schreibe einem bestimmten Spieler eine ''Actionbar''!");
                                player.sendMessage(MarioMain.getPrefix() + "§6/sendmessage <Spieler> <Text> - Schreibe einem bestimmten Spieler eine Nachricht!");
                                player.sendMessage(MarioMain.getPrefix() + "§6/sendtitle <Spieler> <Text> - Schreibe einem bestimmten Spieler einen ''Titel''!");
                            }
                            case "9" -> {
                                sendHelpPage(player, 9);
                                player.sendMessage(MarioMain.getPrefix() + "§6-- Server --");
                                player.sendMessage(MarioMain.getPrefix() + "§6/adminshop - Öffnet die UI des Adminshops!");
                                player.sendMessage(MarioMain.getPrefix() + "§6/cb1 - Teleportiert dich auf CityBuild 1");
                                player.sendMessage(MarioMain.getPrefix() + "§6/end - Teleportiert dich ins End");
                                player.sendMessage(MarioMain.getPrefix() + "§6/farmwelt - Teleportiert dich in die Farmwelt!");
                                player.sendMessage(MarioMain.getPrefix() + "§6/kickall [Nachricht] - Kickt alle Spieler mit einem bestimmten Grund");
                                player.sendMessage(MarioMain.getPrefix() + "§6/lobby - Teleportiert dich in die Lobby");
                                player.sendMessage(MarioMain.getPrefix() + "§6/nether - Teleportiert dich in den Nether!");
                                player.sendMessage(MarioMain.getPrefix() + "§6/worldtp - Öffnet eine UI zum Teleportieren!");
                            }
                            case "10" -> {
                                sendHelpPage(player, 10);
                                player.sendMessage(MarioMain.getPrefix() + "§6-- World --");
                                player.sendMessage(MarioMain.getPrefix() + "§6/day - Macht Tag");
                                player.sendMessage(MarioMain.getPrefix() + "§6/getpos [Spieler] - Welche Position habe ich?");
                                player.sendMessage(MarioMain.getPrefix() + "§6/night - Macht Nacht");
                            }
                            default -> {
                                player.sendMessage(MarioMain.getPrefix() + "/mhelp <Seite> (1 - 10)");
                                player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                            }
                        }
                    }
                    else {
                        player.sendMessage(MarioMain.getPrefix() + "/mhelp [Seite]");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    player.sendMessage(MarioMain.getPrefix() + "/mhelp [Seite]");
                    player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                }
            } else {
                player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
                player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
            }
        } else {
            assert false;
            try {
                if (args.length == 1) {
                    switch (args[0]) {
                        case "1" -> {
                            sendHelpPage(sender, 1);
                            sender.sendMessage(MarioMain.getPrefix() + "§6-- Announcements --");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/broadcast5 <Text> - Einfacher Broadcast Command mit 5er Ausgabe");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/announcekick - Schreibt 5mal 'ALLE WERDEN GEKICKT! BITTE NACH KURZER ZEIT REJOINEN! NICHT DIREKT!'");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/announcerestart - Schreibt 5mal 'SERVER RESTART! Bitte in 20 Sek. wieder joinen!'");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/announcestop - Schreibt 5mal 'SERVER STOPP! Danke für's spielen!'");
                        }
                        case "2" -> {
                            sendHelpPage(sender, 2);
                            sender.sendMessage(MarioMain.getPrefix() + "§6-- Chat --");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/broadcast <Text> - Einfacher Broadcast Command");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/chatclear - Cleart den Chat");
                        }
                        case "3" -> {
                            sendHelpPage(sender, 3);
                            sender.sendMessage(MarioMain.getPrefix() + "§6-- Inventory --");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/clearinventory [Spieler] - Cleart dein Inventar");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/giveitems <add|remove> [Spieler] - Gibt dir gute Items! DEINE RÜSTUNG UND DIE ITEMS IN SLOT LINKS 1 BIS 6 WERDEN ERSETZT!!");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/id - Zeigt dir die ID des Items in deiner Hand!");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/invsee <inv|echest> [Spieler] - Öffnet das Inventar eines Anderen Spielers");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/tnt <add|remove> [Spieler] - Gibt dir TNT und Feuerzeug! DEIN INVENTAR UND DEIN HELM WIRD ERSETZT!");
                        }
                        case "4" -> {
                            sendHelpPage(sender, 4);
                            sender.sendMessage(MarioMain.getPrefix() + "§6-- Others --");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/discord - Zeigt den Discord Link an!");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/mariohelp <Seite> - Gibt dir Hilfe über das Plasma Plugin aus!");
                        }
                        case "5" -> {
                            sendHelpPage(sender, 5);
                            sender.sendMessage(MarioMain.getPrefix() + "§6-- Player --");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/die - Tötet dich");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/getgamemode <Spieler> - Lässt dich wissen, welchen Gamemode ein Spieler hat");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/gm [Gamemode] [Spieler] - Abkürzung für /gamemode");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/heal [Spieler] - Heilt und sättigt dich");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/nightvision [Spieler] - Gibt dir Nightvision");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/size [Größe] - Lässt dich größer oder kleiner werden");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/skin <Spieler> - Übernehme den Skin eines anderen Spielers!");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/troll <drop|damage> <Spieler> - Trolle jemanden!");
                        }
                        case "6" -> {
                            sendHelpPage(sender, 6);
                            sender.sendMessage(MarioMain.getPrefix() + "§6-- Movement --");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/climb - Klettere überall, auch in der Luft");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/fly - Lässt dich auch im Survival Modus fliegen");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/freeze [Spieler] - Lässt dich einfrieren");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/speed <Value> [Spieler] - Gibt dir Speed");
                        }
                        case "7" -> {
                            sendHelpPage(sender, 7);
                            sender.sendMessage(MarioMain.getPrefix() + "§6-- Report --");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/marioacreport <iie> <Spieler> - Reporte einen Spieler für das ''AntiCheat'' (Illegal Items)");
                        }
                        case "8" -> {
                            sendHelpPage(sender, 8);
                            sender.sendMessage(MarioMain.getPrefix() + "§6-- Send --");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/sendactionbar <Spieler> <Text> - Schreibe einem bestimmten Spieler eine ''Actionbar''!");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/sendmessage <Spieler> <Text> - Schreibe einem bestimmten Spieler eine Nachricht!");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/sendtitle <Spieler> <Text> - Schreibe einem bestimmten Spieler einen ''Titel''!");
                        }
                        case "9" -> {
                            sendHelpPage(sender, 9);
                            sender.sendMessage(MarioMain.getPrefix() + "§6-- Server --");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/cb1 - Teleportiert dich auf CityBuild 1");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/end - Teleportiert dich ins End");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/farmwelt - Teleportiert dich in die Farmwelt!");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/kickall [Nachricht] - Kickt alle Spieler mit einem bestimmten Grund");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/lobby - Teleportiert dich in die Lobby");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/nether - Teleportiert dich in den Nether!");
                        }
                        case "10" -> {
                            sendHelpPage(sender, 10);
                            sender.sendMessage(MarioMain.getPrefix() + "§6-- World --");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/day - Macht Tag");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/getpos [Spieler] - Welche Position habe ich?");
                            sender.sendMessage(MarioMain.getPrefix() + "§6/night - Macht Nacht");
                        }
                        default -> {
                            sender.sendMessage(MarioMain.getPrefix() + "/mhelp <Seite> (1 - 10)");
                        }
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "/mhelp <Seite>");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage(MarioMain.getPrefix() + "/mhelp <Seite>");
            }
        }

        return false;
    }

    private void sendHelpPage(CommandSender sender, int page) {
        sender.sendMessage(MarioMain.getPrefix() + "§6-- Mario Help --");
        sender.sendMessage(MarioMain.getPrefix() + "§6Seite " + page + " / 10");
        sender.sendMessage(MarioMain.getPrefix());
    }
}
