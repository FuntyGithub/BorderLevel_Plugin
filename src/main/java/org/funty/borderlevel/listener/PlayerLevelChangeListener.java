package org.funty.borderlevel.listener;

import org.bukkit.Bukkit;
import org.bukkit.WorldBorder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class PlayerLevelChangeListener implements Listener {
    @EventHandler
    public void onLevelup(PlayerLevelChangeEvent e){
        WorldBorder worldBorder = Bukkit.getWorld(e.getPlayer().getWorld().getUID()).getWorldBorder();
        worldBorder.setSize(e.getNewLevel()+1,e.getNewLevel()+1);
    }

}
