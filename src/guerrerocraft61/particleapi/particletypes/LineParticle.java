package guerrerocraft61.particleapi.particletypes;

import java.util.Objects;

import javax.annotation.Nullable;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import guerrerocraft61.particleapi.Formatter;
import guerrerocraft61.particleapi.ParticleAPI;
import guerrerocraft61.particleapi.VectorMath;

public class LineParticle {
	public Location a;
	public Location b;
	public Particle particle;
	public int count;
	public double offsetX;
	public double offsetY;
	public double offsetZ;
	public double speed;
	public long movementSpeed;
	public boolean forceShow;
	public String materialName;
	public Color particleColor;
	public int size;

	/**
	 * Default offset = 0
	 * Default speed = 0.1
	 * Default forceShow = false
	 * Default movementSpeed = 0
	 * 
	 * @param a        The first location
	 * @param b        The second location
	 * @param particle Particle type
	 * @param count    Particle count
	 */
	public LineParticle(Location a, Location b, Particle particle, int count) {
		setVariables(a, b, particle, count, 0, 0, 0, 0.1, false, 0);
		spawnParticle();
	}

	/**
	 * Default speed = 0.1
	 * Default forceShow = false
	 * Default movementSpeed = 0
	 * 
	 * @param a        The first location
	 * @param b        The second location
	 * @param particle Particle type
	 * @param count    Particle count
	 * @param offsetX  The maximum random offset on the X axis
	 * @param offsetY  The maximum random offset on the Y axis
	 * @param offsetZ  The maximum random offset on the Z axis
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double offsetX, double offsetY,
			double offsetZ) {
		setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, 0.1, false, 0);
		spawnParticle();
	}

	/**
	 * Default forceShow = false
	 * Default movementSpeed = 0
	 * 
	 * @param a        The first location
	 * @param b        The second location
	 * @param particle Particle type
	 * @param count    Particle count
	 * @param offsetX  The maximum random offset on the X axis
	 * @param offsetY  The maximum random offset on the Y axis
	 * @param offsetZ  The maximum random offset on the Z axis
	 * @param speed    Every particle speed
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double offsetX, double offsetY,
			double offsetZ, double speed) {
		setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, speed, false, 0);
		spawnParticle();
	}

	/**
	 * Default movementSpeed = 0
	 * 
	 * @param a         The first location
	 * @param b         The second location
	 * @param particle  Particle type
	 * @param count     Particle count
	 * @param offsetX   The maximum random offset on the X axis
	 * @param offsetY   The maximum random offset on the Y axis
	 * @param offsetZ   The maximum random offset on the Z axis
	 * @param speed     Every particle speed
	 * @param forceShow Show particle when the player is far (256 blocks max.)
	 *                  and when player have minimal particle settings
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double offsetX, double offsetY,
			double offsetZ, double speed, boolean forceShow) {
		setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, speed, forceShow, 0);
		spawnParticle();
	}

	/**
	 * Default forceShow = false
	 * 
	 * @param a             The first location
	 * @param b             The second location
	 * @param particle      Particle type
	 * @param count         Particle count
	 * @param offsetX       The maximum random offset on the X axis
	 * @param offsetY       The maximum random offset on the Y axis
	 * @param offsetZ       The maximum random offset on the Z axis
	 * @param speed         Every particle speed
	 * @param movementSpeed The speed in tick to spawn every particle
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double offsetX, double offsetY,
			double offsetZ, double speed, long movementSpeed) {
		setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, speed, false, movementSpeed);
		spawnParticle();
	}

	/**
	 * Default speed = 0.1
	 * 
	 * @param a             The first location
	 * @param b             The second location
	 * @param particle      Particle type
	 * @param count         Particle count
	 * @param offsetX       The maximum random offset on the X axis
	 * @param offsetY       The maximum random offset on the Y axis
	 * @param offsetZ       The maximum random offset on the Z axis
	 * @param forceShow     Show particle when the player is far (256 blocks max.)
	 *                      and when player have minimal particle settings
	 * @param movementSpeed The speed in tick to spawn every particle
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double offsetX, double offsetY,
			double offsetZ, boolean forceShow, long movementSpeed) {
		setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, 0.1, forceShow, movementSpeed);
		spawnParticle();
	}

	/**
	 * Default speed = 0.1
	 * Default forceShow = false
	 * 
	 * @param a             The first location
	 * @param b             The second location
	 * @param particle      Particle type
	 * @param count         Particle count
	 * @param offsetX       The maximum random offset on the X axis
	 * @param offsetY       The maximum random offset on the Y axis
	 * @param offsetZ       The maximum random offset on the Z axis
	 * @param movementSpeed The speed in tick to spawn every particle
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double offsetX, double offsetY,
			double offsetZ, long movementSpeed) {
		setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, 0.1, false, movementSpeed);
		spawnParticle();
	}

	/**
	 * Default speed = 0.1
	 * Default movementSpeed = 0
	 * 
	 * @param a         The first location
	 * @param b         The second location
	 * @param particle  Particle type
	 * @param count     Particle count
	 * @param offsetX   The maximum random offset on the X axis
	 * @param offsetY   The maximum random offset on the Y axis
	 * @param offsetZ   The maximum random offset on the Z axis
	 * @param forceShow Show particle when the player is far (256 blocks max.)
	 *                  and when player have minimal particle settings
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double offsetX, double offsetY,
			double offsetZ, boolean forceShow) {
		setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, 0.1, forceShow, 0);
		spawnParticle();
	}

	/**
	 * Default offset = 0
	 * 
	 * @param a             The first location
	 * @param b             The second location
	 * @param particle      Particle type
	 * @param count         Particle count
	 * @param speed         Every particle speed
	 * @param forceShow     Show particle when the player is far (256 blocks max.)
	 *                      and when player have minimal particle settings
	 * @param movementSpeed The speed in tick to spawn every particle
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double speed, boolean forceShow,
			long movementSpeed) {
		setVariables(a, b, particle, count, 0, 0, 0, speed, forceShow, movementSpeed);
		spawnParticle();
	}

	/**
	 * Default offset = 0
	 * Default movementSpeed = 0
	 * 
	 * @param a         The first location
	 * @param b         The second location
	 * @param particle  Particle type
	 * @param count     Particle count
	 * @param speed     Every particle speed
	 * @param forceShow Show particle when the player is far (256 blocks max.)
	 *                  and when player have minimal particle settings
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double speed, boolean forceShow) {
		setVariables(a, b, particle, count, 0, 0, 0, speed, forceShow, 0);
		spawnParticle();
	}

	/**
	 * Default offset = 0
	 * Default forceShow = false
	 * 
	 * @param a             The first location
	 * @param b             The second location
	 * @param particle      Particle type
	 * @param count         Particle count
	 * @param speed         Every particle speed
	 * @param movementSpeed The speed in tick to spawn every particle
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double speed, long movementSpeed) {
		setVariables(a, b, particle, count, 0, 0, 0, speed, false, movementSpeed);
		spawnParticle();
	}

	/**
	 * Default offset = 0
	 * Default speed = 0.1
	 * 
	 * @param a             The first location
	 * @param b             The second location
	 * @param particle      Particle type
	 * @param count         Particle count
	 * @param forceShow     Show particle when the player is far (256 blocks max.)
	 *                      and when player have minimal particle settings
	 * @param movementSpeed The speed in tick to spawn every particle
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, boolean forceShow, long movementSpeed) {
		setVariables(a, b, particle, count, 0, 0, 0, 0.1, forceShow, movementSpeed);
		spawnParticle();
	}

	/**
	 * Default offset = 0
	 * Default forceShow = false
	 * Default movementSpeed = 0
	 * 
	 * @param a        The first location
	 * @param b        The second location
	 * @param particle Particle type
	 * @param count    Particle count
	 * @param speed    Every particle speed
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double speed) {
		setVariables(a, b, particle, count, 0, 0, 0, speed, false, 0);
		spawnParticle();
	}

	/**
	 * Default offset = 0
	 * Default speed = 0.1
	 * Default forceShow = false
	 * 
	 * @param a             The first location
	 * @param b             The second location
	 * @param particle      Particle type
	 * @param count         Particle count
	 * @param movementSpeed The speed in tick to spawn every particle
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, long movementSpeed) {
		setVariables(a, b, particle, count, 0, 0, 0, 0.1, false, movementSpeed);
		spawnParticle();
	}

	/**
	 * Default offset = 0
	 * Default speed = 0.1
	 * Default movementSpeed = 0
	 * 
	 * @param a         The first location
	 * @param b         The second location
	 * @param particle  Particle type
	 * @param count     Particle count
	 * @param forceShow Show particle when the player is far (256 blocks max.)
	 *                  and when player have minimal particle settings
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, boolean forceShow) {
		setVariables(a, b, particle, count, 0, 0, 0, 0.1, forceShow, 0);
		spawnParticle();
	}

	/**
	 * @param a             The first location
	 * @param b             The second location
	 * @param particle      Particle type
	 * @param count         Particle count
	 * @param offsetX       The maximum random offset on the X axis
	 * @param offsetY       The maximum random offset on the Y axis
	 * @param offsetZ       The maximum random offset on the Z axis
	 * @param speed         Every particle speed
	 * @param forceShow     Show particle when the player is far (256 blocks max.)
	 *                      and when player have minimal particle settings
	 * @param movementSpeed The speed in tick to spawn every particle
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double offsetX, double offsetY,
			double offsetZ, double speed, boolean forceShow, long movementSpeed) {
		setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, speed, forceShow, movementSpeed);
		spawnParticle();
	}

	/**
	 * If you don't know how to use data, you can use the block/item/redstone method
	 * adding materialName or color and size
	 * 
	 * @param <T>           Type of particle data, see Particle.getDataType()
	 *                      (Bukkit)
	 * @param a             The first location
	 * @param b             The second location
	 * @param particle      Particle type
	 * @param count         Particle count
	 * @param offsetX       The maximum random offset on the X axis
	 * @param offsetY       The maximum random offset on the Y axis
	 * @param offsetZ       The maximum random offset on the Z axis
	 * @param speed         Every particle speed
	 * @param forceShow     Show particle when the player is far (256 blocks max.)
	 *                      and when player have minimal particle settings
	 * @param movementSpeed The speed in tick to spawn every particle
	 * @param data          This is used at block/item particles to set data and
	 *                      at redstone particle to set color
	 */
	public <T> LineParticle(Location a, Location b, Particle particle, int count, double offsetX, double offsetY,
			double offsetZ, double speed, boolean forceShow, long movementSpeed, @Nullable T data) {
		setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, speed, forceShow, movementSpeed);
		double initialDistance = getA().distance(getB());
		Vector direction = VectorMath.directionVector(this.a, this.b);
		new BukkitRunnable() {
			public void run() {
				ParticleAPI.debug("Initial: " + initialDistance);
				ParticleAPI.debug("a/b distance: " + getA().distance(getB()));
				if (getA().distance(getB()) < 1 || getA().distance(getB()) > initialDistance) {
					cancel();
				}
				getA().getWorld().spawnParticle(getParticle(), getA(), getCount(), getOffsetX(), getOffsetY(),
						getOffsetZ(), getSpeed(), data, isForceShow());
				double x = direction.getX();
				double y = direction.getY();
				double z = direction.getZ();
				getA().add(x, y, z);
			}
		}.runTaskTimer(ParticleAPI.getPlugin(), 0, getMovementSpeed());
	}

	/**
	 * This is used for Block/Item Particles
	 * @param a             The first location
	 * @param b             The second location
	 * @param particle      Particle type
	 * @param count         Particle count
	 * @param offsetX       The maximum random offset on the X axis
	 * @param offsetY       The maximum random offset on the Y axis
	 * @param offsetZ       The maximum random offset on the Z axis
	 * @param speed         Every particle speed
	 * @param forceShow     Show particle when the player is far (256 blocks max.)
	 *                      and when player have minimal particle settings
	 * @param movementSpeed The speed in tick to spawn every particle
	 * @param materialName  The material name
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double offsetX, double offsetY,
			double offsetZ, double speed, boolean forceShow, long movementSpeed, String materialName) {
		if (particle == Particle.BLOCK_CRACK || particle == Particle.BLOCK_DUST || particle == Particle.FALLING_DUST
				|| particle == Particle.ITEM_CRACK) {
			setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, speed, forceShow, movementSpeed);
			this.materialName = materialName;
			double initialDistance = getA().distance(getB());
			Vector direction = VectorMath.directionVector(this.a, this.b);
			BlockData bd = null;
			ItemStack is = null;
			if (particle == Particle.BLOCK_CRACK || particle == Particle.BLOCK_DUST
					|| particle == Particle.FALLING_DUST) {
				bd = Objects.requireNonNull(Material.getMaterial(getMaterialName())).createBlockData();
			} else {
				is = new ItemStack(Objects.requireNonNull(Material.getMaterial(getMaterialName())));
			}
			BlockData finalBd = bd;
			ItemStack finalIs = is;
			new BukkitRunnable() {
				public void run() {
					ParticleAPI.debug("Initial: " + initialDistance);
					ParticleAPI.debug("a/b distance: " + getA().distance(getB()));
					if (getA().distance(getB()) < 1 || getA().distance(getB()) > initialDistance) {
						cancel();
					}
					if (particle == Particle.BLOCK_CRACK || particle == Particle.BLOCK_DUST
							|| particle == Particle.FALLING_DUST) {
						getA().getWorld().spawnParticle(getParticle(), getA(), getCount(), getOffsetX(), getOffsetY(),
								getOffsetZ(), getSpeed(), finalBd, isForceShow());
					} else {
						getA().getWorld().spawnParticle(getParticle(), getA(), getCount(), getOffsetX(), getOffsetY(),
								getOffsetZ(), getSpeed(), finalIs, isForceShow());
					}
					double x = direction.getX();
					double y = direction.getY();
					double z = direction.getZ();
					getA().add(x, y, z);
				}
			}.runTaskTimer(ParticleAPI.getPlugin(), 0, getMovementSpeed());
		} else {
			ParticleAPI.consoleMsg(Formatter.FText(particle.toString() + "&c&l is not a Block Particle"));
		}
	}

	/**
	 * This is used for Redstone Particle
	 * @param a             The first location
	 * @param b             The second location
	 * @param particle      Particle type
	 * @param count         Particle count
	 * @param offsetX       The maximum random offset on the X axis
	 * @param offsetY       The maximum random offset on the Y axis
	 * @param offsetZ       The maximum random offset on the Z axis
	 * @param speed         Every particle speed
	 * @param forceShow     Show particle when the player is far (256 blocks max.)
	 *                      and when player have minimal particle settings
	 * @param movementSpeed The speed in tick to spawn every particle
	 * @param color         The redstone dust color
	 * @param size          The redstone dust size
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, double offsetX, double offsetY,
			double offsetZ, double speed, boolean forceShow, long movementSpeed, Color color, int size) {
		if (particle == Particle.REDSTONE) {
			setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, speed, forceShow, movementSpeed);
			this.particleColor = color;
			this.size = size;
			double initialDistance = getA().distance(getB());
			Vector direction = VectorMath.directionVector(this.a, this.b);
			new BukkitRunnable() {
				public void run() {
					ParticleAPI.debug("Initial: " + initialDistance);
					ParticleAPI.debug("a/b distance: " + getA().distance(getB()));
					if (getA().distance(getB()) < 1 || getA().distance(getB()) > initialDistance) {
						cancel();
					}
					getA().getWorld().spawnParticle(getParticle(), getA(), getCount(), getOffsetX(), getOffsetY(),
							getOffsetZ(), getSpeed(), new Particle.DustOptions(getParticleColor(), getSize()),
							isForceShow());
					double x = direction.getX();
					double y = direction.getY();
					double z = direction.getZ();
					getA().add(x, y, z);
				}
			}.runTaskTimer(ParticleAPI.getPlugin(), 0, getMovementSpeed());
		} else {
			ParticleAPI.consoleMsg(Formatter.FText(particle.toString() + "&c&l is not a Block Particle"));
		}
	}

	private void setVariables(Location a, Location b, Particle particle, int count, double offsetX, double offsetY,
			double offsetZ, double speed, boolean forceShow, long movementSpeed) {
		this.a = a;
		this.b = b;
		this.particle = particle;
		this.count = count;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.offsetZ = offsetZ;
		this.speed = speed;
		this.movementSpeed = movementSpeed;
		this.forceShow = forceShow;
		this.a.setX(getA().getX() + 0.5);
		this.b.setX(getB().getX() + 0.5);
		this.a.setY(getA().getY() + 0.5);
		this.b.setY(getB().getY() + 0.5);
		this.a.setZ(getA().getZ() + 0.5);
		this.b.setZ(getB().getZ() + 0.5);
	}

	private void spawnParticle() {
		double initialDistance = getA().distance(getB());
		Vector direction = VectorMath.directionVector(this.a, this.b);
		new BukkitRunnable() {
			public void run() {
				ParticleAPI.debug("Initial: " + initialDistance);
				ParticleAPI.debug("a/b distance: " + getA().distance(getB()));
				if (getA().distance(getB()) < 1 || getA().distance(getB()) > initialDistance) {
					cancel();
				}
				getA().getWorld().spawnParticle(getParticle(), getA(), getCount(), getOffsetX(), getOffsetY(),
						getOffsetZ(), getSpeed(), null, isForceShow());
				double x = direction.getX();
				double y = direction.getY();
				double z = direction.getZ();
				getA().add(x, y, z);
			}
		}.runTaskTimer(ParticleAPI.getPlugin(), 0, getMovementSpeed());
	}

	private Location getA() {
		return a;
	}

	private Location getB() {
		return b;
	}

	private Particle getParticle() {
		return particle;
	}

	private int getCount() {
		return count;
	}

	private double getOffsetX() {
		return offsetX;
	}

	private double getOffsetY() {
		return offsetY;
	}

	private double getOffsetZ() {
		return offsetZ;
	}

	private double getSpeed() {
		return speed;
	}

	private long getMovementSpeed() {
		return movementSpeed;
	}

	private boolean isForceShow() {
		return forceShow;
	}

	private String getMaterialName() {
		return materialName;
	}

	private Color getParticleColor() {
		return particleColor;
	}

	private int getSize() {
		return size;
	}
}
