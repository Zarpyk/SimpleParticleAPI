package guerrerocraft61.particleapi;

import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public final class ParticleAPI extends JavaPlugin {

	private static ParticleAPI plugin = null;
	public static boolean DebugMode;

	@Override
	public void onLoad() {
		plugin = this;
		DebugMode = false;
	}

	@Override
	public void onEnable() {
		Objects.requireNonNull(this.getCommand("particleapi")).setExecutor(new MainCommand());
		Objects.requireNonNull(this.getCommand("particleapi")).setTabCompleter(new MainCommandCompleter());
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public static ParticleAPI getPlugin() {
		return plugin;
	}

	public static void pointParticle(Location a, int setParticleID) {

	}

	public static void pointParticle(Location a, int timeInTick, int setParticleID) {

	}

	public static void getParticle(int ID) {

	}

	public static void consoleMsg(String text) {
		Bukkit.getConsoleSender().sendMessage(text);
	}

	public static void debug(String text) {
		if (DebugMode) {
			consoleMsg(Formatter.FText("&5[&bDEBUG&5] &e" + text));
		}
	}
}
