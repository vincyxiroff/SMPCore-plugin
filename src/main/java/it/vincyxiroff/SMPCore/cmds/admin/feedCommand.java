package it.vincyxiroff.SMPCore.cmds.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class feedCommand implements CommandExecutor {

    private final HashMap<UUID, Long> cooldown;

    public feedCommand(){
        this.cooldown = new HashMap<>();
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player p){
            if(sender.hasPermission("smpcore.admin.feed")) {
                if(!this.cooldown.containsKey(p.getUniqueId()) || System.currentTimeMillis() - cooldown.get(p.getUniqueId()) >= 500 ){
                    this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                    if(args.length == 0){
                        p.setFoodLevel(20);
                        p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Feed Successfully");
                    } else if (args.length == 1) {
                        String pname = args[0];
                        Player target = Bukkit.getPlayerExact(pname);

                        if(target==null){
                            try{
                                OfflinePlayer poff = Bukkit.getOfflinePlayer(pname);
                                p.sendMessage(ChatColor.RED + "" + pname + " is offline");

                            }catch (Exception e){
                                System.out.println(e);
                            }
                        }else {
                            target.setFoodLevel(20);
                            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "" + pname + " Has Been Feed Successfully");
                            target.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You Have been Feed Successfully by " + p.getDisplayName());
                        }
                    }else{
                        p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Too many args...");
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You are on cooldown");
                }
            }else{
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You dont have the permission to run this command (smpcore.admin.feed)");
            }
        }else{
            System.out.println("Only Players Cab Run This Command");
        }

        return true;
    }
}
