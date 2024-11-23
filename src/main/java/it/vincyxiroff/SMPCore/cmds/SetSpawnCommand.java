package it.vincyxiroff.SMPCore.cmds;

import it.vincyxiroff.SMPCore.SMPCore;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player p){
            if(p.hasPermission("smpcore.admin.setspawn")){
                World world = p.getWorld();

                Location loc = p.getLocation();

                SMPCore.getPlugin().getConfig().set("Spawn", loc);
                SMPCore.getPlugin().saveConfig();
                try{
                    p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Spawn Set To: X:" + loc.getX() + " Y:" + loc.getY() + " Z:" + loc.getZ());
                }catch (Exception e){
                    System.out.println(e);
                }

            }else{
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You Don't Have The Permission To Run This Command (smpcore.admin.setspawn)");
            }

        }else{
            System.out.println("Only Players Can Run THis Command!");
        }
        return true;
    }
}
