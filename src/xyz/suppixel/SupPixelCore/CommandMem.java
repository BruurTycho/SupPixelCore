package xyz.suppixel.SupPixelCore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandMem implements CommandExecutor {
	SupPixelCore plugin; // make the variable that is actually just the plugin

	public CommandMem(SupPixelCore plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender.hasPermission("suppixel.mem")) {

			final String memmessage1raw = "&7[&cMemory&7] &aFree &7/ &6Total &7/ &cMax";
			final String memmessagefancy = ChatColor.translateAlternateColorCodes('&', memmessage1raw);

			final String memmessage2raw = "&7[&cMemory&7] &a" + (Runtime.getRuntime().freeMemory() / 1024 / 1024)
					+ "&7 / &6" + (Runtime.getRuntime().totalMemory() / 1024 / 1024) + " &7 / &c"
					+ (Runtime.getRuntime().maxMemory() / 1024 / 1024);
			final String memmessage2fancy = ChatColor.translateAlternateColorCodes('&', memmessage2raw);

			sender.sendMessage("" + memmessagefancy);
			sender.sendMessage("" + memmessage2fancy);

		} else {
			final String memnopermmessage1raw = "&7[&cMemory&7] &fYou do not have permission!";
			final String memnopermmessage1fancy = ChatColor.translateAlternateColorCodes('&', memnopermmessage1raw);
			sender.sendMessage(memnopermmessage1fancy);
		}
		return true; // magic :3
	}
}