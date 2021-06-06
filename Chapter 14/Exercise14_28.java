package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.util.Calendar; 
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Exercise14_28 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a clock and a label
		ClockPane clock = new ClockPane();
		String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
		Label lblCurrentTime = new Label(timeString);
		// Place clock and label in border pane
		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(lblCurrentTime);
		BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("DisplayClock"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
                }
	public static void main(String[] args) {
		launch(args);
	}
}
class ClockPane extends Pane{
	private int hour;
	private int minute;
	private int second;
	public boolean hourHandVisible;
	public boolean minuteHandVisible;
	public boolean secondHandVisible;
	
	public ClockPane() {
		setCurrentTime();	
	}
	public ClockPane(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;	
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
		paintClock();
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
		paintClock();
	}
	public int getSecond() {
		return second; 
	}
	public void setSecond(int second) {
		this.second = second;
		paintClock();
	}
	public boolean getHourHandVisible() {
		return true; 
	}
	public void setHourHandVisible(boolean hourHandVisible) {
		this.hourHandVisible = hourHandVisible;
	}
	public boolean getMinuteHandVisible() {
		return true;
	}
	public void setMinuteHandVisible(boolean minuteHandVisible) {
		this.minuteHandVisible = minuteHandVisible;
	}
	public boolean getSecondHandVisible() {
		return false; 
	}
	public void setSecondHandVisible(boolean secondHandVisible) {
		this.secondHandVisible = secondHandVisible;
	}
	
	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		this.hour = (int) (Math.random() * 12);
		this.minute = (int) (Math.random() * 31);
		this.second = calendar.get(Calendar.SECOND);
		paintClock();
	}
	public void paintClock() {
		double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
		double centerX = getWidth() /2;
		double centerY = getHeight() /2;
		//Draw circle
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
		Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
		// Draw second hand
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.RED);
		
		// Draw minute hand
		double mLength = clockRadius * 0.65;
		double xMinute = centerX + sLength * Math.cos(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, xMinute, minuteY);
		mLine.setStroke(Color.BLUE);
		
		//Draw hour hand
		double hLength = clockRadius *  0.5;
		double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.GREEN);
		
		
		getChildren().clear();
		getChildren().addAll(circle, t1, t2, t3, t4);
		if(getHourHandVisible() == true) {
			getChildren().addAll(hLine);
		}
		if(getMinuteHandVisible() == true) {
			getChildren().addAll(mLine);
		}
		if (getSecondHandVisible() == true) {
			getChildren().addAll(sLine);
		}
		}
		 
	
	@Override 
	public void setHeight(double height) {
		super.setHeight(height);
		paintClock();
	}

}


