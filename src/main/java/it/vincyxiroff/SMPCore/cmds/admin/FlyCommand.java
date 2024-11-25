package it.vincyxiroff.SMPCore.cmds.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;


public class FlyCommand implements CommandExecutor {

    private ArrayList<Player> lista_in_volo = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                Fly(p);
            } else if (args.length == 1) {
                if(p.hasPermission("smpcore.admin.fly.others")){
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target != null){
                        Fly(target);
                    }
                }
            }
        }
        return true;
    }

    public void Fly(Player p){
        if(p.hasPermission("smpcore.admin.fly")){
            if(lista_in_volo.contains(p)){
                lista_in_volo.remove(p);
                p.setAllowFlight(false);
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Fly Disabled");
            } else if (!lista_in_volo.contains(p)) {
                lista_in_volo.add(p);
                p.setAllowFlight(true);
                p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You Can Now Fly");
            }
        }
    }
}
