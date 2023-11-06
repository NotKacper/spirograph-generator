import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class PaintController {

  private final PlotHandler plotHandler = new PlotHandler(1);
  @FXML private Canvas canvas;
  private GraphicsContext ctx;

  public void initialize() {
    ctx = canvas.getGraphicsContext2D();
  }

  public void onPreset1() {
    drawSpirograph(100, 0.25, 0.75);
  }

  public void onWeirdPreset1() {
    drawWeirdSpirograph(100, 0.25, 0.75);
  }

  public void onWeirdPreset2() {
    drawWeirdSpirograph(150, 0.5, 0.5);
  }

  public void onWeirdPreset3() {
    drawWeirdSpirograph(200, 0.75, 0.25);
  }

  public void onCustom() {
    drawWeirdSpirograph(100, 0.1, 0.2);
  }

  private void drawWeirdSpirograph(double radius, double k, double l) {
    double originX = canvas.getWidth() / 2;
    double originY = canvas.getHeight() / 2;
    ctx.clearRect(0, 0, originX * 2, originY * 2);
    plotHandler.setRadius(radius);
    plotHandler.clearPoints();
    double[] previousPosition = new double[2];
    for (double t = 0; t < 1000; t++) {
      ctx.clearRect(0, 0, originX * 2, originY * 2);
      ctx.beginPath();
      previousPosition[0] = originX;
      previousPosition[1] = originY;
      ctx.moveTo(originX, originY);
      for (PointVector pv : plotHandler.getPointList()) {
        ctx.strokeLine(
            previousPosition[0],
            previousPosition[1],
            pv.getOnScreenCoordinates().get(0),
            pv.getOnScreenCoordinates().get(1));
        previousPosition[0] = pv.getOnScreenCoordinates().get(0);
        previousPosition[1] = pv.getOnScreenCoordinates().get(1);
      }
      plotHandler.getNextFrameInfo(t, k, l);
      t++;
      ctx.closePath();
    }
  }

  // make this draw multiple spirographs, and make a custom spirograph method.
  private void drawSpirograph(double radius, double k, double l) {
    double originX = canvas.getWidth() / 2;
    double originY = canvas.getHeight() / 2;
    ctx.clearRect(0, 0, originX * 2, originY * 2);
    plotHandler.setRadius(radius);
    plotHandler.clearPoints();
    double[] previousPosition = new double[2];
    for (double t = 0; t < 1000; t++) {
      ctx.clearRect(0, 0, originX * 2, originY * 2);
      ctx.beginPath();
      previousPosition[0] = originX;
      previousPosition[1] = originY;
      ctx.moveTo(originX, originY);
      for (PointVector pv : plotHandler.getPointList()) {
        ctx.fillOval(pv.getOnScreenCoordinates().get(0), pv.getOnScreenCoordinates().get(1), 1, 1);
        previousPosition[0] = pv.getOnScreenCoordinates().get(0);
        previousPosition[1] = pv.getOnScreenCoordinates().get(1);
      }
      plotHandler.getNextFrameInfo(t, k, l);
      t++;
      ctx.closePath();
    }
  }

  public void onExit() {
    Platform.exit();
  }
}
