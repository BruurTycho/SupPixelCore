package xyz.suppixel.SupPixelCore;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.inventivetalent.glow.GlowAPI;

public class CommandGlowRainbowAdmin implements CommandExecutor {
	SupPixelCore plugin; // make a variable that is actually just the plugin
							// (main class) (y)

	private final static GlowAPI.Color[] RAINBOW_COLORS = new GlowAPI.Color[] { GlowAPI.Color.GOLD, GlowAPI.Color.RED,
			GlowAPI.Color.WHITE, GlowAPI.Color.YELLOW }; // Put your colors
															// here.

	public CommandGlowRainbowAdmin(SupPixelCore plugin) {
		this.plugin = plugin;
	}
	public List<String> players = new ArrayList<String>();
	
	public void toggleGlow(Player player){
		
		if(players.contains(player.getName())){
			players.remove(player.getName());
		}else{
			players.add(player.getName());
		}
	}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (!sender.hasPermission("suppixel.glowrainbowadmin")) { // if the
            // sender
            // DOESNT
            // have permissions
            sender.sendMessage("u haz no permz");
            return true;
        }
        if (sender instanceof Player) {

        	toggleGlow(player);
            BukkitRunnable runnable = new BukkitRunnable() {

                int step = 0;
            	
                @Override
                public void run() {

                    if(players.contains(player.getName())) {
                        
                        plugin.getServer().getLogger().info(player.getName() + " has toggled off!");
                        cancel();
                    }else{

                        GlowAPI.Color color = null;

                        if (step >= RAINBOW_COLORS.length)
                            step = 0;

                        color = RAINBOW_COLORS[step];

                        GlowAPI.setGlowing(player, color, player);
                        System.out.println("kleurtje " + color);
                        System.out.println("players array" + players);
                        step++;
                        plugin.getServer().getLogger().info(player.getName() + " has toggled on!");



                    }
                }
            };
            runnable.runTaskTimer(plugin, 0L, 10L);
        }
        return false;
    }
}