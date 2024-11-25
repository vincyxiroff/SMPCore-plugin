package it.vincyxiroff.SMPCore.events;

import it.vincyxiroff.SMPCore.SMPCore;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AdminGuiEvent implements Listener {

    @EventHandler
    public void onAdminGuiInteract(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equals(ChatColor.GREEN + "Admin Gui")){

            if(e.isRightClick()) return;

            e.setCancelled(true);

            switch (e.getCurrentItem().getType()){
                case BEEF:
                    p.setHealth(20.0);
                    p.setFoodLevel(20);
                    break;
                case TNT:
                    p.setHealth(0.0);
                    break;
                case DIAMOND_SWORD:
                    ItemStack opsword = new ItemStack(Material.DIAMOND_SWORD);
                    ItemMeta opswordM = opsword.getItemMeta();

                    opswordM.addEnchant(Enchantment.SHARPNESS, 1000, true);
                    opswordM.addEnchant(Enchantment.FIRE_ASPECT, 1000, true);
                    opsword.setItemMeta(opswordM);

                    p.getInventory().addItem(opsword);
                    break;
            }
        }
    }
}
