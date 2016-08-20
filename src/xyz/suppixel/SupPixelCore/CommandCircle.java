package xyz.suppixel.SupPixelCore;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCircle implements CommandExecutor {
	SupPixelCore plugin; // make a variable that is actually just the plugin
							// (main class) (y)

	public CommandCircle(SupPixelCore plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!sender.hasPermission("suppixel.circle")) { // if the sender DOESNT
														// have permissions
			sender.sendMessage("u haz no permz");
			return true;
		} if (sender instanceof Player) {
			Player player = ((Player) sender).getPlayer();
			
			for (int i = 0; i < 100; i += 4) {
				Block block = player.getLocation().subtract(0, 1, i).getBlock();	
				block.setType(Material.TNT);
			}
			
			

		return true;
	}
		return false;
}
}