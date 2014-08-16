package minesweeper;

/*
 * A Cell should display itself based on its opened value. This should not be in Board class
 * */
public class Cell {
	private int value;
	private boolean opened;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isMine() {
		return value == 9;
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
