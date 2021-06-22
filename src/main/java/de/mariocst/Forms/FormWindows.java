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
import me.onebone.economyapi.EconomyAPI;

import java.util.HashMap;

public class FormWindows {
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

    public void openAdminshop(Player player) {
        SimpleForm form = new SimpleForm.Builder("§cAdminshop",
                getNP("", "§aSuch dir eine Kategorie aus!"))
                .addButton(new ElementButton("§6Erze"), e -> this.openOreMenu(player))
                .addButton(new ElementButton("§6Holzstämme"), e -> this.openWoodMenu(player))
                .build();
        form.send(player);
    }

    public void openOreMenu(Player player) {
        SimpleForm form = new SimpleForm.Builder("§cErze",
                getNP("", "§aSuch dir ein Erz aus!"))
                .addButton(new ElementButton("§0Kohle || 25$", new ElementButtonImageData("url", "https://raw.githubusercontent.com/marioCST/PlasmaTextures/main/coal.png?token=AQJ2PAJ27VRNV4AVZG7ZJADA2HEHG")), e -> this.openCoalMenu(player))
                .addButton(new ElementButton("§fEisen Barren || 50$", new ElementButtonImageData("url", "https://raw.githubusercontent.com/marioCST/PlasmaTextures/main/iron_ingot.png?token=AQJ2PANEVKY3QQTU3322NG3A2HKMA")), e -> this.openIronIngotMenu(player))
                .addButton(new ElementButton("§eGold Barren || 75$", new ElementButtonImageData("url", "https://raw.githubusercontent.com/marioCST/PlasmaTextures/main/gold_ingot.png?token=AQJ2PALWLYTP6QXMU6JYMNTA2HMWY")), e -> this.openGoldIngotMenu(player))
                .addButton(new ElementButton("§4Redstone || 30$", new ElementButtonImageData("url", "https://raw.githubusercontent.com/marioCST/PlasmaTextures/main/redstone.png?token=AQJ2PAP524WGNHAWMFTLLNTA2HKN2")), e -> this.openRedstoneMenu(player))
                .addButton(new ElementButton("§1Lapis Lazuli || 80$", new ElementButtonImageData("url", "https://raw.githubusercontent.com/marioCST/PlasmaTextures/main/lapis_lazuli.png?token=AQJ2PAPMTR3SFEAT7O2TWPDA2HKM4")), e -> this.openLapisLazuliMenu(player))
                .addButton(new ElementButton("§bDiamant || 125$", new ElementButtonImageData("url", "https://raw.githubusercontent.com/marioCST/PlasmaTextures/main/diamond.png?token=AQJ2PAI34S6WE5YTPDSPATLA2HMUQ")), e -> this.openDiamondMenu(player))
                .addButton(new ElementButton("§2Smaragd || 200$", new ElementButtonImageData("url", "https://raw.githubusercontent.com/marioCST/PlasmaTextures/main/emerald.png?token=AQJ2PAMSUNLELOXFNSOZ7XTA2HMV2")), e -> this.openEmeraldMenu(player))
                .addButton(new ElementButton("§fQuartz || 40$", new ElementButtonImageData("url", "https://raw.githubusercontent.com/marioCST/PlasmaTextures/main/quartz.png?token=AQJ2PAMDBIH7O6HNSHRL2CLA2HJA4")), e -> this.openQuartzMenu(player))
                .addButton(new ElementButton("§cAncient Debris || 500$", new ElementButtonImageData("url", "https://raw.githubusercontent.com/marioCST/PlasmaTextures/main/ancient_debris_side.png?token=AQJ2PAJMZNJFBDDBZW3RSFTA2HKXU")), e -> this.openAncientDebrisMenu(player))
                .addButton(new ElementButton("§cZurück"), e -> this.openAdminshop(player))
                .build();
        form.send(player);
    }

    public void openWoodMenu(Player player) {
        SimpleForm form = new SimpleForm.Builder("§cStämme",
                getNP("", "§aSuch dir ein Holz aus!"))
                .addButton(new ElementButton("§6Eiche || 15$", new ElementButtonImageData("url", "https://raw.githubusercontent.com/marioCST/PlasmaTextures/main/oak_log.png?token=AQJ2PALUILLOLKCFWHWNKQLA2HFNC")), e -> this.openOakMenu(player))
                .addButton(new ElementButton("§6Birke || 15$", new ElementButtonImageData("url", "https://raw.githubusercontent.com/marioCST/PlasmaTextures/main/birch_log.png?token=AQJ2PANOWDRPFDGLNMUG5ULA2HFKS")), e -> this.openBirchMenu(player))
                .addButton(new ElementButton("§6Fichte || 15$", new ElementButtonImageData("url", "https://raw.githubusercontent.com/marioCST/PlasmaTextures/main/spruce_log.png?token=AQJ2PAJRHAZ5TCRFLMC3Z63A2HFOI")), e -> this.openSpruceMenu(player))
                .addButton(new ElementButton("§6Dschungel || 15$", new ElementButtonImageData("url", "https://raw.githubusercontent.com/marioCST/PlasmaTextures/main/jungle_log.png?token=AQJ2PAJLDJVYHCXUEVPUNS3A2HFL2")), e -> this.openJungleMenu(player))
                .addButton(new ElementButton("§cZurück"), e -> this.openAdminshop(player))
                .build();
        form.send(player);
    }

