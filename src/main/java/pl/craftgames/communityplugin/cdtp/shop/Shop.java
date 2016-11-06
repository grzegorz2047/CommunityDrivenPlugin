package pl.craftgames.communityplugin.cdtp.shop;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.database.PlayerColumns;
import pl.craftgames.communityplugin.cdtp.user.User;
import pl.grzegorz2047.api.itemmenu.event.ChooseItemEvent;
import pl.grzegorz2047.api.util.CreateItemUtil;
import pl.grzegorz2047.databaseapi.SQLUser;

/**
 * Created by Grzegorz2047. 03.12.2015.
 */
public class Shop implements Listener {

    private final CDTP plugin;

    private Inventory tempMenu = Bukkit.createInventory(null, 54, "Przedmioty");
    private Inventory main = Bukkit.createInventory(null, 9, "Sklep");

    public enum SHOPVIEW {MAIN_MENU, ITEMS, CLASSES}

    public Shop(CDTP plugin) {
        //Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
        main.setItem(4, CreateItemUtil.createItem(Material.CHAINMAIL_CHESTPLATE, "Przedmioty jednorazowe"));
        for (int j = 0; j < main.getSize(); j++) {
            if (main.getItem(j) == null) {
                main.setItem(j, new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY.getData()));
            }
        }
        generateTempItemsMenu();
        for (int j = 0; j < tempMenu.getSize(); j++) {
            if (tempMenu.getItem(j) == null) {
                tempMenu.setItem(j, new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY.getData()));
            }
        }
    }


    public void showShop(User user, SHOPVIEW activity) {
        if (activity.equals(SHOPVIEW.MAIN_MENU)) {
            user.getPlayer().openInventory(this.main);
        }
        if (activity.equals(SHOPVIEW.ITEMS)) {
            user.getPlayer().openInventory(this.tempMenu);
        }

    }

    @EventHandler
    void clickEkwipunek(InventoryClickEvent e) {

        ChooseItemEvent event = new ChooseItemEvent(e.getInventory().getTitle(), e.getInventory().getSize(), e.getInventory(), e.getCurrentItem(), (Player) e.getWhoClicked());
        Bukkit.getServer().getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    void onClick(ChooseItemEvent e) {
        String title = e.getInventory().getTitle();
        User user = plugin.getUserManager().getUsersstats().get(e.getPlayer().getName());
        //System.out.println("1");
        if (title != null) {
            if (e.getClicked() == null) {
                return;
            }
           //System.out.println("2");

            if (e.getClicked().getType() == null) {
                return;
            }
           // System.out.println("3");

            if (title.equals("Sklep")) {
                //System.out.println("4");
                e.setCancelled(true);
                if (e.getClicked().getType().equals(Material.CHAINMAIL_CHESTPLATE)) {
                    this.showShop(user, SHOPVIEW.ITEMS);
                }
                if (e.getClicked().getType().equals(Material.DIAMOND_SWORD)) {
                    this.showShop(user, SHOPVIEW.CLASSES);
                }
            } else if (title.contains("Przedmioty")) {
                e.setCancelled(true);
                ItemStack is = e.getClicked();
                Player p = user.getPlayer();
                if (p.getInventory().firstEmpty() == -1) {
                    p.closeInventory();
                    p.sendMessage("Zwolnij miejsce w ekwipunku!");
                }
                if (is.getItemMeta() != null) {
                    String name = is.getItemMeta().getDisplayName();
                    if (name != null && name.equals("Powrot")) {
                        p.openInventory(main);
                    }
                }
                if (e.getClicked().getType().equals(Material.ENCHANTMENT_TABLE)) {
                    checkAndBuyItem(Material.ENCHANTMENT_TABLE, (byte) 0, user, 70);
                }
                if (e.getClicked().getType().equals(Material.BOW)) {
                    checkAndBuyItem(Material.BOW, (byte) 0, user, 120);

                }
                if (e.getClicked().getType().equals(Material.ANVIL)) {
                    checkAndBuyItem(Material.ANVIL, (byte) 0, user, 100);


                }
                if (e.getClicked().getType().equals(Material.ARROW)) {

                    checkAndBuyItem(Material.ARROW, (byte) 0, user, 70);

                }
                if (e.getClicked().getType().equals(Material.TNT)) {
                    checkAndBuyItem(Material.TNT, (byte) 0, user, 60);


                }
                if (e.getClicked().getType().equals(Material.FLINT_AND_STEEL)) {
                    checkAndBuyItem(Material.FLINT_AND_STEEL, (byte) 0, user, 120);
                }
                if (e.getClicked().getType().equals(Material.IRON_PICKAXE)) {
                    checkAndBuyItem(Material.IRON_PICKAXE, (byte) 0, user, 150);


                }
                if (e.getClicked().getType().equals(Material.IRON_AXE)) {

                    checkAndBuyItem(Material.IRON_AXE, (byte) 0, user, 130);

                }
                if (e.getClicked().getType().equals(Material.IRON_SPADE)) {
                    checkAndBuyItem(Material.IRON_SPADE, (byte) 0, user, 130);


                }
                if (e.getClicked().getType().equals(Material.WATER_BUCKET)) {
                    checkAndBuyItem(Material.WATER_BUCKET, (byte) 0, user, 60);


                }
                if (e.getClicked().getType().equals(Material.LAVA_BUCKET)) {
                    checkAndBuyItem(Material.LAVA_BUCKET, (byte) 0, user, 60);
                }
                if (e.getClicked().getType().equals(Material.ENDER_CHEST)) {
                    checkAndBuyItem(Material.ENDER_CHEST, (byte) 0, user, 200);
                }
                //System.out.print("Durability: "+e.getClicked().getDurability());
                if (e.getClicked().getType().equals(Material.GOLDEN_APPLE)) {
                    if (e.getClicked().getDurability() == (byte) 0) {
                        checkAndBuyItem(Material.GOLDEN_APPLE, (byte) 0, user, 100);
                    } else if (e.getClicked().getDurability() == (byte) 1) {
                        SQLUser sqlUser = plugin.getPlayerManager().getPlayer(p);
                        if (sqlUser.getRank().equals("Gracz")) {
                            p.sendMessage(ChatColor.RED + "Przedmiot jedynie dla rangi VIP!");
                            return;
                        }
                        checkAndBuyItem(Material.GOLDEN_APPLE, (byte) 1, user, 150);
                    }


                }
            }
        }
    }

    public boolean checkAndBuyItem(Material mat, byte dur, User user, int money) {

        Inventory eq = user.getPlayer().getInventory();
        Player p = user.getPlayer();
        if (eq.firstEmpty() == -1) {
            p.sendMessage(ChatColor.RED + "Masz za malo miejsca w ekwipunku!");
            return false;
        }
        if (user.getMoney() >= money) {
            user.setMoney(user.getMoney() - money);
            plugin.getSQLManager().incrementColumn(user.getUsername(), PlayerColumns.MONEY, -money);
            for (ItemStack it : tempMenu) {
                if (it.getType().equals(mat)) {
                    if (it.getDurability() == dur) {
                        ItemStack item = it.clone();
                        item.getItemMeta().setLore(null);
                        eq.addItem(item);
                        return true;
                    }

                }
            }
        } else {
            p.sendMessage(ChatColor.RED + "Posiadasz niewystarczajaca liczbe monet!");
            return false;
        }
        return false;

    }

    public void generateTempItemsMenu() {
        tempMenu.setItem(0, CreateItemUtil.createItem(new ItemStack(Material.WOOL, 1, (byte) 14), "Powrot", new String[]{}));
        tempMenu.setItem(18, CreateItemUtil.createItem(Material.ENCHANTMENT_TABLE, "Stol do zaklec", new String[]{"Koszt:", "70"}));
        tempMenu.setItem(19, CreateItemUtil.createItem(Material.BOW, 1, "Luk", Enchantment.ARROW_DAMAGE, 2, new String[]{"Koszt:", "120"}));
        tempMenu.setItem(20, CreateItemUtil.createItem(Material.ANVIL, 1, "Kowadlo", new String[]{"Koszt:", "100"}));
        tempMenu.setItem(21, CreateItemUtil.createItem(Material.ARROW, 64, "Strzaly", new String[]{"Koszt:", "70"}));
        tempMenu.setItem(22, CreateItemUtil.createItem(Material.TNT, 5, "TNT", new String[]{"Koszt:", "60"}));
        tempMenu.setItem(23, CreateItemUtil.createItem(Material.FLINT_AND_STEEL, 1, "Zapalniczka", new String[]{"Koszt:", "120"}));
        tempMenu.setItem(24, CreateItemUtil.createItem(Material.IRON_PICKAXE, 1, "Zelazny kilof", Enchantment.DIG_SPEED, 1, new String[]{"Koszt:", "150"}));
        tempMenu.setItem(25, CreateItemUtil.createItem(Material.IRON_AXE, 1, "Zelazna siekiera", Enchantment.DIG_SPEED, 1, new String[]{"Koszt:", "130"}));
        tempMenu.setItem(26, CreateItemUtil.createItem(Material.IRON_SPADE, 1, "Zelazna lopata", Enchantment.DIG_SPEED, 1, new String[]{"Koszt:", "130"}));
        tempMenu.setItem(27, CreateItemUtil.createItem(Material.WATER_BUCKET, 1, "Wiadro z woda", new String[]{"Koszt:", "60"}));
        tempMenu.setItem(28, CreateItemUtil.createItem(Material.LAVA_BUCKET, 1, "Wiadro z lawa", new String[]{"Koszt:", "60"}));
        tempMenu.setItem(29, CreateItemUtil.createItem(Material.GOLDEN_APPLE, 10, "Zlote jablka", new String[]{"Koszt:", "100"}));
        tempMenu.setItem(30, CreateItemUtil.createItem(new ItemStack(Material.GOLDEN_APPLE, 1, (byte) 1), "Kox jablko", new String[]{"Koszt:", "150"}));
        tempMenu.setItem(31, CreateItemUtil.createItem(new ItemStack(Material.COOKED_BEEF, 10, (byte) 0), "Upieczone miesa krow", new String[]{"Koszt:", "60"}));
        tempMenu.setItem(32, CreateItemUtil.createItem(new ItemStack(Material.ENDER_CHEST, 1, (byte) 0), "EnderChest", new String[]{"Koszt:", "200"}));

    }

}
