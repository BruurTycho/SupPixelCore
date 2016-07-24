package xyz.suppixel.SupPixelCore;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.wasteofplastic.askyblock.events.IslandEnterEvent;

public class SkyblockFly implements Listener {
	SupPixelCore plugin; // make the variable that is actually just the plugin

	public SkyblockFly(SupPixelCore plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onIslandEnter(IslandEnterEvent event) {
		final UUID owner = (UUID) event.getIslandOwner();
		final Player ownerusername = plugin.getServer().getPlayer(owner);
		System.out.println("Island owner UUID: " + owner);
		System.out.println("Island owner username: " + ownerusername);
		if (ownerusername.hasPermission("suppixel.islandfly")) {
			final UUID playerenter = (UUID) event.getPlayer();
			final Player playerenterusername = plugin.getServer().getPlayer(playerenter);
			playerenterusername.setFlying(true);
			plugin.getServer().broadcastMessage("oma is irr"); // Niet waar! :)
		} else {
			// 	
		}
	}
}
