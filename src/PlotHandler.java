import java.util.ArrayList;
import java.util.Vector;

public class PlotHandler {
  private final ArrayList<PointVector> pointList;
  private final MathHandler math;
  private double xScalar;
  private double xOffset;
  private double yScalar;
  private double yOffset;

  public PlotHandler(double radius) {
    this.pointList = new ArrayList<>();
    math = new MathHandler(radius);
    xScalar = 3;
    yScalar = 3;
    xOffset = 0;
    yOffset = 0;
  }

  public void clearPoints() {
    pointList.clear();
  }

  public void setRadius(double radius) {
    math.setRadius(radius);
  }

  public void setyOffset(double yOffset) {
    this.yOffset = yOffset;
  }

  public double getyOffset() {
    return yOffset;
  }

  public double getxOffset() {
    return xOffset;
  }

  public void setxOffset(double xOffset) {
    this.xOffset = xOffset;
  }

  public void getNextFrameInfo(double t, double k, double l) {
    PointVector pointVector = math.findCoordinatesAtParameter(t, k, l);
    Vector<Double> onScreen = math.get2DGraphicCoordinates(pointVector.getRawCoordinates(), 600, 600, xScalar, yScalar, xOffset, yOffset);
    pointVector.setOnScreenCoordinates(onScreen.get(0), onScreen.get(1));
    pointList.add(pointVector);
  }

  public ArrayList<PointVector> getPointList() {
    return pointList;
  }
}

