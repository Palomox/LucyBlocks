package ga.palomox.plugins.lucyblocks.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import ga.palomox.plugins.lucyblocks.LucyBlocks;

public class PlayerDieListener implements Listener{
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player player = event.getPlayer();
		Location death = player.getLocation();
		
		LucyBlocks.instance.getLastLoc().put(player, death);
	}
}
