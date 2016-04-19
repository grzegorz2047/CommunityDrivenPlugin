package pl.craftgames.communityplugin.cdtp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pl.craftgames.communityplugin.cdtp.commands.cobblex.CobbleXCommand;
import pl.craftgames.communityplugin.cdtp.commands.drop.DropCommand;
import pl.craftgames.communityplugin.cdtp.commands.help.HelpCommand;
import pl.craftgames.communityplugin.cdtp.commands.spawn.SpawnCommand;
import pl.craftgames.communityplugin.cdtp.commands.vip.VIPCommand;
import pl.craftgames.communityplugin.cdtp.listeners.PlayerJoinListener;
import pl.craftgames.communityplugin.cdtp.listeners.PlayerQuitListener;
import pl.craftgames.communityplugin.cdtp.listeners.PlayerRespawnListener;
import pl.craftgames.communityplugin.cdtp.tasks.TaskManager;
import pl.craftgames.communityplugin.cdtp.teleport.TeleportManager;

/**
 * Created by grzegorz2047 on 17.04.2016 for Nukkit server
 */
public class CDTP extends JavaPlugin implements CommandExecutor {

    private Settings settings = new Settings();
    private TeleportManager teleportManager;
    private TaskManager taskManager;

    @Override
    public void onDisable() {
        this.taskManager.dispose();
        System.out.println(this.getName() + " zostal wlaczony!");
    }

    @Override
    public void onEnable() {
        taskManager = new TaskManager(this);
        teleportManager = new TeleportManager(this);
        registerListeners();
        registerCommands();
        System.out.println(this.getName() + " zostal wylaczony!");
    }

    private void registerCommands() {
        this.getCommand("vip").setExecutor(new VIPCommand("vip", new String[]{"vip", "extra", "support", "donator"}, this));
        this.getCommand("drop").setExecutor(new DropCommand("drop", this));
        this.getCommand("spawn").setExecutor(new SpawnCommand("spawn", this));
        this.getCommand("pomoc").setExecutor(new HelpCommand("pomoc", new String[]{"help", "pomoc", "commands"}, this));
        this.getCommand("cobblex").setExecutor(new CobbleXCommand("cobblex", new String[]{"cobblex", "cx", "pandora"}, this));

    }

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerQuitListener(), this);
        pm.registerEvents(new PlayerRespawnListener(), this);
    }

    public Settings getSettings() {
        return settings;
    }

    public TeleportManager getTeleportManager() {
        return teleportManager;
    }
}
