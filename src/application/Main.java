package application;
	
import java.util.HashMap;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	static Snake snake;
	
	
	@Override
	public void start(Stage primaryStage) {
		HashMap<String,Direction> console= new HashMap<String,Direction>();
		console.put("UP", Direction.UP);
		console.put("DOWN", Direction.DOWN);
		console.put("RIGHT", Direction.RIGHT);
		console.put("LEFT", Direction.LEFT);
		
		try {
			BorderPane root = new BorderPane();
			GameBoard board= new GameBoard(20, 20);
			snake = new Snake(Color.GREEN,board);
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(!Thread.interrupted()) {
						try {
							snake.moveSnake();
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}catch (ArrayIndexOutOfBoundsException e) {
							snake.initSnakePosition();
						}
					}
				}
			}).start();
			root.setCenter(board);
			Scene scene = new Scene(root,400,400);
			scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			    public void handle(KeyEvent ke) {
			    	snake.setDirection(console.get(ke.getCode().toString()));
			    }
			});
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
