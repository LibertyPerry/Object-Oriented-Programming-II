import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise16_21 extends Application{
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Text text = new Text(150, 150, " ");
		pane.getChildren().add(text);
		
		BorderPane pane4TF = new BorderPane();
		pane4TF.setPadding(new Insets(5, 5, 5, 5));
		pane4TF.setLeft(new Label("Enter Number of Seconds"));
		
		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		pane4TF.setCenter(tf);
		
		tf.setOnAction(e -> text.setText(tf.getText()));
		// Make it an intger value??
		
		BorderPane borderpane = new BorderPane();
		borderpane.setCenter(pane);
		BorderPane.setAlignment(pane, Pos.CENTER);
		borderpane.setBottom(pane4TF);
		BorderPane.setAlignment(pane4TF, Pos.CENTER);
		
		Scene scene = new Scene(borderpane, 300, 300);
		primaryStage.setTitle("Exercise16_01");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		scene.setOnKeyPressed(e ->{
			if(e.getCode() == KeyCode.ENTER) {
				
			}
		});
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
