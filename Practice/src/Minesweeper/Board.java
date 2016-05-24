package Minesweeper;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	
	private int mW = 0;
	private int mH = 0;
	private Cell[][] mBoard;
	
	public Board(int w, int h) {
		this.mW = w;
		this.mH = h;
		this.mBoard = generateBoard(w, h);
	}

	private Cell[][] generateBoard(int w, int h) {
		Cell[][] result = new Cell[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				result[i][j] = new Cell(false);
			}
		}
		return result;
	}
	
	public void setMines(int nOfMines) {
		Random r = new Random();
		int nOfCells = mW*mH;
		ArrayList<Integer> cells= new ArrayList<>(nOfCells);
		for (int i = 0; i < nOfCells; i++) {
			cells.add(i);
		}
		for (int i = 0; i < nOfMines; i++) {
			int rand = r.nextInt(cells.size());
			int randCell = cells.get(rand);
			int x = randCell/mW;
			int y = randCell%mW;
			mBoard[x][y].setMine();
			cells.remove(rand);
		}
	}
	
	public void setSurroundings() {
		for (int i = 0; i < mW; i++) {
			for (int j =0; j < mH; j++) {
				if (!mBoard[i][j].hasMine()) {
					mBoard[i][j].setMinesAround(getMinesAround(i, j));
				}
			}
		}
	}

	private int getMinesAround(int i, int j) {
		int n = 0;
		return n;
	}

	public void printBoard() {
		for (int i = 0; i < mBoard.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < mBoard[i].length; j++) {
				sb.append(mBoard[i][j].toString());
			}
			System.out.println(sb.toString());
		}
	}
}