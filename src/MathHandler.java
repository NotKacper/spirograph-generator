import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.util.Vector;

public class MathHandler {

  public PointVector findCoordinatesAtParameter(
      double t, double largeCircleRadius, double smallCircleRadius, double fractionSmallCircle) {
    double x =
        ((largeCircleRadius - smallCircleRadius) * cos(t)
            + fractionSmallCircle
                * cos(((largeCircleRadius - smallCircleRadius) / smallCircleRadius) * t));
    double y =
        (largeCircleRadius - smallCircleRadius) * sin(t)
            - fractionSmallCircle
                * sin(((largeCircleRadius - smallCircleRadius) / smallCircleRadius) * t);
    return new PointVector(x, y);
  }

  private Vector<Double> translateToGraphicCoordinates(
      Vector<Double> coordinates, double height, double width, double xScalar, double yScalar) {
    Vector<Double> newCoordinates = new Vector<>();
    newCoordinates.add(width / 2 + xScalar * coordinates.get(0));
    newCoordinates.add(height / 2 - yScalar * coordinates.get(1));
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
    newCoordinates.set(0, coordinates.get(0) - xOffset);
    newCoordinates.set(1, coordinates.get(1) - yOffset);
    return newCoordinates;
  }
}
