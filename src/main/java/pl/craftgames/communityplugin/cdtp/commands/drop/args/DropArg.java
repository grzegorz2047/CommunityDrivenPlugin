package pl.craftgames.communityplugin.cdtp.commands.drop.args;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.grzegorz2047.api.command.Arg;
import pl.grzegorz2047.api.util.ColoringUtil;

/**
 * Created by grzegorz2047 on 29.12.2015.
 */
public class DropArg implements Arg {
    private final CDTP plugin;

    public DropArg(CDTP plugin) {
        this.plugin = plugin;
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        p.sendMessage(ChatColor.GRAY + "Drop:");
        p.sendMessage(ChatColor.GRAY + "Diament " + ChatColor.DARK_AQUA + "1.5%");
        p.sendMessage(ChatColor.GRAY + "Zloto " + ChatColor.DARK_AQUA + "4%");
        p.sendMessage(ChatColor.GRAY + "Zelazo " + ChatColor.DARK_AQUA + "6%");
        p.sendMessage(ChatColor.GRAY + "Wegiel " + ChatColor.DARK_AQUA + "14%");
        p.sendMessage(ChatColor.GRAY + "Szmaragdy " + ChatColor.DARK_AQUA + "5%");
        p.sendMessage(ChatColor.GRAY + "Lapis: " + ChatColor.DARK_AQUA + "3%");
        p.sendMessage(ChatColor.GRAY + "Jablko: " + ChatColor.DARK_AQUA + "1%");
        p.sendMessage(ChatColor.GRAY + "Obsydian: " + ChatColor.DARK_AQUA + "0.4%");
        p.sendMessage(ChatColor.GRAY + "EXP: " + ChatColor.DARK_AQUA + "4%");
        p.sendMessage(ChatColor.GRAY + "Perly: " + ChatColor.DARK_AQUA + "1%");
        p.sendMessage(ChatColor.GRAY + "Redstone: " + ChatColor.DARK_AQUA + "5%");
        p.sendMessage(ChatColor.GRAY + "Ksiazka: " + ChatColor.DARK_AQUA + "0.45%");
    }

}
