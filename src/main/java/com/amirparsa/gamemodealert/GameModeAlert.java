package com.amirparsa.gamemodealert;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class GameModeAlert extends JavaPlugin {

    private static GameModeAlert plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new GameModeChangeHandler(), this);
        getLogger().info(ChatColor.GREEN + "GameModeAlert Is Now ON!");
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "GameModeAlert Is Now OFF!");
    }

    public static GameModeAlert getInstance() {
        return plugin;
    }
}
