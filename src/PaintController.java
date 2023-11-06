import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

public class PaintController {

  @FXML private Canvas canvas;

  @FXML private ColorPicker colorPicker;

  public void initialize() {
    GraphicsContext ctx = canvas.getGraphicsContext2D();
    PlotHandler ph = new PlotHandler();
    PointVector nextPoint;
    ctx.beginPath();
    for (double i = 0; i < 500; i+=1) {
      nextPoint = ph.getNextFrameInfo(i/10);
      ctx.lineTo(
          nextPoint.getOnScreenCoordinates().get(0), nextPoint.getOnScreenCoordinates().get(1));
      ctx.stroke();
    }
    ctx.closePath();
  }

  public void onRun() {}

  public void onExit() {
    Platform.exit();
  }
}
