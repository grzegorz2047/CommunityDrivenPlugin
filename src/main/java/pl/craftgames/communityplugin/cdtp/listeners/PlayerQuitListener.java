package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by grzegorz2047 on 17.04.2016
 */
public class PlayerQuitListener implements Listener {

    @EventHandler
    void onPlayerQuit(PlayerQuitEvent e){
        e.setQuitMessage(null);
    }

}
