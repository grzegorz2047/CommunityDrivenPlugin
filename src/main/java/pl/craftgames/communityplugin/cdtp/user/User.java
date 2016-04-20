package pl.craftgames.communityplugin.cdtp.user;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by grzegorz2047 on 20.04.2016
 */
public class User {

    private String username;
    private int kills;
    private int deaths;
    private int money;
    private boolean logout = true;


    public User(String username, int kills, int deaths, int money) {
        this.username = username;
        this.kills = kills;
        this.deaths = deaths;
        this.money = money;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(username);
    }

    public boolean canLogout() {
        return this.logout;
    }

    public void setCanLogout(boolean canLogout) {
        this.logout = canLogout;
    }
}
