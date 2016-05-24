package Minesweeper;

public class Minesweeper {
	
	public static void main(String... args) {
		Board board = new Board(5, 5);
		board.setMines(7);
		
		// calculate it on cell click event?
//		board.setSurroundings();
		
		
		
		board.printBoard();
	}
}