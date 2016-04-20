package pl.craftgames.communityplugin.cdtp.commands.shop;

import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.commands.shop.args.SklepArg;
import pl.grzegorz2047.api.command.BaseCommand;


/**
 * Created by grzegorz2047 on 30.12.2015.
 */
public class ShopCommand extends BaseCommand {

    private CDTP plugin;

    public ShopCommand(String basecmd, CDTP plugin) {
        super(basecmd);
        this.plugin = plugin;
        this.commands.put("", new SklepArg(plugin));
    }



}
