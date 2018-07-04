package application;

import java.util.LinkedList;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.layout.TilePane;

public class GameBoard extends TilePane {

	int length;
	int height;
	Cell[][] table;
	
	public GameBoard(int length, int height){
		setPrefColumns(length);
		setPrefRows(height);
		setMaxWidth(Control.USE_PREF_SIZE);
		this.height=height;
		this.length=length;
		table= new Cell[length][height];
		setMaxHeight(1);
		initializeBoard();
	}
	private void initializeBoard() {
		for(int a=0;a<length;a++) {
			for(int b=0;b<height;b++) {
				Cell c= new Cell(10,10);
				getChildren().add(c);
				table[a][b]=c;
			}
		}
	}
	Cell getCell(int x, int y) {
		return this.table[x][y];
	}

}
