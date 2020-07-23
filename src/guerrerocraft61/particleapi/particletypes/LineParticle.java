package guerrerocraft61.particleapi.particletypes;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

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

	/**
	 * Default offset = 0
	 * Default speed = 0.01
	 * Default forceShow = false
	 * Default movementSpeed = 0
	 * 
	 * @param a        The first location
	 * @param b        The second location
	 * @param particle Particle type
	 * @param count    Particle count
	 */
	public LineParticle(Location a, Location b, Particle particle, int count) {
		setVariables(a, b, particle, count, 0, 0, 0, 0.01, false, 0);
		spawnParticle();
	}

	/**
	 * Default speed = 0.01
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
		setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, 0.01, false, 0);
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
	 * Default speed = 0.01
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
		setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, 0.01, forceShow, movementSpeed);
		spawnParticle();
	}

	/**
	 * Default speed = 0.01
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
		setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, 0.01, false, movementSpeed);
		spawnParticle();
	}

	/**
	 * Default speed = 0.01
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
		setVariables(a, b, particle, count, offsetX, offsetY, offsetZ, 0.01, forceShow, 0);
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
	 * Default speed = 0.01
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
		setVariables(a, b, particle, count, 0, 0, 0, 0.01, forceShow, movementSpeed);
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
	 * Default speed = 0.01
	 * Default forceShow = false
	 *
	 * @param a             The first location
	 * @param b             The second location
	 * @param particle      Particle type
	 * @param count         Particle count
	 * @param movementSpeed The speed in tick to spawn every particle
	 */
	public LineParticle(Location a, Location b, Particle particle, int count, long movementSpeed) {
		setVariables(a, b, particle, count, 0, 0, 0, 0.01, false, movementSpeed);
		spawnParticle();
	}

	/**
	 * Default offset = 0
	 * Default speed = 0.01
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
		setVariables(a, b, particle, count, 0, 0, 0, 0.01, forceShow, 0);
		spawnParticle();
	}

	/**
	 * 
	 *
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
						getOffsetZ(), getSpeed(), Material.GRASS_BLOCK.createBlockData(), isForceShow());
				double x = direction.getX();
				double y = direction.getY();
				double z = direction.getZ();
				getA().add(x, y, z);
			}
		}.runTaskTimer(ParticleAPI.getPlugin(), 0, getMovementSpeed());
	}

	public Location getA() {
		return a;
	}

	public Location getB() {
		return b;
	}

	public Particle getParticle() {
		return particle;
	}

	public int getCount() {
		return count;
	}

	public double getOffsetX() {
		return offsetX;
	}

	public double getOffsetY() {
		return offsetY;
	}

	public double getOffsetZ() {
		return offsetZ;
	}

	public double getSpeed() {
		return speed;
	}

	public long getMovementSpeed() {
		return movementSpeed;
	}

	public boolean isForceShow() {
		return forceShow;
	}
}
