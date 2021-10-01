package org.funty.borderlevel;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.funty.borderlevel.commands.BorderLevelCommand;
import org.funty.borderlevel.listener.PlayerLevelChangeListener;

public final class Main extends JavaPlugin {

    private static Main plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        //listener
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerLevelChangeListener(), this);

        //commands
        getCommand("borderlevel").setExecutor(new BorderLevelCommand());
        getCommand("borderlevel").setTabCompleter(new BorderLevelCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static Main getPlugin(){
        return plugin;
    }
}
