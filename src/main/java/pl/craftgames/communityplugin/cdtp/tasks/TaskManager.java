package pl.craftgames.communityplugin.cdtp.tasks;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;
import pl.craftgames.communityplugin.cdtp.CDTP;


/**
 * Created by grzeg on 26.12.2015.
 */
public class TaskManager {
    private final CDTP plugin;
    private BukkitTask generalBukkitTask;

    public TaskManager(CDTP plugin){
        this.plugin = plugin;
        generalBukkitTask = Bukkit.getScheduler().runTaskTimer(plugin, new GeneralTask(plugin), 0, 20);
    }


    public BukkitTask getGeneralBukkitTask(){
        return this.generalBukkitTask;
    }

    public void dispose() {
        this.generalBukkitTask.cancel();
    }
}
