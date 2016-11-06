package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.grzegorz2047.api.util.ColoringUtil;

/**
 * Created by grzeg on 30.10.2016.
 */
public class PlaceBreakListener implements Listener {

    private final CDTP plugin;

    public PlaceBreakListener(CDTP plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if(p.hasPermission("cdp.admin")){
            return;
        }
        int prot = plugin.getSettings().getProtectedSpawnRadius();
        if (p.getWorld().getSpawnLocation().distance(p.getLocation()) < prot) {
            e.setCancelled(true);
            p.sendMessage(ColoringUtil.colorText("&cNie mozesz ingerowac w bloki na spawnie!"));
        }
    }

    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if(p.hasPermission("cdp.admin")){
            return;
        }
        int prot = plugin.getSettings().getProtectedSpawnRadius();
        if (p.getWorld().getSpawnLocation().distance(p.getLocation()) < prot) {
            e.setCancelled(true);
            p.sendMessage(ColoringUtil.colorText("&cNie mozesz ingerowac w bloki na spawnie!"));
        }
    }
    public void onEmpty(PlayerBucketEmptyEvent e) {
        Player p = e.getPlayer();
        int prot = plugin.getSettings().getProtectedSpawnRadius();
        if (p.getWorld().getSpawnLocation().distance(p.getLocation()) < prot) {
            e.setCancelled(true);
            p.sendMessage(ColoringUtil.colorText("&cNie mozesz ingerowac w bloki na spawnie!"));
        }
    }
    public void onFill(PlayerBucketFillEvent e) {
        Player p = e.getPlayer();
        int prot = plugin.getSettings().getProtectedSpawnRadius();
        if (p.getWorld().getSpawnLocation().distance(p.getLocation()) < prot) {
            e.setCancelled(true);
            p.sendMessage(ColoringUtil.colorText("&cNie mozesz ingerowac w bloki na spawnie!"));
        }
    }
}
