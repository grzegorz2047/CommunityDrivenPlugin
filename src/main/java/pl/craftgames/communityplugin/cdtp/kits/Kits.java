package pl.craftgames.communityplugin.cdtp.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

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
                    new ItemStack(Material.BOOK, 8)
                    );
        }
    }

    public static void giveDefaultKit(Player p) {
        PlayerInventory inv = p.getInventory();
        if (inv.firstEmpty() != -1) {
            inv.addItem(
                    new ItemStack(Material.IRON_SWORD, 1),
                    new ItemStack(Material.IRON_BOOTS, 1),
                    new ItemStack(Material.IRON_LEGGINGS, 1),
                    new ItemStack(Material.IRON_CHESTPLATE, 1),
                    new ItemStack(Material.IRON_HELMET)
            );
        }
    }

    public static void giveFirstPlayKit(Player p) {
        PlayerInventory inv = p.getInventory();
            if(p.hasPermission("lobby.vip")){
                inv.addItem(
                        new ItemStack(Material.ENDER_CHEST, 2),
                        new ItemStack(Material.COOKED_BEEF, 64)
                );
            }else{
                inv.addItem(
                        new ItemStack(Material.ENDER_CHEST, 1),
                        new ItemStack(Material.COOKED_BEEF, 64)
                );
            }


    }

}
