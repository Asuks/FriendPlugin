package me.asuks.friendplugin.commands;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import me.asuks.friendplugin.FriendPlugin;
import me.asuks.friendplugin.forJSON.NoteStorageUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.UUID;

public class SaveFileCommand extends AbstractCommand{

    public SaveFileCommand(FriendPlugin plugin) {
        super(plugin);
    }

    @Override
    AbstractCommand getInstance() {
        return this;
    }

    @Override
    public String getCommandName() {
        return "SaveFile";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        try {
            NoteStorageUtil.saveNotes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }



}