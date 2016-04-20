package pl.craftgames.communityplugin.cdtp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pl.craftgames.communityplugin.cdtp.antilogout.AntiLogoutManager;
import pl.craftgames.communityplugin.cdtp.commands.cobblex.CobbleXCommand;
import pl.craftgames.communityplugin.cdtp.commands.drop.DropCommand;
import pl.craftgames.communityplugin.cdtp.commands.help.HelpCommand;
import pl.craftgames.communityplugin.cdtp.commands.shop.ShopCommand;
import pl.craftgames.communityplugin.cdtp.commands.spawn.SpawnCommand;
import pl.craftgames.communityplugin.cdtp.commands.vip.VIPCommand;
import pl.craftgames.communityplugin.cdtp.database.SQLManager;
import pl.craftgames.communityplugin.cdtp.listeners.*;
import pl.craftgames.communityplugin.cdtp.scoreboard.SidebarData;
import pl.craftgames.communityplugin.cdtp.shop.Shop;
import pl.craftgames.communityplugin.cdtp.tasks.TaskManager;
import pl.craftgames.communityplugin.cdtp.teleport.TeleportManager;
import pl.craftgames.communityplugin.cdtp.user.UserManager;

/**
 * Created by grzegorz2047 on 17.04.2016 for Nukkit server
 */
public class CDTP extends JavaPlugin {

    private Settings settings = new Settings();
    private TeleportManager teleportManager;
    private TaskManager taskManager;
    private AntiLogoutManager antiLogoutManager;
    private SQLManager sqlManager;
    private UserManager userManager;
    private SidebarData sidebarData;
    private Shop shop;
    @Override
    public void onDisable() {
        this.antiLogoutManager.dispose();
        this.taskManager.dispose();

        System.out.println(this.getName() + " zostal wlaczony!");
    }

    @Override
    public void onEnable() {
        sidebarData = new SidebarData(this);
        userManager = new UserManager();
        taskManager = new TaskManager(this);
        teleportManager = new TeleportManager(this);
        antiLogoutManager = new AntiLogoutManager(this);
        this.sqlManager = new SQLManager(this, "", 3306, "", "", "");
        this.shop = new Shop(this);
        registerListeners();
        registerCommands();
        System.out.println(this.getName() + " zostal wylaczony!");
    }

    private void registerCommands() {
        this.getCommand("vip").setExecutor(new VIPCommand("vip", new String[]{"vip", "extra", "support", "donator"}, this));
        this.getCommand("drop").setExecutor(new DropCommand("drop", this));
        this.getCommand("spawn").setExecutor(new SpawnCommand("spawn", this));
        this.getCommand("shop").setExecutor(new ShopCommand("shop", this));
        this.getCommand("pomoc").setExecutor(new HelpCommand("pomoc", new String[]{"help", "pomoc", "commands"}, this));
        this.getCommand("cobblex").setExecutor(new CobbleXCommand("cobblex", new String[]{"cobblex", "cx", "pandora"}, this));
    }

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(this), this);
        pm.registerEvents(new PlayerQuitListener(this), this);
        pm.registerEvents(new PlayerRespawnListener(this), this);
        pm.registerEvents(new EntityDamageEntityListener(this), this);
        pm.registerEvents(new PlayerDeathListener(this), this);
        pm.registerEvents(shop, this);//instance only 1
    }

    public Settings getSettings() {
        return settings;
    }

    public TeleportManager getTeleportManager() {
        return teleportManager;
    }

    public AntiLogoutManager getAntiLogoutManager() {
        return antiLogoutManager;
    }

    public Settings getSettingsManager() {
        return settings;
    }

    public SQLManager getSQLManager() {
        return sqlManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public SidebarData getSidebarData() {
        return sidebarData;
    }

    public Shop getShop() {
        return shop;
    }
}
