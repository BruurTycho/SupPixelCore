package xyz.suppixel.SupPixelCore;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.github.cheesesoftware.PowerfulPermsAPI.PermissionManager;
import com.github.cheesesoftware.PowerfulPermsAPI.PermissionPlayer;
import com.github.cheesesoftware.PowerfulPermsAPI.PowerfulPermsPlugin;
import com.github.cheesesoftware.PowerfulPermsAPI.ResultRunnable;

public class CommandCustomUsername implements CommandExecutor {
	SupPixelCore plugin; // make a variable that is actually just the plugin
							// (main class) (y)

	public CommandCustomUsername(SupPixelCore plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		final PowerfulPermsPlugin plugin = (PowerfulPermsPlugin) Bukkit.getPluginManager().getPlugin("PowerfulPerms");
		final PermissionManager permissionManager = plugin.getPermissionManager();

		if (!sender.hasPermission("suppixel.getprefix")) { // if the sender
															// DOESNT have
															// permissions
			sender.sendMessage("u haz no permz (No permission)");
			return true;
		}
		if (sender instanceof Player) {
			final Player player = (Player) sender;
			player.setVelocity(new Vector(0, 2, 0));
			final UUID uuid = player.getUniqueId(); // kan nog wat bij lol

			permissionManager.getPlayerPrefix(uuid, new ResultRunnable<String>() {
				
				PermissionPlayer permissionPlayer = permissionManager.getPermissionPlayer(uuid);				
				String DonatorsPrefix = permissionPlayer.getPrefix("Donators");
				
				String StaffPrefix = permissionPlayer.getPrefix("Staff");

				@Override
				public void run() {
					// This function is run synchronously when the action is
					// finished.
					// The prefix is in the variable called "result"

					final String getprefixmessage1raw = "&7[&cRanks&7] &aPrefix: " + StaffPrefix + " " + DonatorsPrefix;
					final String getprefixmessage1fancy = ChatColor.translateAlternateColorCodes('&', getprefixmessage1raw);

					sender.sendMessage("" + getprefixmessage1fancy);
				}

			});

			return true;
		} else {
			sender.sendMessage("ur nut alive. u zumbie? (Not player)");
			return true;
		}
	}

}
