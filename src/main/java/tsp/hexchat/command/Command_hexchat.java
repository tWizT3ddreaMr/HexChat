package tsp.hexchat.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import tsp.hexchat.util.Formatter;

public class Command_hexchat implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        sender.sendMessage(Formatter.colorize("&7Running &9HexChat 1.0"));
        sender.sendMessage(Formatter.colorize("&&Created by &9[Silent]"));
        return true;
    }

}
