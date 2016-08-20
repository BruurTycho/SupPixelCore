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
			
			Block block0 = player.getLocation().subtract(0, 1, 0).getBlock();
			block0.setType(Material.TNT); // under
			
			Block block1 = player.getLocation().subtract(0, 1, 1).getBlock();
			block1.setType(Material.TNT); // under +1 z
			
			Block block2 = player.getLocation().subtract(0, 1, -1).getBlock();
			block2.setType(Material.TNT); // under -1 z
			
			Block block3 = player.getLocation().subtract(1, 1, 0).getBlock();
			block3.setType(Material.TNT); // under +1 x
			
			Block block4 = player.getLocation().subtract(-1, 1, 0).getBlock();
			block4.setType(Material.TNT); // under -1 x
			
			Block block5 = player.getLocation().subtract(1, 1, -1).getBlock();
			block5.setType(Material.TNT); // under +1 x & -1 z
			
			Block block6 = player.getLocation().subtract(1, 1, 1).getBlock();
			block6.setType(Material.TNT); // under +1 x & + 1 z
			
			Block block7 = player.getLocation().subtract(-1, 1, -1).getBlock();
			block7.setType(Material.TNT); // under -1 x & -1 z
			
			Block block8 = player.getLocation().subtract(-1, 1, 1).getBlock();
			block8.setType(Material.TNT); // under -1 x & + 1 z
			
			
			

		return true;
	}
		return false;
}
}