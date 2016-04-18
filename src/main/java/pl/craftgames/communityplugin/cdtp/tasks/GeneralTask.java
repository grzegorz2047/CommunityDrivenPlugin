package pl.craftgames.communityplugin.cdtp.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pl.craftgames.communityplugin.cdtp.CDTP;

/**
 * Created by grzeg on 23.12.2015.
 */
public class GeneralTask implements Runnable {

    private CDTP plugin;

    public GeneralTask(CDTP plugin){
        this.plugin = plugin;
    }

    int seconds = 0;
    @Override
    public void run() {
        plugin.getTeleportManager().checkRequests();
        //plugin.getManager().getAntiLogoutManager().checkFights();

        //if(seconds % 30 == 0){
        //    seconds = 1;
            //Bukkit.broadcastMessage(ColoringUtil.colorText(MsgManager.getPrefix()+"Serwer w fazie &ctestowej&7! Oczekuj restartow serwera! Mapa bedzie usunieta po testach!!"));
        //}else{
            seconds++;
        //}
        //if(seconds % 5 == 0){
           // for(Player p : Bukkit.getOnlinePlayers()){
            //    plugin.getManager().getTabManager().updateTab(p);
            //}
        //}



    }
}
