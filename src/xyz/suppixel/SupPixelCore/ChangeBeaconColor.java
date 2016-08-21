package xyz.suppixel.SupPixelCore;

import java.util.HashMap;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ChangeBeaconColor implements Listener {
	SupPixelCore plugin; // make the variable that is actually just the plugin

	public ChangeBeaconColor(SupPixelCore plugin) {
		this.plugin = plugin;
	}
	
	
	
	public static HashMap<String, Integer> List = new HashMap<>();
	
	@EventHandler
	public void OnUpdate() {
		
	}
	
}
