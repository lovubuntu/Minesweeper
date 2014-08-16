package minesweeper;

public class Cell {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isMine() {
		return value == 9;
	}
}
