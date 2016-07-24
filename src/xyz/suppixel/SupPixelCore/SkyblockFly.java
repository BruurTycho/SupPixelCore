package xyz.suppixel.SupPixelCore;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.wasteofplastic.askyblock.events.IslandEnterEvent;
import com.wasteofplastic.askyblock.events.IslandExitEvent;

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
			} else {
	}
}
}