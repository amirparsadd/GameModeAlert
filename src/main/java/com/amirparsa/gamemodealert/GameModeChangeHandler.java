package com.amirparsa.gamemodealert;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

import java.util.stream.Collectors;

public class GameModeChangeHandler implements Listener {

    @EventHandler
    public void onPlayerGameModeChange(PlayerGameModeChangeEvent event) {
        if(!event.getPlayer().hasPermission("gamemodealert.bypass")){
            if(GameModeAlert.getInstance().getConfig().getBoolean("console-log")) {
                GameModeAlert.getInstance().getLogger().info(ChatColor.GREEN + "[" + GameModeAlert.getInstance().getConfig().getString("prefix", "GMA") + "] " + ChatColor.GRAY + "User " + event.getPlayer().getName() + "Changed His Game Mode To" + event.getNewGameMode().name());
            }
            for(Player p : Bukkit.getOnlinePlayers().stream().filter(p -> p.hasPermission("gamemodealert.admin")).collect(Collectors.toList())){
                p.sendMessage(ChatColor.GREEN + "[" + GameModeAlert.getInstance().getConfig().getString("prefix", "GMA") + "] " + ChatColor.GRAY + "User " + event.getPlayer().getName() + "Changed His Game Mode To" + event.getNewGameMode().name());
            }
        }
    }
}
