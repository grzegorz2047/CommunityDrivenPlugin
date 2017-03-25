package pl.craftgames.communityplugin.cdtp.antilogout;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by grzeg on 23.12.2015.
 */
public class AntiLogoutManager {
    private final CDTP plugin;
    HashMap<String, Fight> fightList = new HashMap<String, Fight>();

    public AntiLogoutManager(CDTP plugin) {
        this.plugin = plugin;
    }

    public HashMap<String, Fight> getFightList() {
        return fightList;
    }

    public void checkFights() {
        List<String> toDelete = new ArrayList<String>();
        for (Map.Entry<String, Fight> entry : fightList.entrySet()) {
            if (entry.getValue().getEndCooldown() <= System.currentTimeMillis()) {
                toDelete.add(entry.getKey());
            }
        }
        for (String user : toDelete) {
            Player p = Bukkit.getPlayer(user);
            fightList.remove(user);
            if (p != null) {
                User obj = plugin.getUserManager().getUsersstats().get(p.getName());
                obj.setCanLogout(true);
                plugin.getSidebarData().refreshScoreboard(p);
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "AntyLogout" + ChatColor.GOLD + " »" + ChatColor.GRAY + " Mozesz sie juz wylogowac!");
            }
        }
    }
    public void dispose(){
        this.fightList.clear();
    }
}