import java.util.Vector;

public class PointVector {

	private Vector<Float> rawCoordinates;

	private Vector<Float> onScreenCoordinates;

	/**
	 *
	 * @param rawX The initial value of the point's X on the Spinograph as found using its parametric equation
	 * @param rawY The initial value of the point's Y on the Spinograph as found using its parametric equation
	 */

	public PointVector(float rawX, float rawY) {
		rawCoordinates = new Vector<>();
		onScreenCoordinates = new Vector<>();
		rawCoordinates.add(rawX);
		rawCoordinates.add(rawY);
		onScreenCoordinates.add(rawX);
		onScreenCoordinates.add(rawY);
	}

	/**
	 *
	 * @param x The new on-screen coordinate X for the PointVector
	 * @param y The new on-screen coordinate Y for the PointVector
	 */

	public void setOnScreenCoordinates(float x, float y) {
		onScreenCoordinates.set(0, x);
		onScreenCoordinates.set(1, y);
	}
}
