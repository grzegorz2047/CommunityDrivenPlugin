package pl.craftgames.communityplugin.cdtp.commands.vip.args;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.grzegorz2047.api.command.Arg;
import pl.grzegorz2047.api.util.ColoringUtil;

/**
 * Created by grzegorz2047 on 27.12.2015.
 */
public class VIPArg implements Arg {
    private final CDTP plugin;

    public VIPArg(Plugin plugin) {
        this.plugin = (CDTP) plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        p.sendMessage(ChatColor.GRAY + "Obecne przywileje rangi " + ChatColor.GOLD + "" + ChatColor.BOLD + "VIP:");
        p.sendMessage(ChatColor.GRAY + "- Lepsze przedmioty startowe przy odrodzeniu");

    }
}
