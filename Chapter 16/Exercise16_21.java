import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_21 extends Application{
	private static final String Media_URL = "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";
	@Override
	public void start(Stage primaryStage) {
		TextField tfCountdown = new TextField("0");
		tfCountdown.setFont(Font.font(50));
		tfCountdown.setAlignment(Pos.CENTER);
		tfCountdown.setFocusTraversable(true);
		Pane pane = new Pane(tfCountdown);
		StackPane stackPane = new StackPane(pane);
	
		Timeline timeline = new Timeline(new KeyFrame (Duration.millis(1000), e ->{
			tfCountdown.setText((Integer.parseInt(tfCountdown.getText()) - 1) + "");
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		
		Media media = new Media(Media_URL);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		MediaView mediaView = new MediaView(mediaPlayer);
		
		BorderPane bPane = new BorderPane();
		bPane.setCenter(stackPane);
		bPane.setBottom(mediaView);
		
		tfCountdown.setOnAction(e -> {
			if (timeline.getStatus() == Timeline.Status.RUNNING) {
				timeline.stop();
			}
			timeline.setCycleCount(Integer.parseInt(tfCountdown.getText()));
			tfCountdown.setEditable(false);
			timeline.play();
		});
		timeline.setOnFinished(e -> {
			mediaPlayer.play();
		});
		
		primaryStage.setScene(new Scene(bPane));
		primaryStage.setTitle("Exercise 16_21");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
