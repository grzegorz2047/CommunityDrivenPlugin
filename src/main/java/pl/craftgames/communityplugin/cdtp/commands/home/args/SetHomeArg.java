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
public class SetHomeArg implements Arg {
    private final CDTP plugin;

    public SetHomeArg(CDTP plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        Location home = plugin.getSQLManager().getHome(p);
        if (home == null) {
            plugin.getSQLManager().addHome(p);
            p.sendMessage(ColoringUtil.colorText("&7Utworzyles dom!"));
        }else{
            p.sendMessage(ColoringUtil.colorText("&cUsun najpierw stary dom!"));
        }


        //}
    }
}
