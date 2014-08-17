package minesweeper;

/*
 * A Cell should display itself based on its opened value. This should not be in Board class
 * */
public class Cell {
	private int value;
	private CellStatus cellStatus = CellStatus.CLOSED;
	public final static int MINE_VALUE = -1;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isMine() {
		return value == MINE_VALUE;
	}

	public void open() {
		cellStatus = CellStatus.OPENED;
	}

	public boolean isOpened() {
		return cellStatus == CellStatus.OPENED;
	}

	public void flag() {
		cellStatus = CellStatus.FLAGGED;
	}

	public void display() {
		if (isOpened())
			System.out.print(value);
		else if (isFlagged())
			System.out.print("F");
		else
			System.out.print("?");
	}

	private boolean isFlagged() {
		// TODO Auto-generated method stub
		return cellStatus == CellStatus.FLAGGED;
	}
}
