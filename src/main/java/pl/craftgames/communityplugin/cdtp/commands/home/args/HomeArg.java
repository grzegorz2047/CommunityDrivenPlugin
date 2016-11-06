package pl.craftgames.communityplugin.cdtp.commands.home.args;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.teleport.TeleportRequest;
import pl.grzegorz2047.api.command.Arg;
import pl.grzegorz2047.api.util.ColoringUtil;

/**
 * Created by grzegorz2047 on 30.12.2015.
 */
public class HomeArg implements Arg {
    private final CDTP plugin;

    public HomeArg(CDTP plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        int time = 0;
        if (!sender.hasPermission("lobby.ekipa")) { //Bukkit version will support this permissions probably xd
            time = plugin.getSettings().getTeleportSpawnCooldown();
        }
        Location home = plugin.getSQLManager().getHome(p);
        if(home == null){
            p.sendMessage(ColoringUtil.colorText("&7Za &c&lNie posiadasz domu!"));
            return;
        }
        TeleportRequest request = new TeleportRequest
                (p.getName(),
                        p.getLocation(),
                        home,
                        System.currentTimeMillis(),
                        time);
        plugin.getTeleportManager().getRequests().add(request);
        p.sendMessage(ColoringUtil.colorText("&7Za &c&l" + time + "&7 zostaniesz przeteleportowany! Nie ruszaj sie!"));

        //}
    }
}
