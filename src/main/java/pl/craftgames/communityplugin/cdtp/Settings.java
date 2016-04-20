package pl.craftgames.communityplugin.cdtp;

/**
 * Created by grzegorz2047 on 18.04.2016
 */
public class Settings {

    private int teleportSpawnCooldown = 10;
    private int protectedSpawnRadius = 30;
    private int moneyForKill = 3;
    //private int moneyForDeath = -1;

    public int getTeleportSpawnCooldown() {
        return teleportSpawnCooldown;
    }

    public int getProtectedSpawnRadius() {
        return protectedSpawnRadius;
    }

    public int getMoneyForKill() {
        return moneyForKill;
    }
}
