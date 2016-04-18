package pl.craftgames.communityplugin.cdtp.commands.spawn;

import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.commands.spawn.args.SpawnArg;
import pl.grzegorz2047.api.command.BaseCommand;


/**
 * Created by grzegorz2047 on 30.12.2015.
 */
public class SpawnCommand extends BaseCommand {

    private CDTP plugin;

    public SpawnCommand(String basecmd, CDTP plugin) {
        super(basecmd);
        this.plugin = plugin;
        this.commands.put("", new SpawnArg(plugin));
    }



}
