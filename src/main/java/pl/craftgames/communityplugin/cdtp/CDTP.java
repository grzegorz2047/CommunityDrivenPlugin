package pl.craftgames.communityplugin.cdtp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pl.craftgames.communityplugin.cdtp.listeners.PlayerJoinListener;
import pl.craftgames.communityplugin.cdtp.listeners.PlayerRespawnListener;

/**
 * Created by grzegorz2047 on 17.04.2016 for Nukkit server
 */
public class CDTP extends JavaPlugin implements CommandExecutor {


    @Override
    public void onDisable() {
        System.out.println(this.getName() + " zostal wlaczony!");
    }

    @Override
    public void onEnable() {
        registerListeners();
        System.out.println(this.getName() + " zostal wylaczony!");
    }

    private void registerCommands() {
        this.getCommand("spawn").setExecutor(this);
        this.getCommand("drop").setExecutor(this);
        this.getCommand("help").setExecutor(this);

    }

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerRespawnListener(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("drop")) {
            if (!isPlayer(sender)) {
                sender.sendMessage("Komenda tylko dla gracza");
                return true;
            }
            Player p = (Player) sender;
            p.sendMessage(ChatColor.GRAY + "Drop:");
            p.sendMessage(ChatColor.GRAY + "Diament 1 %");
            p.sendMessage(ChatColor.GRAY + "Złoto 0.7%");
            p.sendMessage(ChatColor.GRAY + "Zelazo 2 %");
            p.sendMessage(ChatColor.GRAY + "Wegiel 3%");
            p.sendMessage(ChatColor.GRAY + "Szmaragdy 1.5%");
            p.sendMessage(ChatColor.GRAY + "Proch: 1%");
            p.sendMessage(ChatColor.GRAY + "Perły: 0.01%");
            p.sendMessage(ChatColor.GRAY + "Redstone: 1%");
            p.sendMessage(ChatColor.GRAY + "Ksiazka: 0.45%");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("help")) {
            if (!isPlayer(sender)) {
                sender.sendMessage("Komenda tylko dla gracza");
                return true;
            }
            Player p = (Player) sender;
            p.sendMessage(ChatColor.GRAY + "Dostepne komendy:");
            p.sendMessage(ChatColor.GRAY + "/drop");
            p.sendMessage(ChatColor.GRAY + "/spawn");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            if (!isPlayer(sender)) {
                sender.sendMessage("Komenda tylko dla gracza");
                return true;
            }
            Player p = (Player) sender;
            p.teleport(p.getWorld().getSpawnLocation());
            p.sendMessage(ChatColor.GRAY + "Przeteleportowano na spawn!");
            return true;
        }
        return true;
    }

    private boolean isPlayer(CommandSender sender) {
        if (!(sender instanceof Player)) {

            return false;
        }
        return true;
    }
}
