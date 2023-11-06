import java.util.HashMap;
import java.util.Vector;

public class PlotHandler {
  private final HashMap<Double, PointVector> parameterToCoordinate;
  private final MathHandler math;
  private double xScalar;
  private double xOffset;
  private double yScalar;
  private double yOffset;

  public PlotHandler() {
    this.parameterToCoordinate = new HashMap<>();
    math = new MathHandler();
    xScalar = 5;
    yScalar = 5;
    xOffset = -300;
    yOffset = -300;
  }

	public PointVector getNextFrameInfo(double t) {
    PointVector pointVector = math.findCoordinatesAtParameter(t, 100, 50, 300);
    Vector<Double> onScreen = math.get2DGraphicCoordinates(pointVector.getRawCoordinates(), 600, 600, xScalar, yScalar, xOffset, yOffset);
    pointVector.setOnScreenCoordinates(onScreen.get(0), onScreen.get(1));
    parameterToCoordinate.put(t, pointVector);
    return pointVector;
	}

  public void setyScalar(double yScalar) {
    this.yScalar = yScalar;
  }

  public double getyOffset() {
    return yOffset;
  }

  public void setyOffset(double yOffset) {
    this.yOffset = yOffset;
  }

  public void setxScalar(double xScalar) {
    this.xScalar = xScalar;
  }

  public double getxOffset() {
    return xOffset;
  }

  public void setxOffset(double xOffset) {
    this.xOffset = xOffset;
  }
}

