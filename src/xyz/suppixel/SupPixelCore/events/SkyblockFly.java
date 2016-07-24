package xyz.suppixel.SupPixelCore.events;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.wasteofplastic.askyblock.events.IslandEnterEvent;
import com.wasteofplastic.askyblock.events.IslandExitEvent;

import xyz.suppixel.SupPixelCore.SupPixelCore;

public class SkyblockFly implements Listener {
	SupPixelCore plugin; // make the variable that is actually just the plugin

	public SkyblockFly(SupPixelCore plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onIslandEnter(IslandEnterEvent event) {
		final UUID owner = (UUID) event.getIslandOwner();
		final Player ownerusername = plugin.getServer().getPlayer(owner);
		if (ownerusername.hasPermission("suppixel.islandfly")) {
			final UUID playerenter = (UUID) event.getPlayer();
			final Player playerenterusername = plugin.getServer().getPlayer(playerenter);
			playerenterusername.setAllowFlight(true);
			playerenterusername.setFlying(true);
			final String IslandEnterMessage1raw = "&7[&cAuto-Fly&7] &fEnabled fly.";
			final String IslandEnterMessage1fancy = ChatColor.translateAlternateColorCodes('&', IslandEnterMessage1raw);
			playerenterusername.sendMessage(IslandEnterMessage1fancy);
		} else {
			
		}
			// 	
		}
		@EventHandler
		public void onIslandExit(IslandExitEvent event) {
			final UUID owner = (UUID) event.getIslandOwner();
			final Player ownerusername = plugin.getServer().getPlayer(owner);
			if (ownerusername.hasPermission("suppixel.islandfly")) {
				final UUID playerenter = (UUID) event.getPlayer();
				final Player playerenterusername = plugin.getServer().getPlayer(playerenter);
				playerenterusername.setAllowFlight(false);
				playerenterusername.setFlying(false);
				final String IslandExitMessage1raw = "&7[&cAuto-Fly&7] &fDisabled fly.";
				final String IslandExitMessage1fancy = ChatColor.translateAlternateColorCodes('&', IslandExitMessage1raw);
				playerenterusername.sendMessage(IslandExitMessage1fancy);
			} else {
	}
}
}