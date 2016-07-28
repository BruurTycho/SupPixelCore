package xyz.suppixel.SupPixelCore;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJump implements Listener {
	SupPixelCore plugin; // make the variable that is actually just the plugin

	public DoubleJump(SupPixelCore plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
		Player player = event.getPlayer();
		if(player.getGameMode()==GameMode.CREATIVE)
			return;
		event.setCancelled(true);
		player.setAllowFlight(false);
		player.setFlying(false);
		player.setVelocity(player.getLocation().getDirection().multiply(4.5).setY(1));
	}
	
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if((player.getGameMode()!=GameMode.CREATIVE
				&&(player.getLocation().subtract(0, 1, 0).getBlock().getType() != org.bukkit.Material.AIR)
				&& (!player.isFlying()))) {
			player.setAllowFlight(true);
		}
	}
}