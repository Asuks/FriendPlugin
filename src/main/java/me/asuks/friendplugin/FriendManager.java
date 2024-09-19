package me.asuks.friendplugin;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.List;

public class FriendManager {
    public static Map<UUID, List<UUID>> friendMap;

    public FriendManager() {
        friendMap = new HashMap<>();
    }


    public void friendRequest(Player player, Player friend) {
        List<UUID> friends = friendMap.get(player.getUniqueId());
        if(friends == null) friends = new ArrayList<>();

        String nam=player.getName();

        friend.sendMessage("would you accept this friend request?");

        if(!friends.contains(friend.getUniqueId())){
            TextComponent message= new TextComponent(ChatColor.GREEN+"Accept");
            message.setBold(true);
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/AddFriend "+nam));
            message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Accept this friend request").italic(true).create()));

            friend.spigot().sendMessage(message);
        }
        else{
            player.sendMessage(ChatColor.RED+"You`re are already friends with this person!");
        }


    }

    public void addFriend(Player player, Player friend){
        List<UUID> friends = friendMap.get(player.getUniqueId());
        List<UUID> subfriends = friendMap.get(friend.getUniqueId());
        if(subfriends == null) subfriends = new ArrayList<>();
        if(friends == null) friends = new ArrayList<>();
        friends.add(friend.getUniqueId());
        subfriends.add(player.getUniqueId());
        friendMap.put(player.getUniqueId(), friends);
        friendMap.put(friend.getUniqueId(), subfriends);
        player.sendMessage(ChatColor.GOLD+"Your request is accepted!");
        friend.sendMessage(ChatColor.GOLD+"You are now friends with "+player.getName());
    }

    public void removeFriend(Player player, Player friend){
        List<UUID> friends = friendMap.get(player.getUniqueId());
        List<UUID> subfriends = friendMap.get(friend.getUniqueId());
        if(subfriends == null || friends == null)return;
        if(friends.contains(friend.getUniqueId())){
            player.sendMessage(ChatColor.GREEN + "Removed " + friend.getName() + "from your friend list!");
            friend.sendMessage(ChatColor.GREEN +  player.getName() + " has been removed from your friend list!");
            friends.remove(friend.getUniqueId());
            subfriends.remove(player.getUniqueId());
            friendMap.put(player.getUniqueId(), friends);
            friendMap.put(friend.getUniqueId(), subfriends);
        }
        else{
            player.sendMessage(ChatColor.RED+"Your are not friends with this person!");
        }
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

    public void readjson() throws IOException {
        Gson gson = new Gson();
        File file = new File(FriendPlugin.getPlugin().getDataFolder().getAbsolutePath()+"/notes.json");
        file.getParentFile().mkdir();
        file.createNewFile();
        Type mapType = new TypeToken<Map<UUID,List<UUID>>>() {}.getType();
        try (FileReader reader = new FileReader(FriendPlugin.getPlugin().getDataFolder().getAbsolutePath()+"/notes.json")){
            friendMap = gson.fromJson(reader, mapType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}