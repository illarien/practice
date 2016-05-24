package Minesweeper;

public class Cell {
	
	private boolean mHasMine = false;
	private int mMinesAround;
	
	public Cell(boolean hasMine) {
		this.mHasMine = hasMine;
	}
	
	public void setMine() {
		mHasMine = true;
	}
	
	public boolean hasMine() {
		return mHasMine;
	}
	
	public void setMinesAround(int n) {
		this.mMinesAround = n;
	}
	
	public String toString() {
		return mHasMine ? "*" : "."; //""+mMinesAround;
	}
}
