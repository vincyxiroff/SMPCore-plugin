package it.vincyxiroff.SMPCore.cmds;

import it.vincyxiroff.SMPCore.SMPCore;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player p) {
            if (p.hasPermission("smpcore.spawn")) {

                Location loc = SMPCore.getPlugin().getConfig().getLocation("Spawn");

                if(loc != null){
                    p.teleport(loc);
                    p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Successfully went to the spawn");
                }else {
                    p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "No Spawn Location Set");
                }
            }else{
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You Don't Have The Permission To Run This Command (smpcore.spawn)");
            }
        }else{
            System.out.println("Only Players Can Run THis Command!");
        }
        return true;
    }
}
