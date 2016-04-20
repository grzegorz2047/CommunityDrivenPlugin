package pl.craftgames.communityplugin.cdtp.commands.shop.args;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.shop.Shop;
import pl.craftgames.communityplugin.cdtp.user.User;
import pl.grzegorz2047.api.command.Arg;

/**
 * Created by grzegorz2047 on 30.12.2015.
 */
public class SklepArg implements Arg {
    private final CDTP plugin;

    public SklepArg(CDTP plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        User user = plugin.getUserManager().getUsers().get(p.getName());
        plugin.getShop().showShop(user, Shop.SHOPVIEW.MAIN_MENU);
    }
}
