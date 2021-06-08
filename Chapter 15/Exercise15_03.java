package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class Exercise15_03 extends Application{
	private MyCircle myCircle = new MyCircle();
	@Override
	public void start(Stage primaryStage) {

		HBox box = new HBox();
		box.setSpacing(10);
		box.setAlignment(Pos.CENTER);
		Button btup = new Button("UP");
		Button btdown = new Button("DOWN");
		Button btleft = new Button("LEFT");
		Button btright = new Button("RIGHT");
		box.getChildren().add(btup);
		box.getChildren().add(btdown);
		box.getChildren().add(btleft);
		box.getChildren().add(btright);
		
		btup.setOnAction(e -> myCircle.moveUp());
		btdown.setOnAction(e -> myCircle.moveDown());
		btleft.setOnAction(e -> myCircle.moveLeft());
		btright.setOnAction(e -> myCircle.moveRight());
		
		BorderPane bPane = new BorderPane();
		bPane.setCenter(myCircle);
		bPane.setBottom(box);
		BorderPane.setAlignment(box, Pos.CENTER);
		
		Scene scene = new Scene(bPane, 300, 300);
		primaryStage.setTitle("Exercise15_03");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		scene.setOnKeyPressed(e ->{
			if(e.getCode() == KeyCode.UP) {
				myCircle.moveUp();
			} else if (e.getCode() == KeyCode.DOWN) {
				myCircle.moveDown();
			} else if (e.getCode() == KeyCode.RIGHT) {
				myCircle.moveRight();
			} else if (e.getCode() == KeyCode.LEFT) {
				myCircle.moveLeft();
			}
		});
		
	}
}
class MyCircle extends StackPane {
	private Circle circle = new Circle(20);
	
	public MyCircle() {
		getChildren().add(circle);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
	}
	public void moveUp() {
		circle.setLayoutY(getLayoutY() + 100);
	}
	public void moveDown() {
		circle.setLayoutY(getLayoutY() - 10);
	}
	public void moveLeft() {
		circle.setLayoutX(getLayoutX() - 10);
	}
	public void moveRight() {
		circle.setLayoutX(getLayoutX() + 10);
	}
}
