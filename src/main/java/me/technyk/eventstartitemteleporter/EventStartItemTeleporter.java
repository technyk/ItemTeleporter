package me.technyk.eventstartitemteleporter;

import me.technyk.eventstartitemteleporter.Commands.ItemGiver;
import me.technyk.eventstartitemteleporter.Commands.TeleportSetter;
import me.technyk.eventstartitemteleporter.Listeners.RightClickEvent;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public final class EventStartItemTeleporter extends JavaPlugin {

    public Location getTeleportLocation() {
        return teleportLocation;
    }

    public void setTeleportLocation(Location teleportLocation) {
        this.teleportLocation = teleportLocation;
    }

    Location teleportLocation;

    @Override
    public void onEnable() {
        // Plugin startup logic
        //noinspection ConstantConditions
        getCommand("teleitemgive").setExecutor(new ItemGiver());
        //noinspection ConstantConditions
        getCommand("teleitemset").setExecutor(new TeleportSetter(this));
        getServer().getPluginManager().registerEvents(new RightClickEvent(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
