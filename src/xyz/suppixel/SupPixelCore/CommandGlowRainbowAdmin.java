package xyz.suppixel.SupPixelCore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.inventivetalent.glow.GlowAPI;

public class CommandGlowRainbowAdmin implements CommandExecutor {
	SupPixelCore plugin; // make a variable that is actually just the plugin
							// (main class) (y)

	private final static GlowAPI.Color[] RAINBOW_COLORS = new GlowAPI.Color[] { GlowAPI.Color.GOLD, GlowAPI.Color.RED,
			GlowAPI.Color.WHITE, GlowAPI.Color.YELLOW }; // Put your colors
															// here.

	public CommandGlowRainbowAdmin(SupPixelCore plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!sender.hasPermission("suppixel.glowrainbowadmin")) { // if the
																	// sender
																	// DOESNT
			// have permissions
			sender.sendMessage("u haz no permz");
			return true;
		}
		if (sender instanceof Player) {
			BukkitRunnable runnable = new BukkitRunnable() {

				int step = 0;

				@Override
				public void run() {

					GlowAPI.Color color = null;

					if (step >= RAINBOW_COLORS.length)
						step = 0;

					color = RAINBOW_COLORS[step];

					GlowAPI.setGlowing(((Player) sender).getPlayer(), color, ((Player) sender).getPlayer());
					System.out.println("kleurtje " + color);
					step++;
				}
			};
			runnable.runTaskTimer(plugin, 0L, 0L);
			int ID = runnable.getTaskId();
			System.out.println("hier je kut id" + ID);
		}
		return false;
	}
}