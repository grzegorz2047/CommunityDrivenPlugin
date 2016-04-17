package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.mozilla.javascript.Kit;
import pl.craftgames.communityplugin.cdtp.kits.Kits;

/**
 * Created by grzegorz2047 on 17.04.2016
 */
public class PlayerRespawnListener implements Listener {


    @EventHandler
    void onPlayerRespawn(PlayerRespawnEvent e){
        Player p = e.getPlayer();
        if(!p.hasPermission("lobby.svip")){
            Kits.giveDefaultKit(e.getPlayer());
        }else{
            Kits.giveVipKit(p);
        }
    }
}