    public void openCoalMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§1Kohle")
                .addElement(new ElementInput("Anzahl", "64"))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Menge ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount =Integer.parseInt(r.getInputResponse(0));
                        long price = 25L * amount;

                        if (EconomyAPI.getInstance().myMoney(player) < price) {
                            player.sendMessage(MarioMain.getPrefix() + "Du hast nicht genügend Geld! Du brauchst: " + price + "$!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "takemoney " + player.getName() + " " + price);
                            dispatchCommand(consoleSender(), "give " + player.getName() + " coal " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast für " + price + "$ " + amount + " Kohle gekauft!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige oder ganze Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                })
                .build();
        form.send(player);
    }

    public void openIronIngotMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§fEisen Barren")
                .addElement(new ElementInput("Anzahl", "64"))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Menge ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount =Integer.parseInt(r.getInputResponse(0));
                        long price = 50L * amount;

                        if (EconomyAPI.getInstance().myMoney(player) < price) {
                            player.sendMessage(MarioMain.getPrefix() + "Du hast nicht genügend Geld! Du brauchst: " + price + "$!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "takemoney " + player.getName() + " " + price);
                            dispatchCommand(consoleSender(), "give " + player.getName() + " iron_ingot " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast für " + price + "$ " + amount + " Eisen Barren gekauft!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige oder ganze Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                })
                .build();
        form.send(player);
    }

    public void openGoldIngotMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§eGold Barren")
                .addElement(new ElementInput("Anzahl", "64"))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Menge ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount =Integer.parseInt(r.getInputResponse(0));
                        long price = 75L * amount;

                        if (EconomyAPI.getInstance().myMoney(player) < price) {
                            player.sendMessage(MarioMain.getPrefix() + "Du hast nicht genügend Geld! Du brauchst: " + price + "$!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "takemoney " + player.getName() + " " + price);
                            dispatchCommand(consoleSender(), "give " + player.getName() + " gold_ingot " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast für " + price + "$ " + amount + " Gold Barren gekauft gekauft!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige oder ganze Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                })
                .build();
        form.send(player);
    }

    public void openRedstoneMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§cRedstone")
                .addElement(new ElementInput("Anzahl", "64"))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Menge ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount =Integer.parseInt(r.getInputResponse(0));
                        long price = 30L * amount;

                        if (EconomyAPI.getInstance().myMoney(player) < price) {
                            player.sendMessage(MarioMain.getPrefix() + "Du hast nicht genügend Geld! Du brauchst: " + price + "$!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "takemoney " + player.getName() + " " + price);
                            dispatchCommand(consoleSender(), "give " + player.getName() + " redstone " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast für " + price + "$ " + amount + " Redstone gekauft!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige oder ganze Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                })
                .build();
        form.send(player);
    }

    public void openLapisLazuliMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§1Lapis Lazuli")
                .addElement(new ElementInput("Anzahl", "64"))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Menge ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount =Integer.parseInt(r.getInputResponse(0));
                        long price = 80L * amount;

                        if (EconomyAPI.getInstance().myMoney(player) < price) {
                            player.sendMessage(MarioMain.getPrefix() + "Du hast nicht genügend Geld! Du brauchst: " + price + "$!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "takemoney " + player.getName() + " " + price);
                            dispatchCommand(consoleSender(), "give " + player.getName() + " lapis_lazuli " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast für " + price + "$ " + amount + " Lapis Lazuli gekauft!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige oder ganze Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                })
                .build();
        form.send(player);
    }

    public void openDiamondMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§bDiamant")
                .addElement(new ElementInput("Anzahl", "64"))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Menge ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount =Integer.parseInt(r.getInputResponse(0));
                        long price = 125L * amount;

                        if (EconomyAPI.getInstance().myMoney(player) < price) {
                            player.sendMessage(MarioMain.getPrefix() + "Du hast nicht genügend Geld! Du brauchst: " + price + "$!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "takemoney " + player.getName() + " " + price);
                            dispatchCommand(consoleSender(), "give " + player.getName() + " diamond " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast für " + price + "$ " + amount + " Diamanten gekauft!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige oder ganze Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                })
                .build();
        form.send(player);
    }

    public void openEmeraldMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§2Smaragd")
                .addElement(new ElementInput("Anzahl", "64"))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Menge ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount =Integer.parseInt(r.getInputResponse(0));
                        long price = 200L * amount;

