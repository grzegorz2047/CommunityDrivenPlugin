package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.antilogout.Fight;

/**
 * Created by grzegorz2047 on 17.04.2016
 */
public class PlayerQuitListener implements Listener {

    private final CDTP plugin;

    public PlayerQuitListener(CDTP plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        plugin.getUserManager().getUsersstats().remove(p.getName());
        plugin.getUserManager().getUsersCG().remove(p.getDisplayName());
        e.setQuitMessage(null);
        Fight f = plugin.getAntiLogoutManager().getFightList().get(p.getName());
        if (f != null) {

            p.sendMessage(ChatColor.RED + "Wylogowales sie podczas walki!");
            if (!f.getAttacker().equals(p.getName())) {
                Player attacker = Bukkit.getPlayer(f.getAttacker());
                Player attacked = Bukkit.getPlayer(f.getVictim());
                if (attacker != null) {
                    attacker.sendMessage(("§7§c§lGracz {PLAYER} wylogowal sie podczas walki i stracil wszystkie przedmioty!").replace("{PLAYER}", p.getName()));
                    attacked.damage(40);
                }
            }
        }
    }

}
