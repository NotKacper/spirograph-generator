import java.util.Vector;

public class MathHandler {
	private float xScalar;
	private float xOffset;
	private float yScalar;
	private float yOffset;

	public MathHandler() {
		xScalar = 1;
		yScalar = 1;
		xOffset = 0;
		yOffset = 0;
	}

	public void setYScalar(float yScalar) {
		this.yScalar = yScalar;
	}

	public float getXOffset() {
		return xOffset;
	}

	public void setXOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getXScalar() {
		return xScalar;
	}

	public void setXScalar(float xScalar) {
		this.xScalar = xScalar;
	}

	public float getYOffset() {
		return yOffset;
	}

	public void setYOffset(float yOffset) {
		this.yOffset = yOffset;
	}

	public float getYScalar() {
		return yScalar;
	}

	/**
	 *
	 * @param coordinates The raw value of the coordinates of a point in the x y plane
	 * @param height The maximum height of the graphics 2D dimensions
	 * @param width The maximum width of the graphics 2D dimensions
	 * @return Returns the screen-centred coordinates of a point about (0,0)
	 */
	private Vector<Float> translateToGraphicCoordinates(Vector<Float> coordinates, float height, float width) {
		Vector<Float> newCoordinates = new Vector<>();
		newCoordinates.add(width / 2 + xScalar * coordinates.get(0));
		newCoordinates.add(height / 2 - yScalar * coordinates.get(0));
		return newCoordinates;
	}

	/**
	 *
	 * @param coordinates The raw value of the coordinates of a point in the x y plane
	 * @param height The maximum height of the graphics 2D dimensions
	 * @param width The maximum width of the graphics 2D dimensions
	 * @return Returns the screen-centred coordinates of a point about centre of user's view on plot.
	 */

	public Vector<Float> get2DGraphicCoordinates(Vector<Float> coordinates, float height, float width) {
		Vector<Float> newCoordinates = translateToGraphicCoordinates(coordinates, height, width);
		newCoordinates.set(0, coordinates.get(0) - xOffset);
		newCoordinates.set(1, coordinates.get(1) - yOffset);
		return newCoordinates;
	}
}
