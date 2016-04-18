package pl.craftgames.communityplugin.cdtp.commands.vip;

import org.bukkit.plugin.Plugin;
import pl.craftgames.communityplugin.cdtp.commands.vip.args.VIPArg;
import pl.grzegorz2047.api.command.BaseWithAliasCommand;

/**
 * Created by grzegorz2047 on 27.12.2015.
 */
public class VIPCommand extends BaseWithAliasCommand {
    public VIPCommand(String baseCmd, String[] aliases, Plugin plugin) {
        super(baseCmd, aliases, plugin);
        this.commands.put(new String[]{""}, new VIPArg(plugin));
    }
}
