package pl.craftgames.communityplugin.cdtp.commands.top.args;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.grzegorz2047.api.command.Arg;

/**
 * Created by grzegorz2047 on 27.12.2015.
 */
public class TopArg implements Arg {
    private final CDTP plugin;

    public TopArg(Plugin plugin) {
        this.plugin = (CDTP) plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        plugin.getSQLManager().printTop10Players(p);

    }
}
