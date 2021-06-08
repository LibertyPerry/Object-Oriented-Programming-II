package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class Exercise15_03 extends Application{
	private MyCircle myCircle = new MyCircle();
	
	public void start(Stage primaryStage) {
		
		
		Scene scene = new Scene(myCircle, 300, 300);
		primaryStage.setTitle("Exercise15_03");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}

class MyCircle extends Pane {
	private void paint() {
		getChildren().clear();
		Circle circle = new Circle(getWidth() / 2, getHeight() /2, getWidth() / 2 - 50);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		getChildren().add(circle);
	}
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paint();
	}
	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paint();
	}
}


