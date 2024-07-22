package me.asuks.friendplugin.commands;

import me.asuks.friendplugin.FriendPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class add_FriendCommand extends AbstractCommand{

    public add_FriendCommand(FriendPlugin plugin) {
        super(plugin);
    }

    @Override
    AbstractCommand getInstance() {
        return this;
    }

    @Override
    public String getCommandName() {
        return "add_Friend";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        for(String arg: args){
            Player friend =Bukkit.getPlayer(arg);
            FriendPlugin.getManager().add_friend( friend, (Player)sender);
        }

        return true;
    }


}