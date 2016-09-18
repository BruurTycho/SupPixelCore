package xyz.suppixel.SupPixelCore;

import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class SomeSign implements Listener {
	SupPixelCore plugin; // make a variable that is actually just the plugin
	// (main class) (y)

	public SomeSign(SupPixelCore plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onSignChange(SignChangeEvent event) {
		if (event.getLine(0).equalsIgnoreCase("[Damn]")) {
			event.setLine(0, "�6[Damn]");
			event.setLine(1, "�6[Daniel]");
		}
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
		if (event.getClickedBlock().getState() instanceof Sign) {
			Sign s = (Sign) event.getClickedBlock().getState();
			if (s.getLine(0).equalsIgnoreCase("�6[Damn]")) {
				event.getPlayer().setVelocity(new Vector(0, 20, 0));
				event.getPlayer().sendMessage("�6Damn Daniel!");
			}
		}
	}
}
