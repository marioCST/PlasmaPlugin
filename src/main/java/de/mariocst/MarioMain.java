package de.mariocst;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.command.CommandMap;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Sound;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.scheduler.ServerScheduler;
import cn.nukkit.utils.Config;
import de.mariocst.AntiCheat.AntiCheatAPI;
import de.mariocst.AntiCheat.Cheat.AntiCheat;
import de.mariocst.AntiCheat.Cheat.Report;
import de.mariocst.AntiCheat.Cheat.inventory.InvalidItemEnchantmentCheckThread;
import de.mariocst.AntiCheat.Config.MasterConfig;
import de.mariocst.AntiCheat.Config.PlayerCheatRecord;
import de.mariocst.AntiCheat.Event.Listener.*;
import de.mariocst.Commands.Announcements.*;
import de.mariocst.Commands.Chat.*;
import de.mariocst.Commands.Inventory.*;
import de.mariocst.Commands.Player.*;
import de.mariocst.Commands.Player.Movement.*;
import de.mariocst.Commands.Report.*;
import de.mariocst.Commands.Send.*;
import de.mariocst.Commands.Server.*;
import de.mariocst.Commands.Others.*;
import de.mariocst.Commands.World.*;
import de.mariocst.Config.*;
import de.mariocst.Forms.FormAdminItems;
import de.mariocst.Forms.FormListener;
import de.mariocst.Forms.FormTroll;
import de.mariocst.Forms.FormWindows;
import de.mariocst.Listeners.*;
import lombok.Getter;

import java.util.HashMap;

public class MarioMain extends PluginBase implements AntiCheatAPI {
    private static MarioMain instance;

    private static String prefix = "§8[§1Plasma§8] §b";

    private static MasterConfig masterConfig;
    private PlayerCheatRecord playerCheatRecord;
    private PlayerIllegalItems playerIllegalItems;
    private static PlayerIllegalItems playerIllegalItemsS;

    public static HashMap<String, Report> reportThread = new HashMap<>();
    public static HashMap<String, AntiCheat.CheatType> reportPlayer = new HashMap<>();

    @Getter
    public FormWindows formWindows;

    @Getter
    public FormTroll formTroll;

    @Getter
    public FormAdminItems formAdminItems;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        register();
        initConfig();

