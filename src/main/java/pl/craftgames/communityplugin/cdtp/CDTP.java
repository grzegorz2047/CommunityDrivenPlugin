package pl.craftgames.communityplugin.cdtp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
        System.out.println(this.getName()+" zostal wlaczony!");
    }

    @Override
    public void onEnable() {
        registerListeners();
        System.out.println(this.getName()+" zostal wylaczony!");
        this.getCommand("test").setExecutor(this);
    }
    private void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerRespawnListener(), this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("test")){
            Bukkit.broadcastMessage("Test!");
            System.out.println("Plugin dziala!");
            return true;
        }
        return true;
    }
}
