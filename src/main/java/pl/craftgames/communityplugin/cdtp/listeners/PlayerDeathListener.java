package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.antilogout.Fight;
import pl.craftgames.communityplugin.cdtp.database.PlayerColumns;
import pl.craftgames.communityplugin.cdtp.user.User;

/**
 * Created by grzegorz2047 on 19.04.2016
 */
public class PlayerDeathListener implements Listener {

    private final CDTP plugin;

    public PlayerDeathListener(CDTP plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if(e.getEntity()== null){
            return;
        }
        plugin.getSQLManager().incrementColumn(e.getEntity().getName(), PlayerColumns.DEATHS, 1);
        User user = plugin.getUserManager().getUsers().get(e.getEntity().getName());
        user.setDeaths(user.getDeaths() + 1);
        plugin.getSidebarData().refreshScoreboard(e.getEntity());
        if (e.getEntity().getKiller() != null) {
            plugin.getSQLManager().incrementColumn(e.getEntity().getKiller().getName(), PlayerColumns.KILLS, 1);
            User killer = plugin.getUserManager().getUsers().get(e.getEntity().getKiller().getName());
            killer.setKills(killer.getKills() + 1);
            plugin.getSidebarData().refreshScoreboard(e.getEntity().getKiller());
            Fight f = plugin.getAntiLogoutManager().getFightList().get(e.getEntity().getName());
            String attacker = f.getAttacker();
            String victim = f.getVictim();
            plugin.getAntiLogoutManager().getFightList().remove(attacker);
            plugin.getAntiLogoutManager().getFightList().remove(victim);
        }
    }
}
