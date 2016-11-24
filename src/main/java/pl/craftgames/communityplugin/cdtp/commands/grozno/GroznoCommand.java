package pl.craftgames.communityplugin.cdtp.commands.grozno;

import org.bukkit.command.CommandExecutor;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.commands.spawn.args.SpawnArg;
import pl.grzegorz2047.api.command.BaseCommand;

/**
 * Created by grzegorz2047 on 24.11.2016.
 */
public class GroznoCommand extends BaseCommand {
    private CDTP plugin;

    public GroznoCommand(String basecmd, CDTP plugin) {
        super(basecmd);
        this.plugin = plugin;
        this.commands.put("", new GroznoArg(plugin));
    }
}
