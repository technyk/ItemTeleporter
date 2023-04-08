package me.technyk.eventstartitemteleporter.Commands;

import me.technyk.eventstartitemteleporter.Utilities.TeleporterItem;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemGiver implements CommandExecutor {
    @Override
    @SuppressWarnings("NullableProblems")
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage("This command may only be used by a player");
            return true;
        }

        Player player = (Player) sender;
        if(!player.hasPermission("teleitem.give")){
            player.sendMessage(ChatColor.RED + "Na tento příkaz nemáš dostatečné práva");
            return true;
        }

        TeleporterItem teleporterItem = new TeleporterItem();
        ItemStack givenItem = teleporterItem.getTeleportItem();

        player.getInventory().addItem(givenItem);

        return true;
    }
}
