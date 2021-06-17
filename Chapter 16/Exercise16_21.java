import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_21 extends Application{
	@Override
	public void start(Stage primaryStage) {
		TextField tfCountdown = new TextField("0");
		tfCountdown.setFont(Font.font(50));
		tfCountdown.setAlignment(Pos.CENTER);
		tfCountdown.setFocusTraversable(true);
		Pane pane = new Pane(tfCountdown);
		StackPane stackPane = new StackPane(pane);
		int cycles = Integer.parseInt(tfCountdown.getText());
		
		Timeline timeline = new Timeline(new KeyFrame (Duration.millis(1000), e ->{
			tfCountdown.setText((Integer.parseInt(tfCountdown.getText()) - 1) + " ");
		}));
		timeline.setCycleCount(cycles);
		
		tfCountdown.setOnKeyPressed(e->{
			if (e.getCode() == KeyCode.ENTER) {
				tfCountdown.setEditable(true);
				timeline.play();
			}
		});
		primaryStage.setScene(new Scene(stackPane));
		primaryStage.setTitle("Exercise 16_21");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
