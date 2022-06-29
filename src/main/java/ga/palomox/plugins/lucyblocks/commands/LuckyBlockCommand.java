package ga.palomox.plugins.lucyblocks.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.jetbrains.annotations.NotNull;

import ga.palomox.plugins.lucyblocks.LucyBlocks;

public class LuckyBlockCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
			@NotNull String[] args) {
		if(sender instanceof Player player) {
			if(!sender.isOp()) {
				return false; 
			}
			BlockData data = Bukkit.getServer().createBlockData(Material.SPONGE);
			Location blockLocation = player.getLocation();
			player.getLocation().getWorld().setBlockData(player.getLocation(), data);
			BlockState state = blockLocation.getBlock().getState();
			state.setMetadata("luckyblock", new FixedMetadataValue(LucyBlocks.instance,  true));
			state.update();
			return true;
		}
		return false; 
	}

}
