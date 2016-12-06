package pl.craftgames.communityplugin.cdtp.commands.grozno;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.grzegorz2047.api.command.Arg;

import java.util.ArrayList;

/**
 * Created by grzegorz2047 on 24.11.2016.
 */
public class GroznoArg implements Arg {
    CDTP plugin;

    public GroznoArg(CDTP plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.getName().equals("xVeenix") || sender.getName().equalsIgnoreCase("xBYCZEKx") || sender.getName().equals("grzegorz2047")) {
            Player p = (Player) sender;
            if(args.length == 0){
                p.sendMessage("/grozno kit nick - daje kit graczowi");
                p.sendMessage("/grozno addteam nazwateamu - dodaje druzyn");
                p.sendMessage("/grozno addtoteam nazwateamu nick - dodaje do druzyny");
                p.sendMessage("/grozno clear - czysci wszystko");
                p.sendMessage("/grozno whitelist on/off - wl on/off");
            }
            if (args.length == 1) {
                if (args[0].equals("clear")) {
                    plugin.getTeams().clear();
                    p.sendMessage("Usunieto druzyny");
                }
            } else if (args.length == 2) {
                if (args[0].equals("whitelist")) {
                    if(args[1].equals("on")){
                        Bukkit.setWhitelist(true);
                        p.sendMessage("WL TRU");
                    }else{
                        Bukkit.setWhitelist(false);
                        p.sendMessage("WL FALSE");
                    }
                }
                if (args[0].equals("kit")) {
                    Player kiter = Bukkit.getPlayer(args[1]);

                    if (kiter != null) {
                        kiter.getInventory().clear();
                        kiter.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1));
                        kiter.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 2));

                        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
                        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
                        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
                        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
                        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
                        ItemStack spade = new ItemStack(Material.DIAMOND_SPADE, 1);

                        spade.addUnsafeEnchantment(Enchantment.DIG_SPEED,5);
                        helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);

                        kiter.getInventory().setHelmet(helmet);
                        kiter.getInventory().setChestplate(chestplate);
                        kiter.getInventory().setLeggings(leggings);
                        kiter.getInventory().setBoots(boots);

                        kiter.getInventory().addItem(sword);
                        kiter.getInventory().addItem(spade);

                        p.sendMessage("Gosciu " + args[1] + " dostal kit!");
                    } else {
                        p.sendMessage("Nie ma takiego goscia!");
                    }


                }
                if (args[0].equals("addteam")) {
                    plugin.getTeams().put(args[1], new ArrayList<String>());
                    p.sendMessage("Dodano druzyne " + args[1]);
                }
            } else if (args.length == 3)
                if (args[0].equals("addtoteam")) {
                    plugin.getTeams().get(args[1]).add(args[2]);
                    p.sendMessage("Dodano " + args[2] + " do druzyny " + args[1]);
                }

        }

    }
}

