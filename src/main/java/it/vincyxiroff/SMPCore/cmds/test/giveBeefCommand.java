package it.vincyxiroff.SMPCore.cmds.test;

import it.vincyxiroff.SMPCore.SMPCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class giveBeefCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player p){
            if(p.hasPermission("smpcore.admin.test.cmd1")){
                ItemStack carne = new ItemStack(Material.BEEF, SMPCore.getPlugin().getConfig().getInt("beef-amount"));
                ItemMeta carneMeta = carne.getItemMeta();
                carneMeta.setDisplayName("La Giga NegraCarne");
                List<String> carneLore = new ArrayList<>();
                carneLore.add("Questa è la carne di un negro sparato");
                carneMeta.setLore(carneLore);
                carneMeta.addEnchant(Enchantment.EFFICIENCY, 1000 , true);
                carneMeta.addEnchant(Enchantment.FORTUNE, 200, true);
                carne.setItemMeta(carneMeta);
                if(args.length == 0){
                    p.getInventory().addItem(carne);
                } else if (args.length == 1) {
                    String argp = args[0];
                    Player pargs = Bukkit.getPlayerExact(argp);

                    if (pargs == null){
                        p.sendMessage(ChatColor.RED+ "" + ChatColor.BOLD + "Hey " + p.getDisplayName() + ", " + argp + " is offline");
                    }else{
                        pargs.getInventory().addItem(carne);
                        p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Carne di un negro sparato ottenuta con successo");
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Yoo many args...");
                }
            }else {
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You Don't have prmission to use this command");
            }

        }
        return true;
    }
}
