package it.vincyxiroff.SMPCore.events;

import it.vincyxiroff.SMPCore.SMPCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Events implements Listener {


    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        String firstTimeJoinMsg = SMPCore.getPlugin().getConfig().getString("first-join-msg");
        String joinagainmsg = SMPCore.getPlugin().getConfig().getString("join-msg");
        joinagainmsg = joinagainmsg.replace("%player%", e.getPlayer().getDisplayName());
        firstTimeJoinMsg = firstTimeJoinMsg.replace("%player%", e.getPlayer().getDisplayName());
        if(!e.getPlayer().hasPlayedBefore()){
            Location loc = SMPCore.getPlugin().getConfig().getLocation("Spawn");

            if(loc != null){
                p.teleport(loc);
            }
            if (firstTimeJoinMsg != null){
                e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', firstTimeJoinMsg));
            }

        }else {
            if(joinagainmsg != null){
                e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', joinagainmsg));
            }
            System.out.println(p.getDisplayName() + " joined");
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        Location loc = SMPCore.getPlugin().getConfig().getLocation("Spawn");
        Player p = e.getPlayer();
        if(loc != null){
            p.setRespawnLocation(loc);
        }
    }

    @EventHandler
    public void onPlayerEnterBed(PlayerBedEnterEvent e){
        if(SMPCore.getPlugin().getConfig().getBoolean("allow-one-player-skip-night")){
            try{
                Thread.sleep(2000);
            } catch (InterruptedException exc){
                Thread.currentThread().interrupt();
                System.out.println(exc);
            }
            Player player = e.getPlayer();
            PlayerBedEnterEvent.BedEnterResult result = e.getBedEnterResult();
            if(e.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK){
                World world = e.getPlayer().getWorld();
                String skip_msg = SMPCore.getPlugin().getConfig().getString("skip-msg");
                skip_msg = skip_msg.replace("%player%", e.getPlayer().getDisplayName());
                world.setTime(0);
                world.setStorm(false);
                world.setThundering(false);
                if(skip_msg != null){
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', skip_msg));
                }
                e.setCancelled(true);
            }
        }
    }


}
