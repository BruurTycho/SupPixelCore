package xyz.suppixel.SupPixelCore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.inventivetalent.glow.GlowAPI;

public class CommandGlowRainbow implements CommandExecutor {
	SupPixelCore plugin; // make a variable that is actually just the plugin
							// (main class) (y)
	
    private final static GlowAPI.Color[] RAINBOW_COLORS = new GlowAPI.Color[] {
            GlowAPI.Color.DARK_AQUA, GlowAPI.Color.GOLD, GlowAPI.Color.RED, GlowAPI.Color.WHITE
        }; // Put your colors here.

	public CommandGlowRainbow(SupPixelCore plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!sender.hasPermission("suppixel.glowrainbow")) { // if the sender DOESNT
														// have permissions
			final String glowrainbownopermmessage1raw = "&7[&cGlow&7] &fYou do not have permission!";
			final String glowrainbownopermmessage1fancy = ChatColor.translateAlternateColorCodes('&', glowrainbownopermmessage1raw);
			sender.sendMessage(glowrainbownopermmessage1fancy);
			return true;
		} if (sender instanceof Player) {			
			BukkitRunnable runnable = new BukkitRunnable() {
                    int step = 0;
		@Override
		public void run() {
                                GlowAPI.Color color = null;

                                if(step >= RAINBOW_COLORS.length) step = 0;
                                  
                                color = RAINBOW_COLORS[step];

			GlowAPI.setGlowing(((Player) sender).getPlayer(), color, ((Player) sender).getPlayer());

                                step++;
		}
	};
	runnable.runTaskTimer(plugin, 0L, 4L);
	}
		return false;
}
}