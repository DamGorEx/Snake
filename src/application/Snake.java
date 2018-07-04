package application;

import java.util.LinkedList;

import javafx.scene.paint.Color;

public class Snake {
		private Color snakeColor;
		private LinkedList<Cell> snakeBody;
		private GameBoard usedGameBoard;
		private int length;
		private Direction dir;
		private int headPositionX;	
		private int headPositionY;
		
	public Snake(Color snakeColor, GameBoard b) {
		length=5;
		this.snakeColor=snakeColor;
		snakeBody= new LinkedList<Cell>();
		usedGameBoard=b;
		initSnakePosition();
	}
	 Color getColor() {
		return snakeColor;
	}
	 void initSnakePosition() {
		 for(Cell c: snakeBody) {
			 c.setState(CellState.FREE);
		 }
		 snakeBody.clear();
		 headPositionX=4;
		 headPositionY=0;
		 snakeBody.add(usedGameBoard.getCell(0, 0));
		 snakeBody.add(usedGameBoard.getCell(1, 0));
		 snakeBody.add(usedGameBoard.getCell(2, 0));
		 snakeBody.add(usedGameBoard.getCell(3, 0));
		 snakeBody.add(usedGameBoard.getCell(headPositionX, headPositionY)); // <-- head
		 for(Cell c: snakeBody) {
			 c.setState(CellState.UNDERSNAKE);
		 }
		 setDirection(Direction.DOWN);
	 }
	 void setDirection(Direction d) {
		 dir=d;
	 }
	 void moveSnake() {
		snakeBody.getFirst().setState(CellState.FREE);
		snakeBody.removeFirst();
		switch(dir) {
		case DOWN:
			snakeBody.add(usedGameBoard.getCell(headPositionX++, headPositionY));
			break;
		case UP:
			snakeBody.add(usedGameBoard.getCell(headPositionX--, headPositionY));
			break;
		case LEFT:
			snakeBody.add(usedGameBoard.getCell(headPositionX, headPositionY--));
			break;
		case RIGHT:
			snakeBody.add(usedGameBoard.getCell(headPositionX, headPositionY++));
			break;
		 }
		snakeBody.getLast().setState(CellState.UNDERSNAKE);
	 }

}
