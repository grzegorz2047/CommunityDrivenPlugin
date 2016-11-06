package pl.craftgames.communityplugin.cdtp.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import pl.grzegorz2047.databaseapi.SQLUser;

/**
 * Created by grzegorz2047 on 17.04.2016
 */
public class Kits {


    public static void giveVipKit(Player p) {
        PlayerInventory inv = p.getInventory();
        if (inv.firstEmpty() != -1) {
            inv.addItem(
                    new ItemStack(Material.IRON_SWORD, 1),
                    new ItemStack(Material.IRON_BOOTS, 1),
                    new ItemStack(Material.IRON_LEGGINGS, 1),
                    new ItemStack(Material.IRON_CHESTPLATE, 1),
                    new ItemStack(Material.IRON_HELMET, 1),
                    new ItemStack(Material.DIAMOND_PICKAXE, 1),
                    new ItemStack(Material.DIAMOND_SWORD, 1),
                    new ItemStack(Material.DIAMOND_AXE, 1),
                    new ItemStack(Material.DIAMOND_SPADE, 1),
                    new ItemStack(Material.COOKED_BEEF, 64),
                    new ItemStack(Material.BOOK, 8),
                    new ItemStack(Material.COOKED_BEEF, 64)
            );
        }
    }

    public static void giveDefaultKit(Player p) {
        PlayerInventory inv = p.getInventory();
        if (inv.firstEmpty() != -1) {
            inv.addItem(
                    new ItemStack(Material.IRON_SWORD, 1),
                    new ItemStack(Material.COOKED_BEEF, 64)
            );
            p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
            p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
            p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
            p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        }
    }

    public static void giveFirstPlayKit(Player p, SQLUser sqlUser) {
        PlayerInventory inv = p.getInventory();
        if ( !sqlUser.getRank().equals("Gracz")){
            Kits.giveVipKit(p);
            inv.addItem(
                    new ItemStack(Material.ENDER_CHEST, 2)
            );
        } else {
            Kits.giveDefaultKit(p);
            inv.addItem(
                    new ItemStack(Material.ENDER_CHEST, 1)

            );
        }


    }

}
