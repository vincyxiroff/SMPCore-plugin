package it.vincyxiroff.SMPCore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AdminGuiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if ( sender instanceof Player ){
            Player p = (Player) sender;
            if(p.hasPermission("smpcore.admin.gui-open")){
                Inventory inv1 = Bukkit.createInventory(p, 9, ChatColor.GREEN + "Admin Gui");

                ItemStack heal = new ItemStack(Material.BEEF);
                ItemStack suicide = new ItemStack(Material.TNT);
                ItemStack opsword = new ItemStack(Material.DIAMOND_SWORD);

                //item meta
                ItemMeta healM = heal.getItemMeta();
                ItemMeta suicideM = suicide.getItemMeta();
                ItemMeta opswordM = opsword.getItemMeta();

                healM.setDisplayName(ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Heal Food And Health");
                suicideM.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Suicide");
                opswordM.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + "gives you an op sword");

                heal.setItemMeta(healM);
                suicide.setItemMeta(suicideM);
                opsword.setItemMeta(opswordM);

                inv1.setItem(0, heal);
                inv1.setItem(4, suicide);
                inv1.setItem(8, opsword);

                p.openInventory(inv1);
            } else{
                p.sendMessage(ChatColor.BOLD + "" + ChatColor.RED + "You Don't Have Permission To Run This Command");
            }


        }
        return true;
    }
}
