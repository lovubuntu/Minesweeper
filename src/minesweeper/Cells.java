package minesweeper;

//Cells is an collective class. But it stores collection of int not Cell or its kind. It is doing some aggregative functions 
//addition to that it does some singular work too . this shows more responsibility. So extracting those singular behaviour to 
// new class called Cell.

// Cells are checking the singular function whether a cell is mine or not. that can be inside the cell.
public class Cells {
	private Cell[][] cells = new Cell[10][10];

	// total Mine count decided by Game. So remove from Cells
	private int totalMines = 10;

	public Cells() {
		// first need to initialise all the Cell objects in Cells
		initialiseCells();
	}

	public void fillCells() {
		int rowCol, row, col;

		while (totalMines > 0) {
			rowCol = (int) (Math.random() * 99);
			row = (int) rowCol / 10;
			col = rowCol % 10;
			totalMines = checkMineIfNotPlaceOne(row, col, totalMines);
		}
	}

	private void initialiseCells() {
		for (int row = 0; row < 10; row++) {
			for (int column = 0; column < 10; column++) {
				cells[row][column] = new Cell();
			}

		}

	}

	public int checkMineIfNotPlaceOne(int row, int col, int total_mines) {
		if (!cells[row][col].isMine()) {
			cells[row][col].setValue(9);
			countAdjacentMines(row, col);
			total_mines = total_mines - 1;
		}
		return total_mines;
	}

	public void countAdjacentMines(int row, int col) {
		RowElements rowelt = new RowElements();
		rowelt.set_Rmin_Rmax(row);
		rowelt.check_First_Row(row);

		rowelt.check_Last_Row(row);
		/* Reaches the Row level for the generated MineChecker */
		for (int i = rowelt.get_Rmin(); i <= rowelt.get_Rmax(); i++) {
			setLocalMinesCount(i, col);
		}
	}

	public void setLocalMinesCount(int row, int col) {
		ColumnProperties colelt = new ColumnProperties();
		colelt.setColumnMinAndMax(col);
		colelt.checkFirstColumn(col);
		colelt.checkLastColumn(col);
		/* Goes upto Column level for each row getting passed */
		for (int j = colelt.getColumnMin(); j <= colelt.getColumnMax(); j++) {
			setMineCount(row, j);
		}
	}

	public void setMineCount(int row, int col) {
		/* Increments Count if it is not MineChecker */
		if (!cells[row][col].isMine()) {
			cells[row][col].setValue(cells[row][col].getValue() + 1);
		}
	}

	public Cell getCellAt(int row, int col) {
		/* Returns the Cells Value */
		return cells[row][col];
	}

	public int getTotalMinesCount() {
		return totalMines;
	}

	public void test() {
		for (int row = 0; row < 10; row++) {
			for (int column = 0; column < 10; column++)
				System.out.print(cells[row][column].getValue() + " ");
			System.out.println();
		}
	}

	public boolean hasMineAt(int row, int col) {
		return cells[row][col].isMine();
	}
}