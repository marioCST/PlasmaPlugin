package de.mariocst.Listeners;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.response.FormResponseSimple;
import cn.nukkit.form.window.FormWindowSimple;

public class MarioHelpUIListener implements Listener {
    @EventHandler
    public void onHelp(final PlayerFormRespondedEvent event) {
        if (event.getWindow() instanceof FormWindowSimple) {
            if (event.getResponse() instanceof FormResponseSimple) {
                final FormWindowSimple fws = (FormWindowSimple) event.getWindow();
                Player player = event.getPlayer();
                String button = fws.getResponse().getClickedButton().getText();

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

                final FormWindowSimple anui = new FormWindowSimple("§6-- Announcements --", "§6Bitte wähle einen Command.");

                anui.addButton(new ElementButton("/broadcast5"));
                anui.addButton(new ElementButton("/announcekick"));
                anui.addButton(new ElementButton("/announcerestart"));
                anui.addButton(new ElementButton("/announcestop"));
                anui.addButton(new ElementButton("§cZurück"));

                final FormWindowSimple chui = new FormWindowSimple("§6-- Chat --", "§6Bitte wähle einen Command.");

                chui.addButton(new ElementButton("/broadcast"));
                chui.addButton(new ElementButton("/chatclear"));
                chui.addButton(new ElementButton("§cZurück"));

                final FormWindowSimple inui = new FormWindowSimple("§6-- Inventory --", "§6Bitte wähle einen Command.");

                inui.addButton(new ElementButton("/clearinventory"));
                inui.addButton(new ElementButton("/giveitems"));
                inui.addButton(new ElementButton("/id"));
                inui.addButton(new ElementButton("/invsee"));
                inui.addButton(new ElementButton("/tnt"));
                inui.addButton(new ElementButton("§cZurück"));

                final FormWindowSimple otui = new FormWindowSimple("§6-- Others --", "§6Bitte wähle einen Command.");

                otui.addButton(new ElementButton("/discord"));
                otui.addButton(new ElementButton("/mariohelp"));
                otui.addButton(new ElementButton("§cZurück"));

                final FormWindowSimple plui = new FormWindowSimple("§6-- Player --", "§6Bitte wähle einen Command.");

                plui.addButton(new ElementButton("/die"));
                plui.addButton(new ElementButton("/getgamemode"));
                plui.addButton(new ElementButton("/gm"));
                plui.addButton(new ElementButton("/heal"));
                plui.addButton(new ElementButton("/nightvision"));
                plui.addButton(new ElementButton("/size"));
                plui.addButton(new ElementButton("/skin"));
                plui.addButton(new ElementButton("/troll"));
                plui.addButton(new ElementButton("§cZurück"));

                final FormWindowSimple moui = new FormWindowSimple("§6-- Movement --", "§6Bitte wähle einen Command.");

                moui.addButton(new ElementButton("/climb"));
                moui.addButton(new ElementButton("/fly"));
                moui.addButton(new ElementButton("/freeze"));
                moui.addButton(new ElementButton("/speed"));
                moui.addButton(new ElementButton("§cZurück"));

                final FormWindowSimple reui = new FormWindowSimple("§6-- Report --", "§6Bitte wähle einen Command.");

                reui.addButton(new ElementButton("/marioacreport"));
                reui.addButton(new ElementButton("§cZurück"));

                final FormWindowSimple seui = new FormWindowSimple("§6-- Send --", "§6Bitte wähle einen Command.");

                seui.addButton(new ElementButton("/sendactionbar"));
                seui.addButton(new ElementButton("/sendmessage"));
                seui.addButton(new ElementButton("/sendtitle"));
                seui.addButton(new ElementButton("§cZurück"));

                final FormWindowSimple serui = new FormWindowSimple("§6-- Server --", "§6Bitte wähle einen Command.");

                serui.addButton(new ElementButton("/adminshop"));
                serui.addButton(new ElementButton("/cb1"));
                serui.addButton(new ElementButton("/end"));
                serui.addButton(new ElementButton("/farmwelt"));
                serui.addButton(new ElementButton("/kickall"));
                serui.addButton(new ElementButton("/lobby"));
                serui.addButton(new ElementButton("/nether"));
                serui.addButton(new ElementButton("/worldtp"));
                serui.addButton(new ElementButton("§cZurück"));

                final FormWindowSimple woui = new FormWindowSimple("§6-- World --", "§6Bitte wähle einen Command.");

                woui.addButton(new ElementButton("/day"));
                woui.addButton(new ElementButton("/getpos"));
                woui.addButton(new ElementButton("/night"));
                woui.addButton(new ElementButton("§cZurück"));


                if (fws.getTitle().equals("§bPlasma Help")) {
                    if (button.equals("§1Announcements")) {
                        player.showFormWindow(anui);
                    }
                    if (button.equals("§2Chat")) {
                        player.showFormWindow(chui);
                    }
                    if (button.equals("§3Inventory")) {
                        player.showFormWindow(inui);
                    }
                    if (button.equals("§4Others")) {
                        player.showFormWindow(otui);
                    }
                    if (button.equals("§5Player")) {
                        player.showFormWindow(plui);
                    }
                    if (button.equals("§6Movement")) {
                        player.showFormWindow(moui);
                    }
                    if (button.equals("§7Report")) {
                        player.showFormWindow(reui);
                    }
                    if (button.equals("§8Send")) {
                        player.showFormWindow(seui);
                    }
                    if (button.equals("§9Server")) {
                        player.showFormWindow(serui);
                    }
                    if (button.equals("§0World")) {
                        player.showFormWindow(woui);
                    }
                }
                if (fws.getTitle().equals("§6-- Announcements --")) {
                    if (button.equals("/broadcast5")) {
                        final FormWindowSimple brui = new FormWindowSimple("§6/broadcast5", "§6Informationen zu /broadcast5");

                        brui.setContent("§6Usage: /broadcast5 <Text>\n" +
                                        "§6Description: Einfacher Broadcast Command mit 5er Ausgabe\n" +
                                        "§6Permission: mario.broadcast5"
                        );
                        brui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(brui);
                    }
                    if (button.equals("/announcekick")) {
                        final FormWindowSimple akui = new FormWindowSimple("§6/announcekick", "§6Informationen zu /announcekick");

                        akui.setContent("§6Usage: /announcekick\n" +
                                        "§6Description: Schreibt 5mal 'ALLE WERDEN GEKICKT! BITTE NACH KURZER ZEIT REJOINEN! NICHT DIREKT!'\n" +
                                        "§6Permission: mario.announcekick"
                        );
                        akui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(akui);
                    }
                    if (button.equals("/announcerestart")) {
                        final FormWindowSimple arui = new FormWindowSimple("§6/announcerestart", "§6Informationen zu /announcerestart");

                        arui.setContent("§6Usage: /announcerestart\n" +
                                        "§6Description: Schreibt 5mal 'SERVER RESTART! Bitte in 20 Sek. wieder joinen!'\n" +
                                        "§6Permission: mario.announcerestart"
                        );
                        arui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(arui);
                    }
                    if (button.equals("/announcestop")) {
                        final FormWindowSimple arui = new FormWindowSimple("§6/announcestop", "§6Informationen zu /announcestop");

                        arui.setContent("§6Usage: /announcestop\n" +
                                        "§6Description: Schreibt 5mal 'SERVER STOPP! Danke für's spielen!'\n" +
                                        "§6Permission: mario.announcestop"
                        );
                        arui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(arui);
                    }
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(mhui);
                    }
                }
                if (fws.getTitle().equals("§6-- Chat --")) {
                    if (button.equals("/broadcast")) {
                        final FormWindowSimple boui = new FormWindowSimple("§6/broadcast", "§6Informationen zu /broadcast");

                        boui.setContent("§6Usage: /broadcast <Text>\n" +
                                "§6Description: Einfacher Broadcast Command\n" +
                                "§6Permission: mario.broadcast"
                        );
                        boui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(boui);
                    }
                    if (button.equals("/chatclear")) {
                        final FormWindowSimple ccui = new FormWindowSimple("§6/chatclear", "§6Informationen zu /chatclear");

                        ccui.setContent("§6Usage: /chatclear <Text>\n" +
                                "§6Description: Cleart den Chat\n" +
                                "§6Permission: mario.chatclear"
                        );
                        ccui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(ccui);
                    }
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(mhui);
                    }
                }
                if (fws.getTitle().equals("§6-- Inventory --")) {
                    if (button.equals("/clearinventory")) {
                        final FormWindowSimple clui = new FormWindowSimple("§6/clearinventory", "§6Informationen zu /clearinventory");

                        clui.setContent("§6Usage: /clearinventory [Spieler]\n" +
                                "§6Description: Cleart dein Inventar\n" +
                                "§6Permission: mario.clearinventory"
                        );
                        clui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(clui);
                    }
                    if (button.equals("/giveitems")) {
                        final FormWindowSimple giui = new FormWindowSimple("§6/giveitems", "§6Informationen zu /giveitems");

                        giui.setContent("§6Usage: /giveitems <remove|add> [Spieler]\n" +
                                "§6Description: Gibt dir gute Items! DEINE RÜSTUNG UND DIE ITEMS IN SLOT LINKS 1 BIS 6 WERDEN ERSETZT!!\n" +
                                "§6Permission: mario.giveitems"
                        );
                        giui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(giui);
                    }
                    if (button.equals("/id")) {
                        final FormWindowSimple idui = new FormWindowSimple("§6/id", "§6Informationen zu /id");

                        idui.setContent("§6Usage: /id\n" +
                                "§6Description: Zeigt dir die ID des Items in deiner Hand!\n" +
                                "§6Permission: mario.id"
                        );
                        idui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(idui);
                    }
                    if (button.equals("/invsee")) {
                        final FormWindowSimple invui = new FormWindowSimple("§6/invsee", "§6Informationen zu /invsee");

                        invui.setContent("§6Usage: /invsee <inv|echest> <Spieler>\n" +
                                "§6Description: Öffnet das Inventar eines Anderen Spielers\n" +
                                "§6Permission: mario.invsee"
                        );
                        invui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(invui);
                    }
                    if (button.equals("/tnt")) {
                        final FormWindowSimple tnui = new FormWindowSimple("§6/tnt", "§6Informationen zu /tnt");

                        tnui.setContent("§6Usage: /tnt <add|remove> [Spieler]\n" +
                                "§6Description: Gibt dir TNT und Feuerzeug! DEIN INVENTAR UND DEIN HELM WIRD ERSETZT!\n" +
                                "§6Permission: mario.tnt"
                        );
                        tnui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(tnui);
                    }
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(mhui);
                    }
                }
                if (fws.getTitle().equals("§6-- Others --")) {
                    if (button.equals("/discord")) {
                        final FormWindowSimple diui = new FormWindowSimple("§6/discord", "§6Informationen zu /discord");

                        diui.setContent("§6Usage: /discord\n" +
                                "§6Description: Zeigt den Discord Link an!\n" +
                                "§6Permission: mario.discord"
                        );
                        diui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(diui);
                    }
                    if (button.equals("/mariohelp")) {
                        final FormWindowSimple maui = new FormWindowSimple("§6/mariohelp", "§6Informationen zu /mariohelp");

                        maui.setContent("§6Usage: /mariohelp [Seite]\n" +
                                "§6Description: Gibt dir Hilfe über das Plasma Plugin aus!\n" +
                                "§6Permission: mario.mariohelp"
                        );
                        maui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(maui);
                    }
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(mhui);
                    }
                }
                if (fws.getTitle().equals("§6-- Player --")) {
                    if (button.equals("/die")) {
                        final FormWindowSimple diui = new FormWindowSimple("§6/die", "§6Informationen zu /die");

                        diui.setContent("§6Usage: /die\n" +
                                "§6Description: Tötet dich\n" +
                                "§6Permission: mario.die"
                        );
                        diui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(diui);
                    }
                    if (button.equals("/getgamemode")) {
                        final FormWindowSimple diui = new FormWindowSimple("§6/getgamemode", "§6Informationen zu /getgamemode");

                        diui.setContent("§6Usage: /getgamemode <Spieler>\n" +
                                "§6Description: Lässt dich wissen, welchen Gamemode ein Spieler hat\n" +
                                "§6Permission: mario.getgamemode"
                        );
                        diui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(diui);
                    }
                    if (button.equals("/gm")) {
                        final FormWindowSimple gmui = new FormWindowSimple("§6/gm", "§6Informationen zu /gm");

                        gmui.setContent("§6Usage: /gm [Gamemode] [Spieler]\n" +
                                "§6Description: Abkürzung für /gamemode\n" +
                                "§6Permission: mario.gm"
                        );
                        gmui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(gmui);
                    }
                    if (button.equals("/heal")) {
                        final FormWindowSimple heui = new FormWindowSimple("§6/heal", "§6Informationen zu /heal");

                        heui.setContent("§6Usage: /heal [Spieler]\n" +
                                "§6Description: Heilt und sättigt dich\n" +
                                "§6Permission: mario.heal"
                        );
                        heui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(heui);
                    }
                    if (button.equals("/nightvision")) {
                        final FormWindowSimple niui = new FormWindowSimple("§6/nightvision", "§6Informationen zu /nightvision");

                        niui.setContent("§6Usage: /nightvision [Spieler]\n" +
                                "§6Description: Gibt dir Nightvision\n" +
                                "§6Permission: mario.nightvision"
                        );
                        niui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(niui);
                    }
                    if (button.equals("/size")) {
                        final FormWindowSimple siui = new FormWindowSimple("§6/size", "§6Informationen zu /size");

                        siui.setContent("§6Usage: /size [Größe]\n" +
                                "§6Description: Lässt dich größer oder kleiner werden\n" +
                                "§6Permission: mario.size"
                        );
                        siui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(siui);
                    }
                    if (button.equals("/skin")) {
                        final FormWindowSimple skui = new FormWindowSimple("§6/skin", "§6Informationen zu /skin");

                        skui.setContent("§6Usage: /skin <Spieler>\n" +
                                "§6Description: Übernehme den Skin eines anderen Spielers!\n" +
                                "§6Permission: mario.skin"
                        );
                        skui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(skui);
                    }
                    if (button.equals("/troll")) {
                        final FormWindowSimple trui = new FormWindowSimple("§6/troll", "§6Informationen zu /troll");

                        trui.setContent("§6Usage: /troll <drop|damage|tnt> <Spieler>\n" +
                                "§6Description: Trolle jemanden!\n" +
                                "§6Permission: mario.troll"
                        );
                        trui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(trui);
                    }
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(mhui);
                    }
                }
                if (fws.getTitle().equals("§6-- Movement --")) {
                    if (button.equals("/climb")) {
                        final FormWindowSimple clui = new FormWindowSimple("§6/climb", "§6Informationen zu /climb");

                        clui.setContent("§6Usage: /climb\n" +
                                "§6Description: Klettere überall, auch in der Luft\n" +
                                "§6Permission: mario.climb"
                        );
                        clui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(clui);
                    }
                    if (button.equals("/fly")) {
                        final FormWindowSimple flui = new FormWindowSimple("§6/fly", "§6Informationen zu /fly");

                        flui.setContent("§6Usage: /fly\n" +
                                "§6Description: Lässt dich auch im Survival Modus fliegen\n" +
                                "§6Permission: mario.fly"
                        );
                        flui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(flui);
                    }
                    if (button.equals("/freeze")) {
                        final FormWindowSimple frui = new FormWindowSimple("§6/freeze", "§6Informationen zu /freeze");

                        frui.setContent("§6Usage: /freeze [Spieler]\n" +
                                "§6Description: Lässt dich einfrieren\n" +
                                "§6Permission: mario.freeze"
                        );
                        frui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(frui);
                    }
                    if (button.equals("/speed")) {
                        final FormWindowSimple spui = new FormWindowSimple("§6/speed", "§6Informationen zu /speed");

                        spui.setContent("§6Usage: /speed <Value> [Spieler]\n" +
                                "§6Description: Gibt dir Speed\n" +
                                "§6Permission: mario.speed"
                        );
                        spui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(spui);
                    }
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(mhui);
                    }
                }
                if (fws.getTitle().equals("§6-- Report --")) {
                    if (button.equals("/marioacreport")) {
                        final FormWindowSimple maui = new FormWindowSimple("§6/marioacreport", "§6Informationen zu /marioacreport");

                        maui.setContent("§6Usage: /marioacreport <iie> <Spieler>\n" +
                                "§6Description: Reporte einen Spieler für das ''AntiCheat'' (Illegal Items)\n" +
                                "§6Permission: mario.marioacreport"
                        );
                        maui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(maui);
                    }
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(mhui);
                    }
                }
                if (fws.getTitle().equals("§6-- Send --")) {
                    if (button.equals("/sendactionbar")) {
                        final FormWindowSimple saui = new FormWindowSimple("§6/sendactionbar", "§6Informationen zu /sendactionbar");

                        saui.setContent("§6Usage: /sendactionbar <Spieler> <Text>\n" +
                                "§6Description: Schreibe einem bestimmten Spieler eine ''Actionbar''!\n" +
                                "§6Permission: mario.sendactionbar"
                        );
                        saui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(saui);
                    }
                    if (button.equals("/sendmessage")) {
                        final FormWindowSimple smui = new FormWindowSimple("§6/sendmessage", "§6Informationen zu /sendmessage");

                        smui.setContent("§6Usage: /sendmessage <Spieler> <Text>\n" +
                                "§6Description: Schreibe einem bestimmten Spieler eine Nachricht!\n" +
                                "§6Permission: mario.sendmessage"
                        );
                        smui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(smui);
                    }
                    if (button.equals("/sendtitle")) {
                        final FormWindowSimple stui = new FormWindowSimple("§6/sendtitle", "§6Informationen zu /sendtitle");

                        stui.setContent("§6Usage: /sendtitle <Spieler> <Text>\n" +
                                "§6Description: Schreibe einem bestimmten Spieler einen ''Titel''!\n" +
                                "§6Permission: mario.sendtitle"
                        );
                        stui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(stui);
                    }
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(mhui);
                    }
                }
                if (fws.getTitle().equals("§6-- Server --")) {
                    if (button.equals("/adminshop")) {
                        final FormWindowSimple adui = new FormWindowSimple("§6/adminshop", "§6Informationen zu /adminshop");

                        adui.setContent("§6Usage: /adminshop\n" +
                                "§6Description: Öffnet die UI des Adminshops!\n" +
                                "§6Permission: mario.adminshop"
                        );
                        adui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(adui);
                    }
                    if (button.equals("/cb1")) {
                        final FormWindowSimple cbui = new FormWindowSimple("§6/cb1", "§6Informationen zu /cb1");

                        cbui.setContent("§6Usage: /cb1\n" +
                                "§6Description: Teleportiert dich auf CityBuild 1\n" +
                                "§6Permission: mario.cb1"
                        );
                        cbui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(cbui);
                    }
                    if (button.equals("/end")) {
                        final FormWindowSimple enui = new FormWindowSimple("§6/end", "§6Informationen zu /end");

                        enui.setContent("§6Usage: /end\n" +
                                "§6Description: Teleportiert dich ins End\n" +
                                "§6Permission: mario.end"
                        );
                        enui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(enui);
                    }
                    if (button.equals("/farmwelt")) {
                        final FormWindowSimple faui = new FormWindowSimple("§6/farmwelt", "§6Informationen zu /farmwelt");

                        faui.setContent("§6Usage: /farmwelt\n" +
                                "§6Description: Teleportiert dich in die Farmwelt!\n" +
                                "§6Permission: mario.farmwelt"
                        );
                        faui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(faui);
                    }
                    if (button.equals("/kickall")) {
                        final FormWindowSimple kiui = new FormWindowSimple("§6/kickall", "§6Informationen zu /kickall");

                        kiui.setContent("§6Usage: /kickall [Nachricht]\n" +
                                "§6Description: Kickt alle Spieler mit einem bestimmten Grund\n" +
                                "§6Permission: mario.kickall"
                        );
                        kiui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(kiui);
                    }
                    if (button.equals("/lobby")) {
                        final FormWindowSimple loui = new FormWindowSimple("§6/lobby", "§6Informationen zu /lobby");

                        loui.setContent("§6Usage: /lobby\n" +
                                "§6Description: Teleportiert dich in die Lobby\n" +
                                "§6Permission: mario.lobby"
                        );
                        loui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(loui);
                    }
                    if (button.equals("/nether")) {
                        final FormWindowSimple neui = new FormWindowSimple("§6/nether", "§6Informationen zu /nether");

                        neui.setContent("§6Usage: /nether\n" +
                                "§6Description: Teleportiert dich in den Nether!\n" +
                                "§6Permission: mario.nether"
                        );
                        neui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(neui);
                    }
                    if (button.equals("/worldtp")) {
                        final FormWindowSimple wui = new FormWindowSimple("§6/worldtp", "§6Informationen zu /worldtp");

                        wui.setContent("§6Usage: /worldtp\n" +
                                "§6Description: Öffnet eine UI zum Teleportieren!\n" +
                                "§6Permission: mario.worldtp"
                        );
                        wui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(wui);
                    }
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(mhui);
                    }
                }
                if (fws.getTitle().equals("§6-- World --")) {
                    if (button.equals("/day")) {
                        final FormWindowSimple daui = new FormWindowSimple("§6/day", "§6Informationen zu /day");

                        daui.setContent("§6Usage: /day\n" +
                                "§6Description: Macht Tag\n" +
                                "§6Permission: mario.day"
                        );
                        daui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(daui);
                    }
                    if (button.equals("/getpos")) {
                        final FormWindowSimple geui = new FormWindowSimple("§6/getpos", "§6Informationen zu /getpos");

                        geui.setContent("§6Usage: /getpos [Spieler]\n" +
                                "§6Description: Welche Position habe ich?\n" +
                                "§6Permission: mario.getpos"
                        );
                        geui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(geui);
                    }
                    if (button.equals("/night")) {
                        final FormWindowSimple niui = new FormWindowSimple("§6/night", "§6Informationen zu /night");

                        niui.setContent("§6Usage: /night\n" +
                                "§6Description: Macht Nacht\n" +
                                "§6Permission: mario.night"
                        );
                        niui.addButton(new ElementButton("§cZurück"));

                        player.showFormWindow(niui);
                    }
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(mhui);
                    }
                }
                if (fws.getTitle().equals("§6/broadcast5") || fws.getTitle().equals("§6/announcekick") ||
                    fws.getTitle().equals("§6/announcerestart") || fws.getTitle().equals("§6/announcestop")) {
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(anui);
                    }
                }
                if (fws.getTitle().equals("§6/broadcast") || fws.getTitle().equals("§6/chatclear")) {
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(chui);
                    }
                }
                if (fws.getTitle().equals("§6/clearinventory") || fws.getTitle().equals("§6/giveitems") ||
                    fws.getTitle().equals("§6/id") || fws.getTitle().equals("§6/invsee") || fws.getTitle().equals("§6/tnt")) {
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(inui);
                    }
                }
                if (fws.getTitle().equals("§6/discord") || fws.getTitle().equals("§6/mmariohelp")) {
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(otui);
                    }
                }
                if (fws.getTitle().equals("§6/die") || fws.getTitle().equals("§6/getgamemode") || fws.getTitle().equals("§6/gm") ||
                    fws.getTitle().equals("§6/heal") || fws.getTitle().equals("§6/nightvision") || fws.getTitle().equals("§6/size") ||
                    fws.getTitle().equals("§6/skin") || fws.getTitle().equals("§6/troll")) {
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(plui);
                    }
                }
                if (fws.getTitle().equals("§6/climb") || fws.getTitle().equals("§6/fly") || fws.getTitle().equals("§6/freeze") ||
                    fws.getTitle().equals("§6/speed")) {
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(moui);
                    }
                }
                if (fws.getTitle().equals("§6/marioacreport")) {
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(reui);
                    }
                }
                if (fws.getTitle().equals("§6/sendactionbar") || fws.getTitle().equals("§6/sendmessage") ||
                    fws.getTitle().equals("§6/sendtitle")) {
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(seui);
                    }
                }
                if (fws.getTitle().equals("§6/adminshop") || fws.getTitle().equals("§6/cb1") || fws.getTitle().equals("§6/end") ||
                    fws.getTitle().equals("§6/farmwelt") || fws.getTitle().equals("§6/kickall") || fws.getTitle().equals("§6/lobby") ||
                    fws.getTitle().equals("§6/nether") || fws.getTitle().equals("§6/worldtp")) {
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(serui);
                    }
                }
                if (fws.getTitle().equals("§6/day") || fws.getTitle().equals("§6/getpos") || fws.getTitle().equals("§6/night")) {
                    if (button.equals("§cZurück")) {
                        player.showFormWindow(woui);
                    }
                }
            }
        }
    }
}
