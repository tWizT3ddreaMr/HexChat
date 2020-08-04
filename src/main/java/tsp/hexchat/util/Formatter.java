package tsp.hexchat.util;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formatter {

    private static final Pattern pattern = Pattern.compile("(?<!\\\\)(&#[a-fA-F0-9]{6})");

    public static String format(Player player, String message) {
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            String color = message.substring(matcher.start()+1, matcher.end());
           
	            if (player.hasPermission("hexchat.hex.all") || player.hasPermission("hexchat.hex." + color)) {
	                message = message.replace("&"+color, "" + ChatColor.of(color));
	                matcher = pattern.matcher(message);
	            }
      
        }
        return message;
    }
    public static String formatnp(String message) {
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            String color = message.substring(matcher.start()+1, matcher.end());
	            
	        message = message.replace("&"+color, "" + ChatColor.of(color));
	        matcher = pattern.matcher(message);
      
        }
        return message;
    }
    
    public static boolean test (String s){
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){
            return true;
        }
        return false;
    }
    @SuppressWarnings("deprecation")
	public static String setPlaceholders(Player player, String message) {
        message = message
                .replace("%player%", player.getName())
                .replace("%world%", player.getWorld().getName());

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            if (player.hasPermission("hexchat.placeholders.all")) {
                message = PlaceholderAPI.setPlaceholders(player, message);
            }
        }

        return message;
    }

    public static String colorize(Player player, String message) {
        if (player.hasPermission("hexchat.color.all")) {
            message = org.bukkit.ChatColor.translateAlternateColorCodes('&', message);
        }

        return message;
    }

    public static String colorize(String message) {
        return org.bukkit.ChatColor.translateAlternateColorCodes('&', message);
    }

}
