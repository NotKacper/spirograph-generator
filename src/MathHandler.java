import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.util.Vector;

public class MathHandler {

  private double radius;

  public MathHandler(double radius) {
    this.radius = radius;
  }


  public PointVector findCoordinatesAtParameter(
      double t,  double k, double l) {
    double x = radius*( (1-k) * cos(t) + l*k*cos((1-k)/k * t));
    double y = radius*( (1-k) * sin(t) - l*k*sin((1-k)/k * t));
    return new PointVector(x, y);
  }

  private Vector<Double> translateToGraphicCoordinates(
      Vector<Double> coordinates, double height, double width, double xScalar, double yScalar) {
    Vector<Double> newCoordinates = new Vector<>();
    newCoordinates.add(width / 2 + xScalar * coordinates.get(0));
    newCoordinates.add(height / 2 + yScalar * coordinates.get(1));
    return newCoordinates;
  }

  public Vector<Double> get2DGraphicCoordinates(
      Vector<Double> coordinates,
      double height,
      double width,
      double xScalar,
      double yScalar,
      double xOffset,
      double yOffset) {
    Vector<Double> newCoordinates =
        translateToGraphicCoordinates(coordinates, height, width, xScalar, yScalar);
    newCoordinates.set(0, newCoordinates.get(0) - xOffset);
    newCoordinates.set(1, newCoordinates.get(1) - yOffset);
    return newCoordinates;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }
}
