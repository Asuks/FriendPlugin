package me.asuks.friendplugin;

import me.asuks.friendplugin.commands.*;
import me.asuks.friendplugin.listeners.JoinListener;
import me.asuks.friendplugin.listeners.QuitListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class FriendPlugin extends JavaPlugin {
    private static FriendManager manager;
    private static FriendPlugin plugin;
    @Override
    public void onEnable() {
        plugin = this;
        manager = new FriendManager();
        new FriendCommand(this);
        new FriendListCommand(this);
        new AddFriendCommand(this);
        new SaveFileCommand(this);
        new ReadJsonCommand(this);

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new QuitListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static FriendManager getManager() {
        return manager;
    }

    public static FriendPlugin getPlugin() {
        return plugin;
    }
}