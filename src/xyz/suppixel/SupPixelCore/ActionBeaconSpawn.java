package xyz.suppixel.SupPixelCore;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class ActionBeaconSpawn {
	SupPixelCore plugin; // make a variable that is actually just the plugin
	// (main class) (y)

public ActionBeaconSpawn(SupPixelCore plugin) {
this.plugin = plugin;

BukkitScheduler scheduler = plugin.getServer().getScheduler();
scheduler.scheduleSyncRepeatingTask((Plugin) this, new Runnable() {
	@Override
	public void run() {
		plugin.getServer().broadcastMessage("dank daniel haha");
	}
}, 0L, 20L);
}
}