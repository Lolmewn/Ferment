package nl.lolmewn;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public HashSet<Material> checked = new HashSet<Material>();
	public HashMap<Location, Integer> counter = new HashMap<Location, Integer>();

	public void onDisable() {
		
	}

	public void onEnable() {
		checked.add(Material.PUMPKIN);
		checked.add(Material.SEEDS);
		checked.add(Material.SUGAR_CANE);
		checked.add(Material.MELON);
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_BREAK, new FBlock(this), Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_INTERACT, new FPlay(this), Priority.Normal, this);
	}
	
	public class FBlock extends BlockListener{
		public Main plugin;
		public FBlock(Main main) {
			plugin = main;
		}
		
		@Override
		public void onBlockBreak(BlockBreakEvent event){
			Player p = event.getPlayer();
			Block b = event.getBlock();
			if(checked.contains(b.getType())){
				if(counter.containsKey(b.getLocation())){
					int already = counter.get(b.getLocation());
				}
			}
		}
		
	}
	
	public class FPlay extends PlayerListener{
		public Main plugin;
		public FPlay(Main main) {
			plugin = main;
		}
		
		@Override
		public void onPlayerInteract(PlayerInteractEvent event){
			
		}
		
	}

}
