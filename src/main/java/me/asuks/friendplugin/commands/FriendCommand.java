package me.asuks.friendplugin.commands;

import me.asuks.friendplugin.FriendPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FriendCommand extends AbstractCommand {

    public FriendCommand(FriendPlugin plugin) {
        super(plugin);
    }

    @Override
    AbstractCommand getInstance() {
        return this;
    }

    @Override
    public String getCommandName() {
        return "friend";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return true;
        if(args.length == 0) {
            sender.sendMessage("Usage: /friend <player name>");
            return true;
        }

        for(String arg : args) {
            Player friend = Bukkit.getPlayer(arg);
            if(friend == null) {
                sender.sendMessage("No such player.");
                continue;
            }
            FriendPlugin.getManager().addFriend((Player) sender, friend);
        }
        return true;
    }
}