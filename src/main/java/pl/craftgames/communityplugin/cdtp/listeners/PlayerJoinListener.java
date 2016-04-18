package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.craftgames.communityplugin.cdtp.kits.Kits;

/**
 * Created by grzegorz2047 on 17.04.2016
 */
public class PlayerJoinListener implements Listener {

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        if (e.getPlayer() == null) {
            return;
        }
        Player p = e.getPlayer();
        if (!p.hasPlayedBefore()) {
            Kits.giveFirstPlayKit(p);
        }
    }
}
