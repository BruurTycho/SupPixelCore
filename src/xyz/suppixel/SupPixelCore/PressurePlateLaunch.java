package xyz.suppixel.SupPixelCore;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PressurePlateLaunch implements Listener {
	SupPixelCore plugin; // make the variable that is actually just the plugin

	public PressurePlateLaunch(SupPixelCore plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void PlayerInteract(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.PHYSICAL)){
			if(event.getClickedBlock().getType() == Material.STONE_PLATE){
				Player player = event.getPlayer();
				player.setVelocity(player.getLocation().getDirection().multiply(1.5).setY(1));
			}
		}
	}
}
