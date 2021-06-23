package de.mariocst.Forms;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.level.Sound;
import de.mariocst.Forms.custom.CustomForm;
import de.mariocst.Forms.simple.SimpleForm;
import de.mariocst.MarioMain;

import java.util.HashMap;

public class FormAdminItems {
    public static HashMap<String, String> messages = new HashMap<>();

    public static String getNP(String key, String description, Object... replacements) {
        String message = messages.getOrDefault(key, description).replace("&", "§");

        int i = 0;
        for (Object replacement : replacements) {
            message = message.replace("[" + i + "]", String.valueOf(replacement));
            i++;
        }

        return message;
    }

    public void openAdminItems(Player player) {
        SimpleForm form = new SimpleForm.Builder("§cAdmin Items",
                getNP("", "§aSuch dir ein Item aus!"))
                .addButton(new ElementButton("§6Barrier", new ElementButtonImageData("path", "textures/blocks/barrier.png")), e -> this.openBarrierMenu(player))
                .addButton(new ElementButton("§6Structure Block", new ElementButtonImageData("path", "textures/blocks/structure_block.png")), e -> this.openStructureBlockMenu(player))
                .addButton(new ElementButton("§6Structure Void", new ElementButtonImageData("path", "textures/blocks/structure_void.png")), e -> this.openStructureVoidMenu(player))
                .addButton(new ElementButton("§6Allow Block", new ElementButtonImageData("path", "textures/blocks/build_allow.png")), e -> this.openAllowBlockMenu(player))
                .addButton(new ElementButton("§6Deny Block", new ElementButtonImageData("path", "textures/blocks/build_deny.png")), e -> this.openDenyBlockMenu(player))
                .addButton(new ElementButton("§6Border Block", new ElementButtonImageData("path", "textures/blocks/border.png")), e -> this.openBorderBlockMenu(player))
                .build();
        form.send(player);
    }

    public void openBarrierMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§6Barrier")
                .addElement(new ElementInput("Anzahl", player.getName()))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount = Integer.parseInt(r.getInputResponse(0));

                        if (amount > 64) {
                            player.sendMessage(MarioMain.getPrefix() + "Bitte wähle eine kleinere Zahl!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "give " + player.getName() + " -161 " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast " + amount + " Barriers bekommen!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                    }
                })
                .build();
        form.send(player);
    }

    public void openStructureBlockMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§6Structure Block")
                .addElement(new ElementInput("Anzahl", player.getName()))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount = Integer.parseInt(r.getInputResponse(0));

                        if (amount > 64) {
                            player.sendMessage(MarioMain.getPrefix() + "Bitte wähle eine kleinere Zahl!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "give " + player.getName() + " 252 " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast " + amount + " Structure Blöcke bekommen!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                    }
                })
                .build();
        form.send(player);
    }

    public void openStructureVoidMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§6Structure Void")
                .addElement(new ElementInput("Anzahl", player.getName()))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount = Integer.parseInt(r.getInputResponse(0));

                        if (amount > 64) {
                            player.sendMessage(MarioMain.getPrefix() + "Bitte wähle eine kleinere Zahl!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "give " + player.getName() + " 217 " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast " + amount + " Structure Void bekommen!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                    }
                })
                .build();
        form.send(player);
    }

    public void openAllowBlockMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§6Allow Block")
                .addElement(new ElementInput("Anzahl", player.getName()))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount = Integer.parseInt(r.getInputResponse(0));

                        if (amount > 64) {
                            player.sendMessage(MarioMain.getPrefix() + "Bitte wähle eine kleinere Zahl!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "give " + player.getName() + " 210 " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast " + amount + " Allow Blöcke bekommen!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                    }
                })
                .build();
        form.send(player);
    }

    public void openDenyBlockMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§6Deny Block")
                .addElement(new ElementInput("Anzahl", player.getName()))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount = Integer.parseInt(r.getInputResponse(0));

                        if (amount > 64) {
                            player.sendMessage(MarioMain.getPrefix() + "Bitte wähle eine kleinere Zahl!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "give " + player.getName() + " 211 " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast " + amount + " Deny Blöcke bekommen!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                    }
                })
                .build();
        form.send(player);
    }

    public void openBorderBlockMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§6Border Block")
                .addElement(new ElementInput("Anzahl", player.getName()))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount = Integer.parseInt(r.getInputResponse(0));

                        if (amount > 64) {
                            player.sendMessage(MarioMain.getPrefix() + "Bitte wähle eine kleinere Zahl!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "give " + player.getName() + " 212 " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast " + amount + " Border Blöcke bekommen!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                    }
                })
                .build();
        form.send(player);
    }

    private void dispatchCommand(CommandSender sender, String commandLine) {
        MarioMain.getInstance().getServer().dispatchCommand(sender, commandLine);
    }

    private ConsoleCommandSender consoleSender() {
        return MarioMain.getInstance().getServer().getConsoleSender();
    }
}
