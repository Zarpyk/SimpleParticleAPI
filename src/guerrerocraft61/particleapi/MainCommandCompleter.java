package guerrerocraft61.particleapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class MainCommandCompleter implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

		if (args.length == 1) {
			List<String> subcommands = new ArrayList<>();
			subcommands.add("pointparticle");
			subcommands.add("twopointparticle");
			subcommands.add("debug");
			return subcommands;
		}
		if (args.length > 1) {
			if (args[0].equals("pointparticle")) {
				Player player = (Player) sender;
				Block targ = player.getTargetBlock((Set<Material>) null, 5);
				switch (args.length) {
				case 1:
					return Collections.singletonList(targ.getX() + "");
				case 2:
					return Collections.singletonList(targ.getY() + "");
				case 3:
					return Collections.singletonList(targ.getZ() + "");
				}
				return null;
			} else if (args[0].equals("twopointparticle")) {
				Player player = (Player) sender;
				Block targ = player.getTargetBlock((Set<Material>) null, 5);
				switch (args.length) {
				case 2:
				case 5:
					return Collections.singletonList(targ.getX() + "");
				case 3:
				case 6:
					return Collections.singletonList(targ.getY() + "");
				case 4:
				case 7:
					return Collections.singletonList(targ.getZ() + "");
				case 8:
					return particleList();
				case 9:
					return numberList();
				case 10:
					List<String> x = new ArrayList<>();
					x.add("offSetX");
					return x;
				case 11:
					List<String> y = new ArrayList<>();
					y.add("offSetY");
					return y;
				case 12:
					List<String> z = new ArrayList<>();
					z.add("offSetZ");
					return z;
				case 13:
					List<String> speed = new ArrayList<>();
					speed.add("speed");
					return speed;
				case 14:
					List<String> forceShow = new ArrayList<>();
					forceShow.add("true");
					forceShow.add("false");
					forceShow.add("forceShow");
					return forceShow;
				case 15:
					List<String> movementSpeed = new ArrayList<>();
					movementSpeed.add("movementSpeed");
					return movementSpeed;
				}
				return null;
			}

		}
		return null;
	}

	public List<String> particleList() {
		List<String> stringList = new ArrayList<>();
		for (Object string : Particle.class.getEnumConstants()) {
			stringList.add(string.toString());
		}
		return stringList;
		/*String[] particles = new String[] {
				"ASH",
				"BARRIER"
				"BLOCK_CRACK"
				"BLOCK_DUST"
				"BUBBLE_COLUMN_UP"
				"BUBBLE_POP"
				"CAMPFIRE_COSY_SMOKE"
				"CAMPFIRE_SIGNAL_SMOKE"
				"CLOUD"
				"COMPOSTER"
				"CRIMSON_SPORE"
				"CRIT"
				"CRIT_MAGIC"
				"CURRENT_DOWN"
				"DAMAGE_INDICATOR"
				"DOLPHIN"
				"DRAGON_BREATH"
				"DRIP_LAVA"
				"DRIP_WATER"
				"DRIPPING_HONEY"
				"DRIPPING_OBSIDIAN_TEAR"
				"ENCHANTMENT_TABLE"
				"END_ROD"
				"EXPLOSION_HUGE"
				"EXPLOSION_LARGE"
				"EXPLOSION_NORMAL"
				"FALLING_DUST"
				"FALLING_HONEY"
				"FALLING_LAVA"
				"FALLING_NECTAR"
				"FALLING_OBSIDIAN_TEAR"
				"FALLING_WATER"
				"FIREWORKS_SPARK"
				"FLAME"
				"FLASH"
				"HEART"
				"ITEM_CRACK"
				"LANDING_HONEY"
				LANDING_LAVA
				LANDING_OBSIDIAN_TEAR
				LAVA
				LEGACY_BLOCK_CRACK
				LEGACY_BLOCK_DUST
				LEGACY_FALLING_DUST
				MOB_APPEARANCE
				NAUTILUS
				NOTE
				PORTAL
				REDSTONE
				REVERSE_PORTAL
				SLIME
				SMOKE_LARGE
				SMOKE_NORMAL
				SNEEZE
				SNOW_SHOVEL
				SNOWBALL
				SOUL
				SOUL_FIRE_FLAME
				SPELL
				SPELL_INSTANT
				SPELL_MOB
				SPELL_MOB_AMBIENT
				SPELL_WITCH
				SPIT
				SQUID_INK
				SUSPENDED
				SUSPENDED_DEPTH
				SWEEP_ATTACK
				TOTEM
				TOWN_AURA
				VILLAGER_ANGRY
				VILLAGER_HAPPY
				WARPED_SPORE
				WATER_BUBBLE
				WATER_DROP
				WATER_SPLASH
				WATER_WAKE
				WHITE_ASH
		}*/
	}

	private List<String> numberList() {
		List<String> stringList = new ArrayList<>();
		for (int string : new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 }) {
			stringList.add(Integer.toString(string));
		}
		stringList.add("count");
		return stringList;
	}

}
