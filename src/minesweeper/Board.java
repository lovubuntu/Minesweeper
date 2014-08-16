package minesweeper;

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
		int cell_value = cells.getCellAt(row, col);
		if (cell_value != 9) {
			displayCells[row][col] = Character.forDigit(cell_value, 10);
		}
	}

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

	public int getUnopenedCellsCount() {
		int ucells_count = 0;
		for (int i = 0; i < 10; i++) {
			ucells_count = countUnopenedCols(i, ucells_count);
		}
		return ucells_count;
		// this logic goes to Game
		// if(ucells_count == 10)
		// {
		// System.out.println("Congratulations\n You Won");
		// System.exit(0);
		// }
	}

	public int countUnopenedCols(int row, int ucells_count) {
		for (int col = 0; col < 10; col++) {
			ucells_count = checkUnopenedCell(row, col, ucells_count);
		}
		return ucells_count;
	}

	public int checkUnopenedCell(int row, int col, int ucells_count) {
		char unopened = '?';
		if (displayCells[row][col] == unopened) {
			ucells_count++;
		}
		return ucells_count;
	}
}