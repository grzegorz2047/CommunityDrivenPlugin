package pl.craftgames.communityplugin.cdtp.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.projectiles.ProjectileSource;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.antilogout.Fight;
import pl.craftgames.communityplugin.cdtp.user.User;
import pl.grzegorz2047.api.util.ColoringUtil;

import java.util.ArrayList;

/**
 * Created by grzegorz2047 on 27.12.2015.
 */
public class EntityDamageEntityListener implements Listener {

    private final CDTP plugin;

    public EntityDamageEntityListener(CDTP plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    void onExplode(EntityExplodeEvent event) {
        Location loc = event.getLocation();
        int protspawnrad = plugin.getSettingsManager().getProtectedSpawnRadius();
        if (loc.distance(loc.getWorld().getSpawnLocation()) < protspawnrad) {
            event.setCancelled(true);
            return;
        }
    }

    @EventHandler
    void onDamage(EntityDamageEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player p = (Player) event.getEntity();
        int protspawnrad = plugin.getSettingsManager().getProtectedSpawnRadius();
        if (p.getLocation().distance(p.getWorld().getSpawnLocation()) < protspawnrad) {
            if (event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {

            }
            event.setCancelled(true);
            return;
        }
    }


    @EventHandler
    void onEntityTarget(EntitySpawnEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player p = (Player) event.getEntity();
        int protspawnrad = plugin.getSettingsManager().getProtectedSpawnRadius();
        if (p.getLocation().distance(p.getWorld().getSpawnLocation()) <= protspawnrad) {
            event.setCancelled(true);
            return;
        }
    }


    @EventHandler
    void onEntityTarget(EntityTargetLivingEntityEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player p = (Player) event.getEntity();
        int protspawnrad = plugin.getSettingsManager().getProtectedSpawnRadius();
        if (p.getLocation().distance(p.getWorld().getSpawnLocation()) <= protspawnrad) {
            event.setCancelled(true);
            event.setTarget(null);
            return;
        }
    }

    @EventHandler
    void onEntityDamageEntity(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (event.getDamager() instanceof Player) {
            if (event.getEntity() instanceof Player) {
                Player attacked = (Player) event.getEntity();
                Player attacker = (Player) event.getDamager();

                int protspawnrad = plugin.getSettingsManager().getProtectedSpawnRadius();
                if (event.getDamager().getLocation().distance(attacker.getWorld().getSpawnLocation()) < protspawnrad) {
                    attacker.sendMessage(ChatColor.RED + "Na tym terenie nie mozna sie bic!");
                    event.setCancelled(true);
                    return;
                }
                checkFight(attacker, attacked);
                checkIfTheSameTeam(event, attacker, attacked);
            }
        } else if (event.getDamager() instanceof Arrow) {
            if (event.getEntity() instanceof Player) {
                Player attacked = (Player) event.getEntity();
                ProjectileSource attackerEntity = ((Arrow) event.getDamager()).getShooter();

                if (attackerEntity instanceof Player) {
                    Player attacker = (Player) attackerEntity;
                    checkFight(attacker, attacked);
                    checkIfTheSameTeam(event, attacker, attacked);

                }
            }
        } else if (event.getDamager() instanceof Snowball) {
            if (event.getEntity() instanceof Player) {
                Player attacked = (Player) event.getEntity();
                ProjectileSource attackerEntity = ((Snowball) event.getDamager()).getShooter();

                if (attackerEntity instanceof Player) {
                    Player attacker = (Player) attackerEntity;
                    checkFight(attacker, attacked);
                    checkIfTheSameTeam(event, attacker, attacked);

                }
            }
        } else if (event.getDamager() instanceof Egg) {
            if (event.getEntity() instanceof Player) {
                Player attacked = (Player) event.getEntity();
                ProjectileSource attackerEntity = ((Egg) event.getDamager()).getShooter();
                if (attackerEntity instanceof Player) {
                    Player attacker = (Player) attackerEntity;
                    checkFight(attacker, attacked);
                    checkIfTheSameTeam(event, attacker, attacked);
                }
            }
        }
    }

    public void checkFight(Player attacker, Player attacked) {

        Fight vf = plugin.getAntiLogoutManager().getFightList().get(attacked.getName());
        Fight af = plugin.getAntiLogoutManager().getFightList().get(attacker.getName());
        if (vf == null) {
            vf = new Fight(attacker.getName(), attacked.getName(), System.currentTimeMillis());
            plugin.getAntiLogoutManager().getFightList().put(attacked.getName(), vf);

            User obj = plugin.getUserManager().getUsersstats().get(attacked.getName());
            obj.setCanLogout(false);
            plugin.getSidebarData().refreshScoreboard(attacked);

            attacked.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Jestes podczas WALKI!");
            attacked.sendMessage((ColoringUtil.colorText("§c§lMusisz poczekać conajmniej {TIME} sekund aby moc sie wylogowac")).replace("{TIME}", String.valueOf(vf.getCooldown())));
        } else {
            vf.setAttacker(attacker.getName());
            vf.setVictim(attacked.getName());
            vf.setLastHitTime(System.currentTimeMillis());
        }
        if (af == null) {
            af = new Fight(attacker.getName(), attacked.getName(), System.currentTimeMillis());
            plugin.getAntiLogoutManager().getFightList().put(attacker.getName(), af);

            User obj = plugin.getUserManager().getUsersstats().get(attacker.getName());
            obj.setCanLogout(false);
            plugin.getSidebarData().refreshScoreboard(attacker);

            attacker.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Jestes podczas WALKI!");
            attacker.sendMessage((ColoringUtil.colorText("§c§lMusisz poczekać conajmniej {TIME} sekund aby moc sie wylogowac")).replace("{TIME}", String.valueOf(af.getCooldown())));
        } else {
            af.setAttacker(attacker.getName());
            af.setVictim(attacked.getName());
            af.setLastHitTime(System.currentTimeMillis());
        }
    }

    private void checkIfTheSameTeam(EntityDamageByEntityEvent e, Player attacker, Player attacked) {
        for (ArrayList<String> teams : plugin.getTeams().values()) {
            if (teams.contains(attacker.getName()) && teams.contains(attacked.getName())) {
                e.setCancelled(true);
            }
        }
    }
}