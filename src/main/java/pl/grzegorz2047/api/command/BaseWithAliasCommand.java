package pl.grzegorz2047.api.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grzegorz2047. 18.09.2015.
 */
public class BaseWithAliasCommand extends BaseCommand {

    Plugin plugin;
    String[] aliases;

    protected Map<String[], Arg> commands = new HashMap<String[], Arg>();

    public BaseWithAliasCommand(String baseCmd, String[] aliases, Plugin plugin) {
        super(baseCmd);
        this.plugin = plugin;
        this.aliases = aliases;
        //this.command.put(aliases, new KlasaTypeArg(levels)); example
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Arg argument = null;
        if (cmd.getName().equalsIgnoreCase(baseCmd)) {
            String subCommand = "";
            if (args.length != 0) {
                subCommand = args[0].toLowerCase();//lower case to ensure that all command are correct key
            }
            for (String[] key : commands.keySet()) {
                for (String alias : key) {
                    if (alias.equals(subCommand)) {
                        argument = commands.get(key);
                        //System.out.print("Znalazlem klucz "+key.toString()+" arg "+argument.toString());
                        break;
                    }
                }
            }


            if (argument != null) {
                argument.execute(sender, args);
                return true;
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cPodales bledne argumenty!"));
                return true;
            }
        }else{
            Bukkit.getLogger().warning("Plugin has wrong code near getCommand("+baseCmd+").set ...");
        }



        return true;
    }
}