        log("Plasma PlugIn geladen!");
    }

    @Override
    public void onDisable() {
        log("Plasma PlugIn entladen!");
    }

    public void log(String text) {
        getLogger().info(getPrefix() + text);
    }

    private void initConfig() {
        Config c = new Config(this.getDataFolder() + "/config.yml", Config.YAML);
        masterConfig = new MasterConfig(c.getRootSection());
        if (masterConfig.isEmpty()) {
            this.getLogger().warning("Die Config ist leer!");
        }
        playerCheatRecord = new PlayerCheatRecord(new Config(this.getDataFolder() + "/record.yml", Config.YAML).getRootSection());
        playerIllegalItems = new PlayerIllegalItems(new Config(this.getDataFolder() + "/bannedIllegalPlayers.yml", Config.YAML).getRootSection());
    }

    @Override
    public void addRecord(Player player, AntiCheat.CheatType cheatType) {
        playerCheatRecord.addRecord(player, cheatType);
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void setPrefix(String prefix) {
        MarioMain.prefix = prefix;
    }

    private void register() {
        CommandMap commandMap = getServer().getCommandMap();

        // Announcements
        commandMap.register("broadcast5", new Custom(this));
        commandMap.register("announcekick", new Kick(this));
        commandMap.register("announcerestart", new Restart(this));
        commandMap.register("announcestop", new Stop(this));

        // Chat
        commandMap.register("broadcast", new BroadcastCommand(this));
        commandMap.register("chatclear", new ChatClearCommand(this));

        // Inventory
        commandMap.register("adminitems", new AdminItemsCommand(this));
        commandMap.register("clear", new ClearInventoryCommand(this));
        commandMap.register("giveitems", new GiveItemsCommand(this));
        commandMap.register("id", new IDCommand(this));
        commandMap.register("invsee", new InvseeCommand(this));
        commandMap.register("tnt", new TNTCommand(this));

        // Others
        commandMap.register("discord", new DiscordCommand(this));
        commandMap.register("mhelp", new MarioHelpCommand(this));

        // Player
        commandMap.register("die", new DieCommand(this));
        commandMap.register("getgamemode", new GetGamemodeCommand(this));
        commandMap.register("gm", new GMCommand(this));
        commandMap.register("heal", new HealCommand(this));
        commandMap.register("nick", new NickCommand(this));
        commandMap.register("nightvision", new NightvisionCommand(this));
        commandMap.register("size", new SizeCommand(this));
        commandMap.register("skin", new SkinCommand(this));
        commandMap.register("troll", new TrollCommand(this));
        commandMap.register("unnick", new UnnickCommand(this));
            // Movement
            commandMap.register("climb", new ClimbCommand(this));
            commandMap.register("fly", new FlyCommand(this));
            commandMap.register("freeze", new FreezeCommand(this));
            commandMap.register("speed", new SpeedCommand(this));

        // Report
        commandMap.register("marioacreport", new MarioACReportCommand(this));

        // Send
        commandMap.register("sendactionbar", new SendActionbarCommand(this));
        commandMap.register("sendmessage", new SendMessageCommand(this));
        commandMap.register("sendtitle", new SendTitleCommand(this));

        // Server
        commandMap.register("adminshop", new AdminshopCommand(this));
        commandMap.register("cb1", new CB1Command(this));
        commandMap.register("end", new EndCommand(this));
        commandMap.register("farmwelt", new FarmweltCommand(this));
        commandMap.register("kickall", new KickAllCommand(this));
        commandMap.register("lobby", new LobbyCommand(this));
        commandMap.register("nether", new NetherCommand(this));
        commandMap.register("rand", new RandCommand(this));
        commandMap.register("wand", new WandCommand(this));
        commandMap.register("worldtp", new WorldTPCommand(this));

        // World
        commandMap.register("day", new DayCommand(this));
        commandMap.register("getpos", new GetPosCommand(this));
        commandMap.register("night", new NightCommand(this));


        // Events/Listener
        PluginManager manager = this.getServer().getPluginManager();

        manager.registerEvents(new AchievementListener(), this);
        manager.registerEvents(new CoordinatesListener(), this);
        manager.registerEvents(new DeathListener(), this);
        manager.registerEvents(new EventListener(), this);
        manager.registerEvents(new FormListener(), this);
        manager.registerEvents(new HungerListener(), this);
        manager.registerEvents(new ItemListener(), this);
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new MarioHelpUIListener(), this);
        manager.registerEvents(new QuitListener(), this);
        manager.registerEvents(new RandListener(), this);
        manager.registerEvents(new UIListener(), this);
        manager.registerEvents(new WandListener(), this);


        // Scheduler
        ServerScheduler scheduler = this.getServer().getScheduler();

        scheduler.scheduleRepeatingTask(new InvalidItemEnchantmentCheckThread(), 10);


        // Form Windows
        this.formWindows = new FormWindows();
        this.formTroll = new FormTroll();
        this.formAdminItems = new FormAdminItems();
    }

    public static MarioMain getInstance() {
        return instance;
    }

    @Override
    public MasterConfig getMasterConfig() {
        return masterConfig;
    }

    public static void addIllegalPlayer(Player player) {
        playerIllegalItemsS.addIllegalPlayer(player);
    }

    public static void unknownPlayer(CommandSender sender) {
        sender.sendMessage(MarioMain.getPrefix() + "Unbekannter Spieler!");

        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
        }
    }

    public static boolean hasFly(Player player) {
        return player.getAdventureSettings().get(AdventureSettings.Type.ALLOW_FLIGHT);
    }
}
