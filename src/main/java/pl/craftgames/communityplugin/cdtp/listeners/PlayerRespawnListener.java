package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import pl.craftgames.communityplugin.cdtp.kits.Kits;

/**
 * Created by grzegorz2047 on 17.04.2016
 */
public class PlayerRespawnListener implements Listener {


    @EventHandler
    void onPlayerRespawn(PlayerRespawnEvent e){
        Kits.giveDefaultKit(e.getPlayer());
    }
}
