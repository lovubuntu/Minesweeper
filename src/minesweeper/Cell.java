package minesweeper;

/*
 * A Cell should display itself based on its opened value. This should not be in Board class
 * */
public class Cell {
	private int value;
	private boolean opened;
	public final static int MINE_VALUE = -1;

	public int getValue() {
		return value;
	}

	public void setNeighbourMinesCount(int value) {
		this.value = value;
	}

	public boolean isMine() {
		return value == MINE_VALUE;
	}

	public void open() {
		opened = true;
	}

	public boolean isOpened() {
		return opened;
	}

	public void display() {
		if (isOpened())
			System.out.print(value);
		else
			System.out.print("?");
	}
}
