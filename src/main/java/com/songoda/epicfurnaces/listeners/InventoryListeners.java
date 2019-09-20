package com.songoda.epicfurnaces.listeners;

import com.songoda.epicfurnaces.EpicFurnaces;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;

/**
 * Created by songoda on 2/26/2017.
 */
public class InventoryListeners implements Listener {

    private final EpicFurnaces plugin;

    public InventoryListeners(EpicFurnaces plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryMove(InventoryMoveItemEvent event) {
        if (!event.getDestination().getType().equals(InventoryType.FURNACE)
                || event.getDestination().getItem(0) == null
                || event.getDestination().getItem(0).getType() != event.getItem().getType()
                || event.getDestination().getItem(0).getAmount() != 1) {
            return;
        }
        plugin.getFurnaceManager().getFurnace(((org.bukkit.block.Furnace)
                event.getDestination().getHolder()).getLocation()).updateCook();
    }

    @SuppressWarnings("unchecked")
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getSlot() != 64537) {
            if (event.getInventory().getType() == InventoryType.ANVIL) {
                if (event.getAction() != InventoryAction.NOTHING) {
                    if (event.getCurrentItem().getType() != Material.AIR) {
                        ItemStack item = event.getCurrentItem();
                        if (item.getType().name().contains("FURNACE")) {
                            event.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}