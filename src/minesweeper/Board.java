package minesweeper;

/*
 * Board has the status of a Cell is opened or not.
 * If opened it shows the number of  mine surrounded. Else it shows '?' character
 * A Cell is opened or not . It is a status of cell. So it should be in Cell
 * */


public class Board {
	private char[][] displayCells;

	public Board() {
		displayCells = new char[10][10];
	}

	public void fillBoard() {
		/* Sets the rows to '?' */
		for (int i = 0; i <= 9; i++) {
			fillColumns(i);
		}
	}

	public void fillColumns(int row) {
		/* Sets the columns to '?' */
		for (int j = 0; j <= 9; j++) {
			displayCells[row][j] = '?';
		}
	}

	public void open(int row, int col, Cells cells) {
		int cell_value = cells.getCellAt(row, col).getValue();
		// change status of a cell while opening
		cells.open(row, col);
		if (!cells.hasMineAt(row, col)) {
			displayCells[row][col] = Character.forDigit(cell_value, 10);
		}
	}

	// Board should not display each cell. Cells can display its each cell.
	public void display() {
		for (int i = 0; i <= 9; i++) {
			displayColumns(i);
		}
	}

	public void displayColumns(int row) {
		for (int j = 0; j <= 9; j++) {
			System.out.print(displayCells[row][j] + " ");
		}
		System.out.println();
	}

	// Getting unopened Cell count is job of Cells. bcoz now Cell is resp or its
	// status. Cells only contains Cell.
	// Board can not work on Cells member variable. So move this method to Cells

}