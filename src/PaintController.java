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
    ctx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    //    drawSpirograph(100, 0.25, 0.75);
    drawSpirograph(100, 0.3, 0.75, 10);
  }

  public void onWeirdPreset1() {
    ctx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    drawSpirograph(100, 0.25, 0.75, 1);
  }

  public void onWeirdPreset2() {
    ctx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    drawSpirograph(150, 0.5, 0.5, 1);
  }

  public void onWeirdPreset3() {
    ctx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    drawSpirograph(200, 0.75, 0.25, 1);
  }

  public void onCustom() {
    ctx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    drawSpirograph(100, 0.1, 0.2, 1);
  }

  // make this draw multiple spirographs, and make a custom spirograph method.
  private void drawSpirograph(double radius, double k, double l, int divisor) {
    plotHandler.setRadius(radius);
    plotHandler.clearPoints();
    double[] previousPosition = new double[2];
    plotHandler.getNextFrameInfo(0, k, l);
    previousPosition[0] = plotHandler.getPointList().getLast().getOnScreenCoordinates().get(0);
    previousPosition[1] = plotHandler.getPointList().getLast().getOnScreenCoordinates().get(1);
    for (double t = 0; t < 1000*divisor; t++) {
      plotHandler.getNextFrameInfo(t/divisor, k, l);
      ctx.strokeLine(
          previousPosition[0],
          previousPosition[1],
          plotHandler.getPointList().getLast().getOnScreenCoordinates().get(0),
          plotHandler.getPointList().getLast().getOnScreenCoordinates().get(1));
      previousPosition[0] = plotHandler.getPointList().getLast().getOnScreenCoordinates().get(0);
      previousPosition[1] = plotHandler.getPointList().getLast().getOnScreenCoordinates().get(1);
      t++;
    }
  }

  public void onExit() {
    Platform.exit();
  }
}
