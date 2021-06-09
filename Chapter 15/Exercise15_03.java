import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class Exercise15_03 extends Application{
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Circle circle = new Circle(150, 150, 20);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		Button btup = new Button("UP");
		Button btdown = new Button("DOWN");
		Button btleft = new Button("LEFT");
		Button btright = new Button("RIGHT");
		HBox box = new HBox();
		box.setSpacing(10);
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(btup);
		box.getChildren().add(btdown);
		box.getChildren().add(btleft);
		box.getChildren().add(btright);
		
		pane.getChildren().add(circle);
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		BorderPane.setAlignment(pane, Pos.CENTER);
		borderPane.setBottom(box);
		BorderPane.setAlignment(box, Pos.CENTER);
		
		btup.setOnAction(e -> {
			circle.setCenterY(circle.getCenterY() > 10 ? circle.getCenterY() - 10 : 10);
			});
		btdown.setOnAction((ActionEvent e) -> { 
			circle.setCenterY(circle.getCenterY() < pane.getHeight() ? circle.getCenterY() + 10 : pane.getHeight());
			});
		btleft.setOnAction((ActionEvent e) -> { 
			circle.setCenterX(circle.getCenterX() > 0 ? circle.getCenterX() - 5 : -10);
			});
		btright.setOnAction((ActionEvent e) -> {
			circle.setCenterX(circle.getCenterX() < pane.getWidth() -300 ? circle.getCenterX() + 10 : pane.getWidth());
			});
		
		Scene scene = new Scene(borderPane, 300, 300);
		primaryStage.setTitle("Exercise15_03");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		scene.setOnKeyPressed(e ->{
			if(e.getCode() == KeyCode.UP) {
				circle.setCenterY(circle.getCenterY() > 10 ? circle.getCenterY() - 10 : 10);
			} else if (e.getCode() == KeyCode.DOWN) {
				circle.setCenterY(circle.getCenterY() < pane.getHeight() ? circle.getCenterY() + 10 : pane.getHeight());
			}else if (e.getCode() == KeyCode.LEFT) {
				circle.setCenterX(circle.getCenterX() > 0 ? circle.getCenterX() - 5 : -10);
			} else if (e.getCode() == KeyCode.RIGHT) {
				circle.setCenterX(circle.getCenterX() < pane.getWidth() -300 ? circle.getCenterX() + 10 : pane.getWidth());
			} 
		});
	
	}
	public static void main(String[] args) {
		launch(args);
	}
}
