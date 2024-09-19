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
        if(args.length == 0 || args.length > 2 ) {
            sender.sendMessage("Usage: /friend <player name>");
            return true;
        }

        if(args.length == 2){
            if(args[0].equalsIgnoreCase("add")){
                Player friend = Bukkit.getPlayer(args[1]);
                if(friend == null) {
                    sender.sendMessage("No such player.");
                    return true;
                }
                else FriendPlugin.getManager().friendRequest((Player) sender, friend);
            }
            else if(args[0].equalsIgnoreCase("remove")){
                Player friend = Bukkit.getPlayer(args[1]);
                if(friend == null) {
                    sender.sendMessage("No such player.");
                    return true;
                }
                else FriendPlugin.getManager().removeFriend((Player) sender, friend);
            }
            else{
                sender.sendMessage("Usage: /friend <player name>!");
                sender.sendMessage(args[0]);
                return true;
            }
        }
        else if(args.length == 1){
            Player friend = Bukkit.getPlayer(args[0]);
            if(friend == null) {
                sender.sendMessage("No such player.");
                return true;
            }
            else FriendPlugin.getManager().friendRequest((Player) sender, friend);
        }
        return true;
    }
}