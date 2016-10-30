package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.antilogout.Fight;
import pl.craftgames.communityplugin.cdtp.database.PlayerColumns;
import pl.craftgames.communityplugin.cdtp.user.User;

/**
 * Created by grzegorz2047 on 19.04.2016
 */
public class PlayerDeathListener implements Listener {

    private final CDTP plugin;

    public PlayerDeathListener(CDTP plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (e.getEntity() == null) {
            return;
        }
        plugin.getSQLManager().incrementColumn(e.getEntity().getName(), PlayerColumns.DEATHS, 1);
        User user = plugin.getUserManager().getUsersstats().get(e.getEntity().getName());
        if(user == null){
            System.out.println("User jest null!?");
            return;
        }
        user.setDeaths(user.getDeaths() + 1);
        user.setCanLogout(true);
        e.getEntity().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Mozesz juz bezpiecznie sie wylogowac!");

        Player killerPlayer = e.getEntity().getKiller();
        if (killerPlayer != null) {
            plugin.getSQLManager().incrementColumn(e.getEntity().getKiller().getName(), PlayerColumns.KILLS, 1);
            User killer = plugin.getUserManager().getUsersstats().get(e.getEntity().getKiller().getName());

            killer.setMoney(killer.getMoney() + plugin.getSettingsManager().getMoneyForKill());
            plugin.getSQLManager().incrementColumn(e.getEntity().getKiller().getName(), PlayerColumns.MONEY, plugin.getSettingsManager().getMoneyForKill());
            killerPlayer.sendMessage("§6§l+" + plugin.getSettingsManager().getMoneyForKill() + " monet!");
            killer.setKills(killer.getKills() + 1);

            Bukkit.broadcastMessage("§c§l" + killer.getUsername() + "§r§7 zabil " + "§c§l" + user.getUsername());
            Fight f = plugin.getAntiLogoutManager().getFightList().get(e.getEntity().getName());
            String attacker = f.getAttacker();
            String victim = f.getVictim();

            //plugin.getAntiLogoutManager().getFightList().remove(attacker);
            plugin.getAntiLogoutManager().getFightList().remove(victim);

            plugin.getSidebarData().refreshScoreboard(e.getEntity());
            plugin.getSidebarData().refreshScoreboard(killerPlayer);
        }
    }
}
