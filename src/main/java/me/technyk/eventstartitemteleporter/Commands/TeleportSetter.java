package me.technyk.eventstartitemteleporter.Commands;

import me.technyk.eventstartitemteleporter.EventStartItemTeleporter;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportSetter implements CommandExecutor {

    EventStartItemTeleporter plugin;

    public TeleportSetter(EventStartItemTeleporter plugin){
        this.plugin = plugin;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage("This command may only be used by a player");
            return true;
        }

        Player player = (Player) sender;

        if(!player.hasPermission("teleitem.set")){
            player.sendMessage(ChatColor.RED + "Na tento příkaz nemáš dostatečné práva");
            return true;
        }

        plugin.setTeleportLocation(player.getLocation());
        player.sendMessage(ChatColor.YELLOW + "Teleportovací lokace byla nastavena na tvou lokaci!");

        return true;
    }
}
