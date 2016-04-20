package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.antilogout.Fight;

/**
 * Created by grzegorz2047 on 19.04.2016
 */
public class PlayerDeathListener implements Listener {

    private final CDTP plugin;

    public PlayerDeathListener(CDTP plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        if(e.getEntity().getKiller() != null){
            Fight f = plugin.getAntiLogoutManager().getFightList().get(e.getEntity().getName());
            String attacker = f.getAttacker();
            String victim = f.getVictim();
            plugin.getAntiLogoutManager().getFightList().remove(attacker);
            plugin.getAntiLogoutManager().getFightList().remove(victim);
        }
    }
}
