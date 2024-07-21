package me.asuks.friendplugin.commands;

import me.asuks.friendplugin.FriendPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import java.util.List;

public class FriendListCommand extends AbstractCommand {

    public FriendListCommand(FriendPlugin plugin) {
        super(plugin);
    }

    @Override
    AbstractCommand getInstance() {
        return this;
    }

    @Override
    public String getCommandName() {
        return "friend-list";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return true;
        List<Player> friends = FriendPlugin.getManager().getFriend((Player) sender);
        sender.sendMessage(ChatColor.BLUE+"---Friend List---");
        for(Player friend : friends) {
            sender.sendMessage(ChatColor.GREEN+friend.getName());
        }
        sender.sendMessage(ChatColor.BLUE+"-----------------");
        return true;
    }
}
