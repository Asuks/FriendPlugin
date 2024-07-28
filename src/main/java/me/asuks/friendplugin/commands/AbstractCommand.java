package me.asuks.friendplugin.commands;

import me.asuks.friendplugin.FriendPlugin;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;

public abstract class AbstractCommand implements CommandExecutor {

    public AbstractCommand(FriendPlugin plugin) {
        PluginCommand c = plugin.getCommand(this.getCommandName());
        c.setExecutor(this.getInstance());
    }

    abstract AbstractCommand getInstance();

    public abstract String getCommandName();
}