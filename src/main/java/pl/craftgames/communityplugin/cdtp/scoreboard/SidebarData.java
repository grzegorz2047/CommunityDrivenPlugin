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
    private String killLabel = "§7Zabojstwa:§c§l";
    private String deathLabel = "§7Smierci:§c§l";
    private String moneyLabel = "§7Monety:§c§l";

    public SidebarData(CDTP plugin) {
        this.plugin = plugin;
    }

    public void createScoreboard(Player p) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("sidebar", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§6§lSerwer spolecznosci CG");

        User user = plugin.getUserManager().getUsers().get(p.getName());




        addEntry(scoreboard, objective, killLabel, user.getDeaths(), 5);
        addEntry(scoreboard, objective, deathLabel, user.getKills(), 4);
        addEntry(scoreboard, objective, moneyLabel, user.getMoney(), 3);

        Score info = objective.getScore("§7Twoja ranga:");
        info.setScore(2);
        Score rank;
        if (p.hasPermission("lobby.svip")) {
            rank = objective.getScore("§c§lEKIPA");
        } else if (p.hasPermission("lobby.svip")) {
            rank = objective.getScore("§6§lVIP");
        } else {
            rank = objective.getScore("§7§GRACZ");
        }
        rank.setScore(1);


        p.setScoreboard(scoreboard);
    }

    public void refreshScoreboard(Player p) {
        User user = plugin.getUserManager().getUsers().get(p.getName());
        Scoreboard scoreboard = p.getScoreboard();
        updateEntry(scoreboard, deathLabel, user.getDeaths());
        updateEntry(scoreboard, killLabel, user.getKills());
        updateEntry(scoreboard, moneyLabel, user.getMoney());
        p.setScoreboard(scoreboard);
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
}
