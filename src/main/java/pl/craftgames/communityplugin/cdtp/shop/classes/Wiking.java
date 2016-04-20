package pl.craftgames.communityplugin.cdtp.shop.classes;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.grzegorz2047.api.playersclasses.PlayerClass;

/**
 * Created by Grzegorz2047. 03.12.2015.
 */
public class Wiking extends PlayerClass {

    public Wiking() {
        super();

        this.setMaxLevel(3);
        this.getLevelprice().put(0, 0);
        this.getLevelprice().put(1, 2000);
        this.getLevelprice().put(2, 6000);
        this.getLevelprice().put(3, 12000);

        this.getSpecialPerm().put(0, true);
        this.getSpecialPerm().put(1, true);
        this.getSpecialPerm().put(2, true);
        this.getSpecialPerm().put(3, true);

        this.getPotionEffects().get(3).add(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
        addItemsToInventory();
    }

    @Override
    protected void addItemsToInventory() {
        this.getLevelInventory(0).getInventory().addItem(new ItemStack(Material.COBBLESTONE, 40), new ItemStack(Material.STONE_PICKAXE, 1));
        this.getLevelInventory(1).getInventory().addItem(new ItemStack(Material.COBBLESTONE, 40), new ItemStack(Material.STONE_PICKAXE, 1));
        this.getLevelInventory(2).getInventory().addItem(new ItemStack(Material.COBBLESTONE, 40), new ItemStack(Material.STONE_PICKAXE, 1));
        this.getLevelInventory(3).getInventory().addItem(new ItemStack(Material.COBBLESTONE, 40), new ItemStack(Material.STONE_PICKAXE, 1));

        this.getLevelInventory(0).setHelmet(createItem(Material.CHAINMAIL_HELMET, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 1));
        this.getLevelInventory(0).setChestplate(createItem(Material.CHAINMAIL_CHESTPLATE, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 1));
        this.getLevelInventory(0).setLeggings(createItem(Material.CHAINMAIL_LEGGINGS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 1));
        this.getLevelInventory(0).setBoots(createItem(Material.CHAINMAIL_BOOTS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 1));
        this.getLevelInventory(0).getInventory().addItem(createItem(Material.IRON_SWORD, 1, Enchantment.DAMAGE_ALL, 2));
        this.getLevelInventory(0).getInventory().addItem(createItem(Material.GOLDEN_APPLE, 15), createItem(Material.COOKED_BEEF, 20));

        this.getLevelInventory(1).setHelmet(createItem(Material.CHAINMAIL_HELMET, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
        this.getLevelInventory(1).setChestplate(createItem(Material.CHAINMAIL_CHESTPLATE, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
        this.getLevelInventory(1).setLeggings(createItem(Material.CHAINMAIL_LEGGINGS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
        this.getLevelInventory(1).setBoots(createItem(Material.IRON_BOOTS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
        this.getLevelInventory(1).getInventory().addItem(createItem(Material.IRON_SWORD, 1, Enchantment.DAMAGE_ALL, 3));
        this.getLevelInventory(1).getInventory().addItem(createItem(Material.GOLDEN_APPLE, 20), createItem(Material.COOKED_BEEF, 20));

        this.getLevelInventory(2).setHelmet(createItem(Material.CHAINMAIL_HELMET, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 3, Enchantment.PROTECTION_FIRE, 2));
        this.getLevelInventory(2).setChestplate(createItem(Material.CHAINMAIL_CHESTPLATE, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 3, Enchantment.PROTECTION_FIRE, 2));
        this.getLevelInventory(2).setLeggings(createItem(Material.CHAINMAIL_LEGGINGS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 3, Enchantment.PROTECTION_FIRE, 2));
        this.getLevelInventory(2).setBoots(createItem(Material.CHAINMAIL_BOOTS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 3, Enchantment.PROTECTION_FIRE, 2));
        this.getLevelInventory(2).getInventory().addItem(createItem(Material.IRON_SWORD, 1, Enchantment.DAMAGE_ALL, 4));
        this.getLevelInventory(2).getInventory().addItem(createItem(Material.GOLDEN_APPLE, 25), createItem(Material.COOKED_BEEF, 25));

        this.getLevelInventory(3).setHelmet(createItem(Material.CHAINMAIL_HELMET, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 3, Enchantment.PROTECTION_FIRE, 2, Enchantment.PROTECTION_PROJECTILE, 2));
        this.getLevelInventory(3).setChestplate(createItem(Material.CHAINMAIL_CHESTPLATE, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 3, Enchantment.PROTECTION_FIRE, 2, Enchantment.PROTECTION_PROJECTILE, 2));
        this.getLevelInventory(3).setLeggings(createItem(Material.CHAINMAIL_LEGGINGS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 3, Enchantment.PROTECTION_FIRE, 2, Enchantment.PROTECTION_PROJECTILE, 2));
        this.getLevelInventory(3).setBoots(createItem(Material.CHAINMAIL_BOOTS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 3, Enchantment.PROTECTION_FIRE, 2, Enchantment.PROTECTION_PROJECTILE, 2));
        this.getLevelInventory(3).getInventory().addItem(createItem(Material.IRON_SWORD, 1, Enchantment.DAMAGE_ALL, 4, Enchantment.FIRE_ASPECT, 1));
        this.getLevelInventory(3).getInventory().addItem(createItem(Material.GOLDEN_APPLE, 30), createItem(Material.COOKED_BEEF, 30));


    }

}
