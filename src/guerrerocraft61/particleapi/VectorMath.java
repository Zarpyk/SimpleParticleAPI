package guerrerocraft61.particleapi;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class VectorMath {

	public static Vector directionVector(Location a, Location b) {
		double dX = a.getX() - b.getX();
		double dY = a.getY() - b.getY();
		double dZ = a.getZ() - b.getZ();
		double yaw = Math.atan2(dZ, dX);
		double pitch = Math.atan2(Math.sqrt(dZ * dZ + dX * dX), dY) + Math.PI;
		double x = Math.sin(pitch) * Math.cos(yaw);
		double y = Math.sin(pitch) * Math.sin(yaw);
		double z = Math.cos(pitch);

		Vector vector = new Vector(x, z, y);
		vector = vector.normalize();

		return vector;
	}

}
