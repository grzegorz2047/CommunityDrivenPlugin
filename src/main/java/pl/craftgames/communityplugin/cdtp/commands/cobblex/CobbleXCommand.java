package pl.craftgames.communityplugin.cdtp.commands.cobblex;

import org.bukkit.plugin.Plugin;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.grzegorz2047.api.command.BaseWithAliasCommand;

/**
 * Created by grzegorz2047 on 01.01.2016.
 */
public class CobbleXCommand extends BaseWithAliasCommand {

    CDTP plugin;

    public CobbleXCommand(String baseCmd, String[] aliases, Plugin plugin) {
        super(baseCmd, aliases, plugin);
        this.plugin = (CDTP) plugin;
        this.commands.put(new String[]{""}, new CobblexArg(this.plugin));
    }
}
