package pl.craftgames.communityplugin.cdtp.commands.home;

import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.commands.home.args.HomeArg;
import pl.grzegorz2047.api.command.BaseCommand;


/**
 * Created by grzegorz2047 on 30.12.2015.
 */
public class HomeCommand extends BaseCommand {

    private CDTP plugin;

    public HomeCommand(String basecmd, CDTP plugin) {
        super(basecmd);
        this.plugin = plugin;
        this.commands.put("", new HomeArg(plugin));
    }



}
