package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.kits.Kits;
import pl.craftgames.communityplugin.cdtp.user.User;
import pl.grzegorz2047.databaseapi.SQLUser;

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
        plugin.getSQLManager().addPlayer(p);
        User user = plugin.getSQLManager().getPlayer(p);
        SQLUser sqlUser = plugin.getPlayerManager().getPlayer(p);
        //System.out.print("User jest null");
        plugin.getUserManager().getUsersstats().put(p.getName(), user);
        plugin.getUserManager().getUsersCG().put(p.getName(), sqlUser);
        if (!sqlUser.getRank().equals("miniYT") && !sqlUser.getRank().equals("Gracz") && !sqlUser.getRank().equals("Youtube") && !sqlUser.getRank().equals("Vip")) {
            p.addAttachment(plugin, "nocheatplus.admin.notify", true);
            p.addAttachment(plugin, "vanish.vanish", true);
            p.addAttachment(plugin, "cg.admin", true);

        }
        if(p.getName().equals("xVeenix") || p.getName().equals("Koem")){
            p.addAttachment(plugin, "worldedit.*", true);
            p.addAttachment(plugin, "cdp.admin", true);
        }

        plugin.getSidebarData().createScoreboard(p);

        if (!p.hasPlayedBefore()) {
            Kits.giveFirstPlayKit(p, sqlUser);
        }

    }
}
