package me.technyk.eventstartitemteleporter.Listeners;

import me.technyk.eventstartitemteleporter.EventStartItemTeleporter;
import me.technyk.eventstartitemteleporter.Utilities.TeleporterItem;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RightClickEvent implements Listener {

    EventStartItemTeleporter plugin;

    public RightClickEvent(EventStartItemTeleporter plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR))
        {
            TeleporterItem itemClass = new TeleporterItem();
            ItemStack clickedItem = event.getItem();
            ItemStack teleportItem = itemClass.getTeleportItem();

            if(clickedItem != null && clickedItem.equals(teleportItem)){
                player.sendMessage(ChatColor.GREEN + "Byl jsi teleportován na začátek eventu!");
                Location loc = plugin.getTeleportLocation();
                if(loc == null){
                    player.sendMessage(ChatColor.RED + "Startovací místo eventu ještě nebylo určeno!");
                    event.setCancelled(true);
                    return;
                }
                player.teleport(plugin.getTeleportLocation());
                event.setCancelled(true);
            }
        }
    }
}
