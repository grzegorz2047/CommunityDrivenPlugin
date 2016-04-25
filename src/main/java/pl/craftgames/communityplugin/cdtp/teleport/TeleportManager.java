package pl.craftgames.communityplugin.cdtp.teleport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pl.craftgames.communityplugin.cdtp.CDTP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grzeg on 23.12.2015.
 */
public class TeleportManager {

    private final CDTP plugin;
    private List<TeleportRequest> requests = new ArrayList<TeleportRequest>();

    public TeleportManager(CDTP plugin) {
        this.plugin = plugin;
    }


    public void checkRequests(){
        for(int i = 0; i < requests.size(); i++){
            TeleportRequest r = requests.get(i);
            if(r.getTeleportTime()<= System.currentTimeMillis()){

                Player requester = Bukkit.getPlayer(r.getRequester());
                if(requester != null){
                    //System.out.print("Odleglosc: "+requester.getLocation().distance(r.getSource()));
                    if(requester.getLocation().distance(r.getSource())<1){
                        requester.teleport(r.getDestination());
                        requester.sendMessage(ChatColor.GRAY+"Przeteleportowano na spawn!");
                    }else{
                        requester.sendMessage(ChatColor.GRAY+"Poruszyles sie!");
                    }

                }
                requests.remove(r);
            }
        }
    }

    public List<TeleportRequest> getRequests() {
        return requests;
    }
}
