package ga.palomox.plugins.lucyblocks;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import ga.palomox.plugins.lucyblocks.commands.BackCommand;
import ga.palomox.plugins.lucyblocks.commands.LuckyBlockCommand;
import ga.palomox.plugins.lucyblocks.events.LuckyBlockBreakListener;
import ga.palomox.plugins.lucyblocks.events.PlayerDieListener;
import ga.palomox.plugins.lucyblocks.luckyblocks.LuckyBlockManager;

public class LucyBlocks extends JavaPlugin{
	public static LucyBlocks instance; 
	private LuckyBlockManager manager;
	private HashMap<Player, Location> lastLoc; 
	
	@Override
	public void onEnable() {
		instance = this; 
		this.manager = new LuckyBlockManager();
		this.registerEvents();
		this.registerCommands();
		this.lastLoc = new HashMap<>();
	}

	public final HashMap<Player, Location> getLastLoc() {
		return lastLoc;
	}

	private void registerCommands() {
		this.getCommand("placeblock").setExecutor(new LuckyBlockCommand());
		this.getCommand("back").setExecutor(new BackCommand());
	}

	private void registerEvents() {
		this.getServer().getPluginManager().registerEvents(new LuckyBlockBreakListener(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerDieListener(), this);
	}

	public final LuckyBlockManager getManager() {
		return manager;
	}
}
