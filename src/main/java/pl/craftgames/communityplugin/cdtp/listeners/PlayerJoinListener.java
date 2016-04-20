package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.database.SQLManager;
import pl.craftgames.communityplugin.cdtp.kits.Kits;
import pl.craftgames.communityplugin.cdtp.scoreboard.SidebarData;
import pl.craftgames.communityplugin.cdtp.user.User;

/**
 * Created by grzegorz2047 on 17.04.2016
 */
public class PlayerJoinListener implements Listener {

    private final CDTP plugin;

    public PlayerJoinListener(CDTP plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        if (e.getPlayer() == null) {
            return;
        }
        Player p = e.getPlayer();
        p.addAttachment(plugin, "essentials.sethome", true);
        p.addAttachment(plugin, "essentials.delhome", true);
        p.addAttachment(plugin, "essentials.home", true);
        plugin.getSQLManager().addPlayer(p);
        User user = plugin.getSQLManager().getPlayer(p);
        //System.out.print("User jest null");
        plugin.getUserManager().getUsers().put(p.getName(), user);


        plugin.getSidebarData().createScoreboard(p);

        if (!p.hasPlayedBefore()) {
            Kits.giveFirstPlayKit(p);
        }

    }
}
