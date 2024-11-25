package it.vincyxiroff.SMPCore;

import it.vincyxiroff.SMPCore.cmds.*;
import it.vincyxiroff.SMPCore.cmds.test.giveBeefCommand;
import it.vincyxiroff.SMPCore.events.AdminGuiEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import it.vincyxiroff.SMPCore.events.Events;
import org.bstats.bukkit.Metrics;

public final class SMPCore extends JavaPlugin implements Listener {

    //ho fatto l'instance del plugin cosi sara piu semplice chiamarla in futuro esempio:
    // SMPCore.getPlugin().etc; o SMPCore.getPlugin(); da fare dentro una CLASS
    private static SMPCore plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        int pluginId = 23979;
        // off for now | Metrics metrics = new Metrics(this, pluginId);
        System.out.println("SMPCORE Has Started");
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginManager().registerEvents(new AdminGuiEvent(), this);
        getCommand("feed").setExecutor(new feedCommand());
        getCommand("spawn").setExecutor(new spawnCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("give-beef").setExecutor(new giveBeefCommand());
        getCommand("s-reload").setExecutor(new reloadCommand());
        getCommand("admin-gui").setExecutor(new AdminGuiCommand());

        getConfig().options().copyDefaults();
        saveDefaultConfig();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // tre linee - code - generate - getter

    public static SMPCore getPlugin() {
        return plugin;
    }
}
