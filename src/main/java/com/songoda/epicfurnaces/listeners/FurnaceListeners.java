package com.songoda.epicfurnaces.listeners;

import com.songoda.epicfurnaces.EpicFurnaces;
import com.songoda.epicfurnaces.furnace.Furnace;
import com.songoda.epicfurnaces.level.Level;
import com.songoda.epicfurnaces.settings.Settings;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;

public class FurnaceListeners implements Listener {
    private final EpicFurnaces plugin;

    public FurnaceListeners(EpicFurnaces plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCook(FurnaceSmeltEvent event) {
        Block block = event.getBlock();
        if (event.getBlock().isBlockPowered() && Settings.REDSTONE_DEACTIVATES.getBoolean()) {
            event.setCancelled(true);
            return;
        }

        Furnace furnace = this.plugin.getFurnaceManager().getFurnace(block.getLocation());

        if (furnace != null)
            furnace.plus(event);
    }

    @EventHandler
    public void onFuel(FurnaceBurnEvent event) {
        Furnace furnace = this.plugin.getFurnaceManager().getFurnace(event.getBlock().getLocation());
        if (furnace == null)
            return;

        Level level = furnace.getLevel();

        if (level.getFuelDuration() == 0)
            return;

        int percent = (event.getBurnTime() / 100) * level.getFuelDuration();
        event.setBurnTime(event.getBurnTime() + percent);
    }
}
