package ga.palomox.plugins.lucyblocks.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import ga.palomox.plugins.lucyblocks.LucyBlocks;

public class BackCommand implements CommandExecutor{
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if(sender instanceof Player player) {
			if(LucyBlocks.instance.getLastLoc().get(player) != null) {
				player.teleport(LucyBlocks.instance.getLastLoc().get(player));
			}else {
				player.sendMessage("Last death location is not stored.");
			}
			return true;
		}
		return false;
	}

}
