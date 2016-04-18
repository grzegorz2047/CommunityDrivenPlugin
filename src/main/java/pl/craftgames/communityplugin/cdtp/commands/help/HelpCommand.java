package pl.craftgames.communityplugin.cdtp.commands.help;

import org.bukkit.plugin.Plugin;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.commands.help.arg.GenHelpArg;
import pl.grzegorz2047.api.command.BaseWithAliasCommand;

/**
 * Created by grzegorz2047 on 30.12.2015.
 */
public class HelpCommand extends BaseWithAliasCommand {

    private CDTP plugin;

    public HelpCommand(String baseCmd, String[] aliases, Plugin plugin) {
        super(baseCmd, aliases, plugin);
        this.commands.put(new String[]{"", "?", "pomoc", "h", "pomocy"}, new GenHelpArg(plugin));
    }
}
