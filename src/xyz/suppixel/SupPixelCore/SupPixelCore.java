package xyz.suppixel.SupPixelCore;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.cheesesoftware.PowerfulPermsAPI.PermissionManager;
import com.github.cheesesoftware.PowerfulPermsAPI.PowerfulPermsPlugin;

public class SupPixelCore extends JavaPlugin implements Listener {
	
	
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new EnderPearlRider(this), this);
		getServer().getPluginManager().registerEvents(new SkyblockFly(this), this);
		getLogger().info("onEnabled, done.");
		getCommand("spawn").setExecutor(new CommandSpawn(this)); // this = SupPixelCore --- CommandSpawn = CommandSpawn Class
		getCommand("mem").setExecutor(new CommandMem(this));
		getCommand("getprefix").setExecutor(new CommandGetPrefix(this));
		getCommand("sun").setExecutor(new CommandSun(this));
		getCommand("day").setExecutor(new CommandDay(this));
		getCommand("glowrainbow").setExecutor(new CommandGlowRainbow(this));
		getCommand("glowrainbowadmin").setExecutor(new CommandGlowRainbowAdmin(this));
	}
	
	@Override
	public void onDisable() {
		// nuthing
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.setJoinMessage(null);
	}
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		event.setQuitMessage(null);
	}
	
	PowerfulPermsPlugin plugin = (PowerfulPermsPlugin) Bukkit.getPluginManager().getPlugin("PowerfulPerms");
	PermissionManager permissionManager = plugin.getPermissionManager();
}
