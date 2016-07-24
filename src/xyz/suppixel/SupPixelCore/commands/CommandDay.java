package xyz.suppixel.SupPixelCore.commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import xyz.suppixel.SupPixelCore.SupPixelCore;

public class CommandDay implements CommandExecutor {
	SupPixelCore plugin; // make a variable that is actually just the plugin
							// (main class) (y)

	public CommandDay(SupPixelCore plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!sender.hasPermission("suppixel.day")) { // if the sender DOESNT
														// have permissions
			sender.sendMessage("u haz no permz");
			return true;
		} if (sender instanceof Player) {
			final String memmessage1raw = "&7[&cTime&7] &fSetting time to &aDay&f (1000)!";
		final String memmessagefancy = ChatColor.translateAlternateColorCodes('&', memmessage1raw);

		final World world = ((Player) sender).getWorld();
		world.setTime(1000);
		this.plugin.getServer().broadcastMessage(memmessagefancy);

		return true;
	}
		return false;
}
}