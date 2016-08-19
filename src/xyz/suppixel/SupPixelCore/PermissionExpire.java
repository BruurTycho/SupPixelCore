package xyz.suppixel.SupPixelCore;

import com.github.cheesesoftware.PowerfulPermsAPI.PlayerPermissionExpiredEvent;
import com.github.cheesesoftware.PowerfulPermsAPI.PowerfulEvent;
import com.github.cheesesoftware.PowerfulPermsAPI.PowerfulPermsListener;

public class PermissionExpire implements PowerfulPermsListener {
	SupPixelCore plugin; // make the variable that is actually just the plugin

	public PermissionExpire(SupPixelCore plugin) {
		this.plugin = plugin;
	}


	@PowerfulEvent
	public void onPlayerPermissionExpire(PlayerPermissionExpiredEvent event) {
		boolean IsItSleepyTime = false;
		System.out.println(IsItSleepyTime);
		String permission = event.getPermission().getPermissionString();
		
		plugin.getServer().broadcastMessage("§7[§cPerms§7] §c" +  permission + " §fhas expired for §c" + event.getPlayerUUID());
	}
}