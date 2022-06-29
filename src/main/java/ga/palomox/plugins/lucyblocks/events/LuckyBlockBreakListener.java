package ga.palomox.plugins.lucyblocks.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import ga.palomox.plugins.lucyblocks.LucyBlocks;


public class LuckyBlockBreakListener implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		if(block.getBlockData().getMaterial().compareTo(Material.SPONGE) == 0) {
			BlockState data = block.getState();
			
		
			var dataValues = data.getMetadata("luckyblock");
			if(dataValues.get(0).asBoolean()) {
			event.setDropItems(false);
			LucyBlocks.instance.getManager().breakLuckyBlock(block.getLocation(), event.getPlayer());
			}
			
		}
	}
}
