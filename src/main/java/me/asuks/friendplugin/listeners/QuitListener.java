package me.asuks.friendplugin.listeners;

import me.asuks.friendplugin.FriendPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage("");
        Player friend = event.getPlayer();
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(FriendPlugin.getManager().isFriend(player, friend)) player.sendMessage("Friend> " + friend.getName() + " left.");
        }
    }
}
