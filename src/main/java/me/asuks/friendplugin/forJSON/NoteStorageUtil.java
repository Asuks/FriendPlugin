package me.asuks.friendplugin.forJSON;



import com.google.gson.Gson;
import me.asuks.friendplugin.FriendManager;
import me.asuks.friendplugin.FriendPlugin;
import me.asuks.friendplugin.forJSON.Note;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;

public class NoteStorageUtil {

    public static void saveNotes() throws IOException {
        Gson gson = new Gson();
        File file = new File(FriendPlugin.getPlugin().getDataFolder().getAbsolutePath()+"/notes.json");
        file.getParentFile().mkdir();
        file.createNewFile();
        Writer writer = new FileWriter(file, false);
        gson.toJson(FriendManager.friendMap, writer);
        writer.flush();
        writer.close();
        System.out.println("Notes saved.");
    }
}
