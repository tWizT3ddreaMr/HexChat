package tsp.hexchat.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import tsp.hexchat.util.Formatter;

public class ChatListener implements Listener {

    @EventHandler
    public void chat(AsyncPlayerChatEvent e) {
        e.setMessage(Formatter.setPlaceholders(e.getPlayer(), e.getMessage()));
        e.setMessage(Formatter.colorize(e.getPlayer(), e.getMessage()));
        e.setMessage(Formatter.format(e.getPlayer(), e.getMessage()));
    }

}
