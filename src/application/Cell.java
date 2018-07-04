package application;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {

	private CellState state;
	

	public Cell(int arg0, int arg1) {
		super(arg0, arg1);
		setState(CellState.FREE);
		
	}
	
	void setState(CellState s) {
		switch(s) {
			case FREE:
				setFill(Color.GREY);
				break;
			case UNDERTAILE:
				setFill(Color.GREEN);
				break;
			case POINTACTIVE:
				setFill(Color.YELLOW);
				break;
			case UNDERHEAD:
				setFill(Color.WHITE);
				break;
		}
		
	}
	
	



}
