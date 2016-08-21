package xyz.suppixel.SupPixelCore;

import java.util.Random;

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
//		if (!sender.hasPermission("suppixel.circle")) { // if the sender DOESNT
//														// have permissions
//			sender.sendMessage("u haz no permz");
//			return true;
//		}
		
		if (sender instanceof Player) {
			Player player = ((Player) sender).getPlayer();
			
			Random r = new Random();
			for (int i = 0; i < 16; i += r.nextInt(5)) {
				for (int y = 0; y != 1; y++) {
					for (int z = 0; z != 16; z++) {
						Block block = player.getLocation().subtract(i, y + 2, z + i).getBlock();
						block.setType(Material.IRON_BLOCK);
						
						Block b2 = player.getLocation().subtract(-i, y + 2, z - i).getBlock();
						b2.setType(Material.STONE);
						
						Block b3 = player.getLocation().subtract(i, y + 2, z * i / 16).getBlock();
						b3.setType(Material.REDSTONE_BLOCK);
						
						Block b4 = player.getLocation().subtract(-i, y + 2, z * i / 16).getBlock();
						b4.setType(Material.GLOWSTONE);
					}
				}
			}

			return true;
		}
		return false;
	}
}