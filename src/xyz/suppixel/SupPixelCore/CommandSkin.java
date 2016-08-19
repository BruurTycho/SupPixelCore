package xyz.suppixel.SupPixelCore;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class CommandSkin implements CommandExecutor {
	SupPixelCore plugin; // make a variable that is actually just the plugin
							// (main class) (y)

	public CommandSkin(SupPixelCore plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!sender.hasPermission("suppixel.skin")) { // if the sender DOESNT
														// have permissions
			sender.sendMessage("u haz no permz");
			return true;
		} if (sender instanceof Player) {
			System.out.println("okay, doing skin shit");
			Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Skin Selector");
			
			ItemStack skin1 = new ItemStack (Material.DIAMOND_CHESTPLATE);
			ItemMeta skin1Meta = skin1.getItemMeta();
			
			skin1Meta.setDisplayName(org.bukkit.ChatColor.DARK_RED + "notch");
			skin1.setItemMeta(skin1Meta);
			
			inv.setItem(3, skin1);
			
			((Player) sender).openInventory(inv);
		return true;
	}
		return false;
}
}