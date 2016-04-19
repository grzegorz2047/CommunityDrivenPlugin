package pl.craftgames.communityplugin.cdtp.commands.help.arg;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.grzegorz2047.api.command.Arg;
import pl.grzegorz2047.api.util.ColoringUtil;


/**
 * Created by grzegorz2047 on 30.12.2015.
 */
public class GenHelpArg implements Arg {

    CDTP plugin;

    public GenHelpArg(Plugin plugin) {
        this.plugin = (CDTP) plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        p.sendMessage(ColoringUtil.colorText("&7Dostepne komendy: "));
        p.sendMessage(ColoringUtil.colorText("&a/drop - &7Pokazuje drop na serwerze "));
        p.sendMessage(ColoringUtil.colorText("&a/vip &7Pokazuje mozliwosci dla rangi vip "));
        //p.sendMessage(ColoringUtil.colorText("&a/cx &7Zamienia stacki cobblestone na losowy przedmiot"));
    }
}