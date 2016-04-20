package pl.craftgames.communityplugin.cdtp.commands.top;

import org.bukkit.plugin.Plugin;
import pl.craftgames.communityplugin.cdtp.commands.top.args.TopArg;
import pl.grzegorz2047.api.command.BaseCommand;
import pl.grzegorz2047.api.command.BaseWithAliasCommand;

/**
 * Created by grzegorz2047 on 27.12.2015.
 */
public class TopCommand extends BaseCommand {
    public TopCommand(String baseCmd, Plugin plugin) {
        super(baseCmd);
        this.commands.put("", new TopArg(plugin));
    }
}
