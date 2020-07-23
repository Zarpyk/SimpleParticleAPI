package guerrerocraft61.particleapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
				Block targ = player.getTargetBlock(null, 5);
				switch (args.length) {
				case 2:
					return Collections.singletonList(targ.getX() + "");
				case 3:
					return Collections.singletonList(targ.getY() + "");
				case 4:
					return Collections.singletonList(targ.getZ() + "");
				}
				return null;
			} else if (args[0].equals("lineparticle")) {
				Player player = (Player) sender;
				Block targ = player.getTargetBlock(null, 5);
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
					List<String> count = new ArrayList<>();
					count.add("Count");
					return count;
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
					speed.add("Speed");
					return speed;
				case 14:
					List<String> forceShow = new ArrayList<>();
					forceShow.add("true");
					forceShow.add("false");
					forceShow.add("ForceShow");
					return forceShow;
				case 15:
					List<String> movementSpeed = new ArrayList<>();
					movementSpeed.add("movementSpeed");
					return movementSpeed;
				case 16:
					switch (args[7]) {
					case "BLOCK_CRACK":
					case "BLOCK_DUST":
					case "FALLING_DUST":
						return blockList();
					case "ITEM_CRACK":
						return itemList();
					case "REDSTONE":
						List<String> colorRed = numberList();
						colorRed.add("RedColor");
						return colorRed;
					}
				case 17:
					if (args[7].equals("REDSTONE")) {
						List<String> colorGreen = numberList();
						colorGreen.add("GreenColor1-255");
						return colorGreen;
					}
				case 18:
					if (args[7].equals("REDSTONE")) {
						List<String> colorBlue = numberList();
						colorBlue.add("BlueColor1-255");
						return colorBlue;
					}
				case 19:
					if (args[7].equals("REDSTONE")) {
						List<String> colorBlue = numberList();
						colorBlue.add("Size");
						return colorBlue;
					}
				}
				return null;
			}
		}
		return null;
	}

	public List<String> particleList() {
		List<String> stringList = new ArrayList<>();
		for (Object object : Particle.class.getEnumConstants()) {
			stringList.add(object.toString());
		}
		return stringList;
	}

	public List<String> blockList() {
		List<String> stringList = new ArrayList<>();
		for (Object object : Material.class.getEnumConstants()) {
			if (Objects.requireNonNull(Material.getMaterial(object.toString())).isBlock()) {
				stringList.add(object.toString());
			}
		}
		return stringList;
	}

	public List<String> itemList() {
		List<String> stringList = new ArrayList<>();
		for (Object object : Material.class.getEnumConstants()) {
			if (Objects.requireNonNull(Material.getMaterial(object.toString())).isItem()) {
				stringList.add(object.toString());
			}
		}
		return stringList;
	}

	private List<String> numberList() {
		List<String> stringList = new ArrayList<>();
		for (int i = 0; i < 255; i++) {
			stringList.add(Integer.toString(i));
		}
		return stringList;
	}

}
