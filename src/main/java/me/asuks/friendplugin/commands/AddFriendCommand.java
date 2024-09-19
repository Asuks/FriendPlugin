package me.asuks.friendplugin.commands;

import me.asuks.friendplugin.FriendPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddFriendCommand extends AbstractCommand{

    public AddFriendCommand(FriendPlugin plugin) {
        super(plugin);
    }

    @Override
    AbstractCommand getInstance() {
        return this;
    }

    @Override
    public String getCommandName() {
        return "AddFriend";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        for(String arg: args){
            Player friend =Bukkit.getPlayer(arg);
            FriendPlugin.getManager().addFriend( friend, (Player)sender);
        }

        return true;
    }


}