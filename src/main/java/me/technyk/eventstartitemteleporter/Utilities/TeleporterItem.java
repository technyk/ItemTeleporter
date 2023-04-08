package me.technyk.eventstartitemteleporter.Utilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TeleporterItem {

    public ItemStack getTeleportItem(){
        ItemStack teleportItem = new ItemStack(Material.IRON_BLOCK);
        ItemMeta itemMeta = teleportItem.getItemMeta();

        //noinspection ConstantConditions
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);

        List<String> itemLore = new ArrayList<>();

        itemLore.add(ChatColor.translateAlternateColorCodes('&', "&eKlikni pravým pro teleport"));
        itemLore.add(ChatColor.translateAlternateColorCodes('&', "&ena začátek &aeventu&e!"));
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Teleport Item");
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DYE, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);

        teleportItem.setItemMeta(itemMeta);
        return teleportItem;
    }

}
