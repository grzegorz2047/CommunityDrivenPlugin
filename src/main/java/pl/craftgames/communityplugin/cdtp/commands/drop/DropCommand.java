package pl.craftgames.communityplugin.cdtp.commands.drop;

import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.commands.drop.args.DropArg;
import pl.grzegorz2047.api.command.BaseCommand;

/**
 * Created by grzegorz2047 on 29.12.2015.
 */
public class DropCommand extends BaseCommand {

    private final CDTP plugin;


    public DropCommand(String basecmd, CDTP plugin) {
        super(basecmd);
        this.plugin = plugin;
        this.commands.put("", new DropArg(plugin));
    }
}
