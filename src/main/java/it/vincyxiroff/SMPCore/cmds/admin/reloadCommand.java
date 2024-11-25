package it.vincyxiroff.SMPCore.cmds.admin;

import it.vincyxiroff.SMPCore.SMPCore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;

            if(p.hasPermission("smpcore.admin.reload")){
                SMPCore.getPlugin().reloadConfig();
                p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Plugin Configuration Reloaded Successfully");
            }else{
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You Don't have the permission to use this command");
            }
        }
        return true;
    }
}
