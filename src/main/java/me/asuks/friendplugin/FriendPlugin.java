package me.asuks.friendplugin;

import me.asuks.friendplugin.commands.FriendCommand;
import me.asuks.friendplugin.commands.FriendListCommand;
import me.asuks.friendplugin.listeners.JoinListener;
import me.asuks.friendplugin.listeners.QuitListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class FriendPlugin extends JavaPlugin {
    private static FriendManager manager;

    @Override
    public void onEnable() {
        manager = new FriendManager();
        new FriendCommand(this);
        new FriendListCommand(this);
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
}