                        if (EconomyAPI.getInstance().myMoney(player) < price) {
                            player.sendMessage(MarioMain.getPrefix() + "Du hast nicht genügend Geld! Du brauchst: " + price + "$!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "takemoney " + player.getName() + " " + price);
                            dispatchCommand(consoleSender(), "give " + player.getName() + " emerald " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast für " + price + "$ " + amount + " Smaragde gekauft!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige oder ganze Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                })
                .build();
        form.send(player);
    }

    public void openQuartzMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§fQuartz")
                .addElement(new ElementInput("Anzahl", "64"))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Menge ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount =Integer.parseInt(r.getInputResponse(0));
                        long price = 40L * amount;

                        if (EconomyAPI.getInstance().myMoney(player) < price) {
                            player.sendMessage(MarioMain.getPrefix() + "Du hast nicht genügend Geld! Du brauchst: " + price + "$!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "takemoney " + player.getName() + " " + price);
                            dispatchCommand(consoleSender(), "give " + player.getName() + " 406 " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast für " + price + "$ " + amount + " Quartz gekauft!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige oder ganze Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                })
                .build();
        form.send(player);
    }

    public void openAncientDebrisMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§cAncient Debris")
                .addElement(new ElementInput("Anzahl", "64"))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Menge ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount =Integer.parseInt(r.getInputResponse(0));
                        long price = 500L * amount;

                        if (EconomyAPI.getInstance().myMoney(player) < price) {
                            player.sendMessage(MarioMain.getPrefix() + "Du hast nicht genügend Geld! Du brauchst: " + price + "$!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "takemoney " + player.getName() + " " + price);
                            dispatchCommand(consoleSender(), "give " + player.getName() + " ancient_debris " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast für " + price + "$ " + amount + " Ancient Debris gekauft!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige oder ganze Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                })
                .build();
        form.send(player);
    }

    public void openOakMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§6Eiche")
                .addElement(new ElementInput("Anzahl", "64"))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Menge ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount =Integer.parseInt(r.getInputResponse(0));
                        long price = 15L * amount;

                        if (EconomyAPI.getInstance().myMoney(player) < price) {
                            player.sendMessage(MarioMain.getPrefix() + "Du hast nicht genügend Geld! Du brauchst: " + price + "$!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "takemoney " + player.getName() + " " + price);
                            dispatchCommand(consoleSender(), "give " + player.getName() + " 17 " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast für " + price + "$ " + amount + " Eichenstämme gekauft!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige oder ganze Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                })
                .build();
        form.send(player);
    }

    public void openBirchMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§6Birke")
                .addElement(new ElementInput("Anzahl", "64"))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Menge ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount =Integer.parseInt(r.getInputResponse(0));
                        long price = 15L * amount;

                        if (EconomyAPI.getInstance().myMoney(player) < price) {
                            player.sendMessage(MarioMain.getPrefix() + "Du hast nicht genügend Geld! Du brauchst: " + price + "$!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "takemoney " + player.getName() + " " + price);
                            dispatchCommand(consoleSender(), "give " + player.getName() + " 17:2 " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast für " + price + "$ " + amount + " Birkenstämme gekauft!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige oder ganze Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                })
                .build();
        form.send(player);
    }

    public void openSpruceMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§6Fichte")
                .addElement(new ElementInput("Anzahl", "64"))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Menge ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount =Integer.parseInt(r.getInputResponse(0));
                        long price = 15L * amount;

                        if (EconomyAPI.getInstance().myMoney(player) < price) {
                            player.sendMessage(MarioMain.getPrefix() + "Du hast nicht genügend Geld! Du brauchst: " + price + "$!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "takemoney " + player.getName() + " " + price);
                            dispatchCommand(consoleSender(), "give " + player.getName() + " 17:1 " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast für " + price + "$ " + amount + " Fichtenstämme gekauft!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige oder ganze Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                })
                .build();
        form.send(player);
    }

    public void openJungleMenu(Player player) {
        CustomForm form = new CustomForm.Builder("§6Dschungel")
                .addElement(new ElementInput("Anzahl", "64"))
                .onSubmit((e, r) -> {
                    if (r.getInputResponse(0).isEmpty()) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine Menge ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }

                    try {
                        int amount =Integer.parseInt(r.getInputResponse(0));
                        long price = 15L * amount;

                        if (EconomyAPI.getInstance().myMoney(player) < price) {
                            player.sendMessage(MarioMain.getPrefix() + "Du hast nicht genügend Geld! Du brauchst: " + price + "$!");
                        }
                        else {
                            dispatchCommand(consoleSender(), "takemoney " + player.getName() + " " + price);
                            dispatchCommand(consoleSender(), "give " + player.getName() + " 17:3 " + amount);

                            player.sendMessage(MarioMain.getPrefix() + "Du hast für " + price + "$ " + amount + " Dschungelstämme gekauft!");
                        }
                    }
                    catch (NumberFormatException n) {
                        n.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige oder ganze Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
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
