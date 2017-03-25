package pl.craftgames.communityplugin.cdtp.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.user.User;

/**
 * Created by s416045 on 2016-04-19.
 */
public class SidebarData {

    private final CDTP plugin;
    private String killLabel = "§7Zabojstwa:§6§l";
    private String deathLabel = "§7Smierci:§6§l";
    private String moneyLabel = "§7Monety:§6§l";
    private String logoutLabel = "§7§lLogout§7§l:";

    public SidebarData(CDTP plugin) {
        this.plugin = plugin;
    }

    public void createScoreboard(Player p) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("sidebar", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§6» §6§lSandbox §6«");

        Objective healthObj = scoreboard.registerNewObjective("showhealth", "health");
        healthObj.setDisplaySlot(DisplaySlot.BELOW_NAME);
        healthObj.setDisplayName(" §c❤");
        p.setHealth(p.getHealth());


        User user = plugin.getUserManager().getUsersstats().get(p.getName());


        addEntry(scoreboard, objective, logoutLabel, "§a§l✔", 6);
        addEntry(scoreboard, objective, "", "", 5);
        addEntry(scoreboard, objective, killLabel, user.getKills(), 4);
        addEntry(scoreboard, objective, deathLabel, user.getDeaths(), 3);
        addEntry(scoreboard, objective, moneyLabel, user.getMoney(), 2);



        p.setScoreboard(scoreboard);
    }

    public void refreshScoreboard(Player p) {
        User user = plugin.getUserManager().getUsersstats().get(p.getName());
        Scoreboard scoreboard = p.getScoreboard();
        String canLogout = user.canLogout() ? "§a§l✔" : "§c✖";
        updateEntry(scoreboard, logoutLabel, canLogout);
        updateEntry(scoreboard, deathLabel, user.getDeaths());
        updateEntry(scoreboard, killLabel, user.getKills());
        updateEntry(scoreboard, moneyLabel, user.getMoney());
        p.setScoreboard(scoreboard);
    }

    private void addEntry(Scoreboard scoreboard, Objective objective, String name, String value, int position) {
        Team t = scoreboard.registerNewTeam(name);
        t.addEntry(name);
        t.setSuffix(" " + value);
        Score score = objective.getScore(name);
        score.setScore(position);
    }

    private void addEntry(Scoreboard scoreboard, Objective objective, String name, int value, int position) {
        Team t = scoreboard.registerNewTeam(name);
        t.addEntry(name);
        t.setSuffix(" " + value);
        Score score = objective.getScore(name);
        score.setScore(position);
    }

    private void updateEntry(Scoreboard scoreboard, String name, int value) {
        Team t = scoreboard.getTeam(name);
        t.setSuffix(" " + value);
    }
    private void updateEntry(Scoreboard scoreboard, String name, String value) {
        Team t = scoreboard.getTeam(name);
        t.setSuffix(" " + value);
    }
}
