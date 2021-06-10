import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Exercise15_Animation extends Application {
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();

		//Create Rectangle
		Rectangle rectangle = new Rectangle(0, 0, 60, 30);
		rectangle.setFill(Color.LIGHTBLUE);
		//Create Pentagon
		Polygon pentagon = new Polygon();
		pentagon.setFill(Color.PALEVIOLETRED);
		pentagon.setStroke(Color.BLACK);
		ObservableList<Double> list = pentagon.getPoints();
		double centerX = 400 / 2, centerY = 400 / 2;
		double radius = Math.min(400, 400) * 0.4;
		int sides = 5;
		for(int i = 0; i < sides; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / sides));
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / sides));
		}
	
		pane.getChildren().add(pentagon);
		pane.getChildren().add(rectangle);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(pentagon);
		pt.setNode(rectangle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play();
		
		FadeTransition ft = new FadeTransition(Duration.millis(4000), rectangle);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();
		
		pane.setOnMousePressed(e -> {
			ft.pause();
			pt.pause();
		});
		pane.setOnMouseReleased(e -> {
			ft.play();
			pt.play();
		});
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Exercise15_Animation");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}




