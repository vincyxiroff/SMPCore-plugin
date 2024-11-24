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

public class AdminGuiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if ( sender instanceof Player ){
            Player p = (Player) sender;

            Inventory inv1 = Bukkit.createInventory(p.getPlayer(), 9, ChatColor.GREEN + "Admin Gui");

            ItemStack heal = new ItemStack(Material.BEEF);
            ItemStack suicide = new ItemStack(Material.TNT);
            ItemStack opsword = new ItemStack(Material.DIAMOND_SWORD);

            //da finire 4:46 / 19:39 ep 14
        }
        return true;
    }
}
