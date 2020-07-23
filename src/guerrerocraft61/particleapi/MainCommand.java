package guerrerocraft61.particleapi;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import guerrerocraft61.particleapi.particletypes.LineParticle;

public class MainCommand implements CommandExecutor {

	private final ParticleAPI plugin = ParticleAPI.getPlugin();
	boolean isPlayer;
	Player player;

	@Override
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
			case "twopointparticle":
				if (args.length < 15) {
					player.sendMessage(Formatter.FText("&c&lSome argument is missing"));
					return true;
				}
				Location location1 = new Location(player.getWorld(), Double.parseDouble(args[1]),
						Double.parseDouble(args[2]), Double.parseDouble(args[3]));
				Location location2 = new Location(player.getWorld(), Double.parseDouble(args[4]),
						Double.parseDouble(args[5]), Double.parseDouble(args[6]));
				if (args[1].equals(args[4]) && args[2].equals(args[5]) && args[3].equals(args[6])) {
					player.sendMessage(
							Formatter.FText("&c&lIs better use other method to spawn particle in same point"));
				}
				Particle particle = Particle.valueOf(args[7]);
				int count = Integer.parseInt(args[8]);
				double offsetX = Double.parseDouble(args[9]);
				double offsetY = Double.parseDouble(args[10]);
				double offsetZ = Double.parseDouble(args[11]);
				double speed = Double.parseDouble(args[12]);
				boolean forceShow = Boolean.parseBoolean(args[13]);
				long movementSpeed = Long.parseLong(args[14]);
				for (int i = 0; i < args.length; i++) {
					ParticleAPI.debug("Args " + i + ": " + args[i]);
				}
				new LineParticle(location1, location2, particle, count, offsetX, offsetY, offsetZ, speed, forceShow,
						movementSpeed);
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
		} else {
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
