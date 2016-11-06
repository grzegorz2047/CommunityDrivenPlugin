package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.mozilla.javascript.Kit;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.antilogout.Fight;
import pl.craftgames.communityplugin.cdtp.kits.Kits;
import pl.grzegorz2047.databaseapi.SQLUser;

/**
 * Created by grzegorz2047 on 17.04.2016
 */
public class PlayerRespawnListener implements Listener {

    private final CDTP plugin;

    public PlayerRespawnListener(CDTP plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    void onPlayerRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        SQLUser sqlUser = plugin.getUserManager().getUsersCG().get(p.getName());
        if (sqlUser.getRank().equals("Gracz")) {
            Kits.giveDefaultKit(e.getPlayer());
        } else {
            Kits.giveVipKit(p);
        }

    }
}
