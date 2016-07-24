package xyz.suppixel.SupPixelCore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import xyz.suppixel.SupPixelCore.SupPixelCore;

public class CommandSpawn implements CommandExecutor {
	SupPixelCore plugin; // make a variable that is actually just the plugin (main class) (y)
	
	public CommandSpawn(SupPixelCore plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!sender.hasPermission("suppixel.spawn")) { // if the sender DOESNT have permissions
			sender.sendMessage("u haz no permz");
			return true;
		}
		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.teleport(player.getWorld().getSpawnLocation());
			return true;
		} else {
			sender.sendMessage("ur nut alive. u zumbie?");
			return true;
		}
	}

}
