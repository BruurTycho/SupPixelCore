package xyz.suppixel.SupPixelCore;

import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

public class EnderPearlRider implements Listener {
	SupPixelCore plugin; // make the variable that is actually just the plugin

	public EnderPearlRider(SupPixelCore plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onTeleport(PlayerTeleportEvent event) {
		if (event.getCause() == TeleportCause.ENDER_PEARL) {
			event.setCancelled(true);
			event.getPlayer().getInventory().setItem(8, new ItemStack(Material.ENDER_PEARL, 1));
		}
	}

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().getInventory().setItem(8, new ItemStack(Material.ENDER_PEARL, 1));
	}

	@EventHandler
	public void ProjectileLaunch(ProjectileLaunchEvent event) {
		if (event.getEntity() instanceof EnderPearl) {
			final ProjectileSource shooter = event.getEntity().getShooter();
			event.getEntity().setPassenger((Entity) shooter);
			event.getEntity().setGravity(false);
			event.getEntity().setVelocity(new Vector(3, 1, 0));
		}
	}
}
