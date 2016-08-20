package xyz.suppixel.SupPixelCore;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PressurePlateLaunch implements Listener {
	String kappa = "hi";
	SupPixelCore plugin; // make the variable that is actually just the plugin

	public PressurePlateLaunch(SupPixelCore plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void PlayerInteract(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.PHYSICAL)){
			if(event.getClickedBlock().getType() == Material.STONE_PLATE && event.getPlayer().hasPermission(kappa)){
				Player player = event.getPlayer();
				Location playerloc = player.getLocation().add(0.0D, 1.0D, 0.0D);
				player.teleport(playerloc);
				player.setVelocity(player.getVelocity().add(player.getLocation().getDirection().multiply(3.5D)).setY(1D));
			}
		}
	}
}