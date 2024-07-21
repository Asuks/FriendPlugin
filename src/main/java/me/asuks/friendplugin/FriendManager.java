package me.asuks.friendplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class FriendManager {
    private final Map<UUID, List<UUID>> friendMap;

    public FriendManager() {
        friendMap = new HashMap<>();
    }

    public void addFriend(Player player, Player friend) {
        List<UUID> friends = friendMap.get(player.getUniqueId());
        if(friends == null) friends = new ArrayList<>();
        if(!friends.contains(friend.getUniqueId()))friends.add(friend.getUniqueId());
        friendMap.put(player.getUniqueId(), friends);
    }

    public List<Player> getFriend(Player player) {
        List<UUID> friends = friendMap.get(player.getUniqueId());
        List<Player> friendPlayers = new ArrayList<>();
        if(friends == null) return friendPlayers;
        for(UUID uuid : friends) {
            friendPlayers.add(Bukkit.getPlayer(uuid));
        }
        return friendPlayers;
    }

    public boolean isFriend(Player player, Player friend) {
        List<UUID> friends = friendMap.get(player.getUniqueId());
        return friends != null && friends.contains(friend.getUniqueId());
    }
}
