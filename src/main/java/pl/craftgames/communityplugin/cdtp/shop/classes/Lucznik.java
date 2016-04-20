package pl.craftgames.communityplugin.cdtp.shop.classes;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import pl.grzegorz2047.api.playersclasses.PlayerClass;

/**
 * Created by Grzegorz2047. 03.12.2015.
 */
public class Lucznik extends PlayerClass {

    public Lucznik() {
        super();
        this.setMaxLevel(3);
        this.getLevelprice().put(0, 0);
        this.getLevelprice().put(1, 1500);
        this.getLevelprice().put(2, 4000);
        this.getLevelprice().put(3, 8000);
        addItemsToInventory();
    }

    @Override
    protected void addItemsToInventory() {
        this.getLevelInventory(0).
                getInventory().
                addItem(new ItemStack(Material.COBBLESTONE, 40), new ItemStack(Material.STONE_PICKAXE, 1));
        this.getLevelInventory(1).getInventory().addItem(new ItemStack(Material.COBBLESTONE, 40), new ItemStack(Material.STONE_PICKAXE, 1));
        this.getLevelInventory(2).getInventory().addItem(new ItemStack(Material.COBBLESTONE, 40), new ItemStack(Material.STONE_PICKAXE, 1));
        this.getLevelInventory(3).getInventory().addItem(new ItemStack(Material.COBBLESTONE, 40), new ItemStack(Material.STONE_PICKAXE, 1));

        this.getLevelInventory(0).setHelmet(createItem(Material.LEATHER_HELMET, 1, Enchantment.PROTECTION_PROJECTILE, 1));
        this.getLevelInventory(0).setChestplate(createItem(Material.LEATHER_CHESTPLATE, 1, Enchantment.PROTECTION_PROJECTILE, 1));
        this.getLevelInventory(0).setLeggings(createItem(Material.LEATHER_LEGGINGS, 1, Enchantment.PROTECTION_PROJECTILE, 1));
        this.getLevelInventory(0).setBoots(createItem(Material.LEATHER_BOOTS, 1, Enchantment.PROTECTION_PROJECTILE, 1));
        this.getLevelInventory(0).getInventory().addItem(createItem(Material.BOW, 1, Enchantment.ARROW_DAMAGE, 2), createItem(Material.ARROW, 64));
        this.getLevelInventory(0).getInventory().addItem(createItem(Material.GOLDEN_APPLE, 5), createItem(Material.COOKED_BEEF, 10));

        this.getLevelInventory(1).setHelmet(createItem(Material.LEATHER_HELMET, 1, Enchantment.PROTECTION_PROJECTILE, 2));
        this.getLevelInventory(1).setChestplate(createItem(Material.LEATHER_CHESTPLATE, 1, Enchantment.PROTECTION_PROJECTILE, 2));
        this.getLevelInventory(1).setLeggings(createItem(Material.LEATHER_LEGGINGS, 1, Enchantment.PROTECTION_PROJECTILE, 2));
        this.getLevelInventory(1).setBoots(createItem(Material.LEATHER_BOOTS, 1, Enchantment.PROTECTION_PROJECTILE, 2));
        this.getLevelInventory(1).getInventory().addItem(createItem(Material.BOW, 1, Enchantment.ARROW_DAMAGE, 3), createItem(Material.ARROW, 64 + 32));
        this.getLevelInventory(1).getInventory().addItem(createItem(Material.GOLDEN_APPLE, 10), createItem(Material.COOKED_BEEF, 15));

        this.getLevelInventory(2).setHelmet(createItem(Material.LEATHER_HELMET, 1, Enchantment.PROTECTION_PROJECTILE, 3));
        this.getLevelInventory(2).setChestplate(createItem(Material.LEATHER_CHESTPLATE, 1, Enchantment.PROTECTION_PROJECTILE, 3));
        this.getLevelInventory(2).setLeggings(createItem(Material.LEATHER_LEGGINGS, 1, Enchantment.PROTECTION_PROJECTILE, 3));
        this.getLevelInventory(2).setBoots(createItem(Material.LEATHER_BOOTS, 1, Enchantment.PROTECTION_PROJECTILE, 3));
        this.getLevelInventory(2).getInventory().addItem(createItem(Material.BOW, 1, Enchantment.ARROW_DAMAGE, 4), createItem(Material.ARROW, 64 + 64));
        this.getLevelInventory(2).getInventory().addItem(createItem(Material.GOLDEN_APPLE, 15), createItem(Material.COOKED_BEEF, 20));

        this.getLevelInventory(3).setHelmet(createItem(Material.LEATHER_HELMET, 1, Enchantment.PROTECTION_PROJECTILE, 4, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
        this.getLevelInventory(3).setChestplate(createItem(Material.LEATHER_CHESTPLATE, 1, Enchantment.PROTECTION_PROJECTILE, 4, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
        this.getLevelInventory(3).setLeggings(createItem(Material.LEATHER_LEGGINGS, 1, Enchantment.PROTECTION_PROJECTILE, 4, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
        this.getLevelInventory(3).setBoots(createItem(Material.LEATHER_BOOTS, 1, Enchantment.PROTECTION_PROJECTILE, 4, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
        this.getLevelInventory(3).getInventory().addItem(createItem(Material.BOW, 1, Enchantment.ARROW_DAMAGE, 5, Enchantment.ARROW_INFINITE, 1), createItem(Material.ARROW, 10));
        this.getLevelInventory(3).getInventory().addItem(createItem(Material.GOLDEN_APPLE, 20), createItem(Material.COOKED_BEEF, 25));


    }


}
