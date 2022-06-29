package ga.palomox.plugins.lucyblocks.luckyblocks;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class LuckyBlockManager {
	public void breakLuckyBlock(Location blockLocation, Player victim) {
		/*
		 * We check whether it's going to be a good or bad thing, on a 50% possiblilty
		 */
		if(ThreadLocalRandom.current().nextInt(101)<50) {
			// Something good happens
			int random = ThreadLocalRandom.current().nextInt(0, 1);
			switch(random) {
			case 0 -> {
				// We drop random items
				int material = ThreadLocalRandom.current().nextInt(0, Material.values().length);
				ItemStack stack = new ItemStack(Material.values()[material], ThreadLocalRandom.current().nextInt(1, 65));
				blockLocation.getWorld().dropItemNaturally(blockLocation, stack);
			}
			}
			
		} else {
			// Something bad happens.
			int random = ThreadLocalRandom.current().nextInt(0, 2);
			switch(random) {
			case 0 -> {
				// We kill the player
				victim.setHealth(0);
			}
			case 1 -> {
				// We spawn a random mob
				EntityType type = switch(ThreadLocalRandom.current().nextInt(0, 38)) {
				case 0 -> EntityType.BLAZE;
				case 1 -> EntityType.CAVE_SPIDER;
				case 2 -> EntityType.CREEPER;
				case 3 -> EntityType.DROWNED;
				case 4 -> EntityType.ELDER_GUARDIAN;
				case 5 -> EntityType.ENDER_DRAGON;
				case 6 -> EntityType.ENDERMAN;
				case 7 -> EntityType.EVOKER;
				case 8 -> EntityType.GHAST;
				case 9 -> EntityType.GIANT;
				case 10 -> EntityType.GUARDIAN;
				case 11 -> EntityType.HOGLIN;
				case 12 -> EntityType.HUSK;
				case 13 -> EntityType.ILLUSIONER;
				case 14 -> EntityType.MAGMA_CUBE;
				case 15 -> EntityType.PHANTOM;
				case 16 -> EntityType.PIGLIN;
				case 17 -> EntityType.PIGLIN_BRUTE;
				case 18 -> EntityType.PILLAGER;
				case 19 -> EntityType.PRIMED_TNT;
				case 20 -> EntityType.RAVAGER;
				case 21 -> EntityType.SHULKER;
				case 22 -> EntityType.SILVERFISH;
				case 23 -> EntityType.SKELETON;
				case 24 -> EntityType.SLIME;
				case 25 -> EntityType.SPIDER;
				case 26 -> EntityType.STRAY;
				case 27 -> EntityType.VEX;
				case 28 -> EntityType.VINDICATOR;
				case 29 -> EntityType.WARDEN;
				case 30 -> EntityType.WITCH;
				case 31 -> EntityType.WITHER_SKELETON;
				case 32 -> EntityType.WITHER;
				case 33 -> EntityType.ZOGLIN;
				case 34 -> EntityType.ZOMBIE;
				case 35 -> EntityType.ZOMBIE_VILLAGER;
				case 36 -> EntityType.ZOMBIFIED_PIGLIN;
				default -> throw new IllegalArgumentException("Unexpected value: " + ThreadLocalRandom.current().nextInt(0, 38));
				};
				blockLocation.getWorld().spawnEntity(blockLocation, type);
			}
			case 2 -> {
				// We strike a lightning on the player...
				victim.getLocation().getWorld().strikeLightning(victim.getLocation());
			}
			}
			
		}
		
	}
}
