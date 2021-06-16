
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Exercise16_01 extends Application{
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Text text1 = new Text(20, 70, "Programming is fun");
		text1.setFill(Color.BLACK);
		text1.setFont(Font.font("Courier", 20));
		pane.getChildren().add(text1);
	
		
		Button left = new Button("Left");
		Button right = new Button("Right");
		HBox box = new HBox();
		box.setSpacing(10);
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(left);
		box.getChildren().add(right);
		
		VBox paneForRB = new VBox(20);
		paneForRB.setPadding(new Insets(5, 5, 5, 5));
		paneForRB.setStyle("-fx-border-width: 2px; -fx-border-color: green");
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbBlue = new RadioButton("Blue");
		RadioButton rbYellow = new RadioButton("Yellow");
		RadioButton rbGreen = new RadioButton("Green");
		RadioButton rbBlack = new RadioButton("Black");
		paneForRB.getChildren().addAll(rbRed, rbBlue, rbYellow, rbGreen, rbBlack);
		
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbBlue.setToggleGroup(group);
		rbYellow.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		rbBlack.setToggleGroup(group);
		
		rbRed.setOnAction(e -> {
			if (rbRed.isSelected()) {
				text1.setFill(Color.DARKRED);
			}
		});
		rbBlue.setOnAction(e -> {
			if(rbBlue.isSelected()) {
				text1.setFill(Color.CORNFLOWERBLUE);
			}
		});
		rbYellow.setOnAction(e -> {
			if(rbYellow.isSelected()) {
				text1.setFill(Color.GOLD);
			}
		});
		rbGreen.setOnAction(e -> {
			if(rbGreen.isSelected()) {
				text1.setFill(Color.DARKOLIVEGREEN);
			}
		});
		rbBlack.setOnAction(e -> {
			if(rbBlack.isSelected()) {
				text1.setFill(Color.BLACK);
			}
		});
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		BorderPane.setAlignment(pane, Pos.CENTER);
		borderPane.setBottom(box);
		BorderPane.setAlignment(box, Pos.CENTER);
		borderPane.setTop(paneForRB);
		BorderPane.setAlignment(paneForRB, Pos.CENTER);
		
		left.setOnAction(e -> {
			text1.setX(text1.getX() > 0 ? text1.getX() - 5 : 10);
		});
		right.setOnAction(e -> {
			text1.setX(text1.getX() < pane.getWidth() -300 ? text1.getX() + 10 : pane.getWidth());
		});
		
		Scene scene = new Scene(borderPane, 500, 500);
		primaryStage.setTitle("Exercise16_01");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
