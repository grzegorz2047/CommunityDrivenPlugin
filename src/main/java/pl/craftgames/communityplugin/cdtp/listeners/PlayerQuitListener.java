package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
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
        e.setQuitMessage(null);
        Fight f = plugin.getAntiLogoutManager().getFightList().get(p.getName());
        if (f != null) {
            p.damage(30);
            p.sendMessage(ChatColor.RED + "Wylogowales sie podczas walki!");
            if (!f.getAttacker().equals(p.getName())) {
                Player attacker = Bukkit.getPlayer(f.getAttacker());
                if (attacker != null) {
                    attacker.sendMessage(("Gracz {PLAYER} wylogowal sie podczas walki!").replace("{PLAYER}", p.getName()));
                }
            }
        }
    }

}
