package guerrerocraft61.particleapi;

import java.util.Objects;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import guerrerocraft61.particleapi.particletypes.LineParticle;

public class MainCommand implements CommandExecutor {

	private final ParticleAPI plugin = ParticleAPI.getPlugin();
	boolean isPlayer;
	Player player;

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			isPlayer = true;
			player = (Player) sender;
		} else {
			ParticleAPI.consoleMsg(Formatter.FText("&c&lThis command is only for players"));
			return true;
		}
		if (args.length > 0) {
			switch (args[0].toLowerCase()) {
			case "pointparticle":
				player.sendMessage(Formatter.FText("&c&lNot available"));
				return true;
			case "lineparticle":
				if (args.length < 15) {
					player.sendMessage(Formatter.FText("&c&lSome argument is missing"));
					return true;
				} else if (args.length > 15 && !args[7].equals("BLOCK_CRACK") && !args[7].equals("BLOCK_DUST")
						&& !args[7].equals("ITEM_CRACK") && !args[7].equals("REDSTONE")) {
					player.sendMessage(Formatter.FText("&c&lSome argument is not necessary"));
					return true;
				}
				Location location1;
				Location location2;
				try {
					location1 = new Location(player.getWorld(), Double.parseDouble(args[1]),
							Double.parseDouble(args[2]), Double.parseDouble(args[3]));
					location2 = new Location(player.getWorld(), Double.parseDouble(args[4]),
							Double.parseDouble(args[5]), Double.parseDouble(args[6]));
				} catch (NumberFormatException e) {
					player.sendMessage(
							Formatter.FText("&c&lWrong Coords! You need use numbers (don't recommended use decimal)!"));
					return true;
				}
				if (args[1].equals(args[4]) && args[2].equals(args[5]) && args[3].equals(args[6])) {
					player.sendMessage(
							Formatter.FText("&c&lIs better use other method to spawn particle in same point"));
					return true;
				}
				Particle particle;
				try {
					particle = Particle.valueOf(args[7]);
				} catch (EnumConstantNotPresentException e) {
					player.sendMessage(Formatter.FText("&c&lThis particle don't exist"));
					return true;
				}
				if (args[7].equals("BLOCK_CRACK") || args[7].equals("BLOCK_DUST") || args[7].equals("FALLING_DUST")
						|| args[7].equals("ITEM_CRACK")) {
					if (args.length < 16) {
						ParticleAPI.debug("1" + args.length);
						player.sendMessage(Formatter.FText("&c&lSome argument is missing, this effect require data."));
						return true;
					} else if (args.length > 16) {
						ParticleAPI.debug("1" + args.length);
						player.sendMessage(Formatter.FText("&c&lSome argument is not necessary"));
						return true;
					}
				} else if (args[7].equals("REDSTONE")) {
					if (args.length < 19) {
						ParticleAPI.debug("2" + args.length);
						player.sendMessage(Formatter.FText("&c&lSome argument is missing, this effect require data."));
						return true;
					} else if (args.length > 19) {
						ParticleAPI.debug("2" + args.length);
						player.sendMessage(Formatter.FText("&c&lSome argument is not necessary"));
						return true;
					}
				}
				int count;
				try {
					count = Integer.parseInt(args[8]);
				} catch (NumberFormatException e) {
					player.sendMessage(Formatter.FText("&c&lWrong Count! You need use numbers (can't be decimal)!"));
					return true;
				}
				double offsetX;
				try {
					offsetX = Double.parseDouble(args[9]);
				} catch (NumberFormatException e) {
					player.sendMessage(Formatter.FText("&c&lWrong offsetX! You need use numbers (can be decimal)!"));
					return true;
				}
				double offsetY;
				try {
					offsetY = Double.parseDouble(args[10]);
				} catch (NumberFormatException e) {
					player.sendMessage(Formatter.FText("&c&lWrong offsetY! You need use numbers (can be decimal)!"));
					return true;
				}
				double offsetZ;
				try {
					offsetZ = Double.parseDouble(args[11]);
				} catch (NumberFormatException e) {
					player.sendMessage(Formatter.FText("&c&lWrong offsetZ! You need use numbers (can be decimal)!"));
					return true;
				}
				double speed;
				try {
					speed = Double.parseDouble(args[12]);
				} catch (NumberFormatException e) {
					player.sendMessage(Formatter.FText("&c&lWrong Speed! You need use numbers (can be decimal)!"));
					return true;
				}
				boolean forceShow;
				if (args[13].equals("true") || args[13].equals("false")) {
					forceShow = Boolean.parseBoolean(args[13]);
				} else {
					player.sendMessage(Formatter.FText("&c&lWrong ForceShow! You must use \"true\" or \"false\"!"));
					return true;
				}
				long movementSpeed;
				try {
					movementSpeed = Long.parseLong(args[14]);
				} catch (NumberFormatException e) {
					player.sendMessage(Formatter
							.FText("&c&lWrong Movement Speed (ticks)! You need use numbers (can't be decimal)!"));
					return true;
				}
				for (int i = 0; i < args.length; i++) {
					ParticleAPI.debug("Args " + i + ": " + args[i]);
				}
				if (args.length == 16) {
					switch (args[7]) {
					case "BLOCK_CRACK":
					case "BLOCK_DUST":
					case "FALLING_DUST":
						new LineParticle(location1, location2, particle, count, offsetX, offsetY, offsetZ, speed,
								forceShow, movementSpeed,
								Objects.requireNonNull(Material.getMaterial(args[15])).createBlockData());
					case "ITEM_CRACK":
						new LineParticle(location1, location2, particle, count, offsetX, offsetY, offsetZ, speed,
								forceShow, movementSpeed,
								new ItemStack(Objects.requireNonNull(Material.getMaterial(args[15]))));
					}
				} else if (args.length == 19) {
					if (args[7].equals("REDSTONE")) {
						new LineParticle(location1, location2, particle, count, offsetX, offsetY, offsetZ, speed,
								forceShow, movementSpeed,
								new Particle.DustOptions(Color.fromRGB(Integer.parseInt(args[15]),
										Integer.parseInt(args[16]), Integer.parseInt(args[17])),
										Float.parseFloat(args[18])));
					}
				} else if (args.length == 15) {
					new LineParticle(location1, location2, particle, count, offsetX, offsetY, offsetZ, speed, forceShow,
							movementSpeed);
				}
				return true;
			case "debug":
				if (ParticleAPI.DebugMode) {
					ParticleAPI.DebugMode = false;
					player.sendMessage(Formatter.FText("&c&lDebug Mode Off", true, player));
				} else {
					ParticleAPI.DebugMode = true;
					player.sendMessage(Formatter.FText("&a&lDebug Mode On", true, player));
				}
				return true;
			default:
				SendHelp();
				return true;
			}
		} else

		{
			SendHelp();
			return true;
		}
	}

	private void SendHelp() {
		String[] helpMsg = new String[] { "&a-----------------&c&lParticleAPI&a-----------------",
				"&6/particleapi pointparticle", "&6/particleapi twopointparticle", "&6/particleapi debug",
				"&a------------------------------------------" };

		if (isPlayer) {
			for (String s : helpMsg) {
				player.sendMessage(Formatter.FText(s, true, player));
			}
		} else {
			for (String s : helpMsg) {
				ParticleAPI.consoleMsg(Formatter.FText(s, true));
			}
		}
	}
}
