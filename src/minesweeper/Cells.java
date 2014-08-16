package minesweeper;

//Cells is an collective class. But it stores collection of int not Cell or its kind. It is doing some aggregative functions 
//addition to that it does some singular work too . this shows more responsibility. So extracting those singular behaviour to 
// new class called Cell.

// Cells are checking the singular function whether a cell is mine or not. that can be inside the cell.

/*
 * Make replace all loop termination condition with getSize()
 * */
public class Cells {
	private int size = 3;

	private int getSize() {
		return size;
	}

	private Cell[][] cells = new Cell[getSize()][getSize()];

	// total Mine count decided by Game. So remove from Cells
	private int totalMines = 10;

	public Cells() {
		// first need to initialise all the Cell objects in Cells
		initialiseCells();
	}

	public void fillCells() {
		int rowCol, row, col;

		while (totalMines > 0) {
			int sizeSquare = getSize() * getSize();
			rowCol = (int) (Math.random() * (sizeSquare - 1));
			row = (int) rowCol / getSize();
			col = rowCol % getSize();
			totalMines = checkMineIfNotPlaceOne(row, col, totalMines);
		}
	}

	private void initialiseCells() {
		for (int row = 0; row < getSize(); row++) {
			for (int column = 0; column < getSize(); column++) {
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
		RowProperties rowelt = new RowProperties(getSize());
		rowelt.set_Rmin_Rmax(row);
		rowelt.check_First_Row(row);

		rowelt.check_Last_Row(row);
		/* Reaches the Row level for the generated MineChecker */
		for (int i = rowelt.get_Rmin(); i <= rowelt.get_Rmax(); i++) {
			setLocalMinesCount(i, col);
		}
	}

	public void setLocalMinesCount(int row, int col) {
		ColumnProperties colelt = new ColumnProperties(getSize());
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
		for (int row = 0; row < getSize(); row++) {
			for (int column = 0; column < getSize(); column++)
				cells[row][column].display();
			System.out.println();
		}
	}

	public boolean hasMineAt(int row, int col) {
		return cells[row][col].isMine();
	}

	public void open(int row, int col) {
		cells[row][col].open();
	}

	public int getUnopenedCellsCount() {
		int ucells_count = 0;
		for (int row = 0; row < getSize(); row++) {
			for (int col = 0; col < getSize(); col++) {
				if (!cells[row][col].isOpened())
					ucells_count++;
			}
		}
		return ucells_count;
		// this logic goes to Game
		// if(ucells_count == 10)
		// {
		// System.out.println("Congratulations\n You Won");
		// System.exit(0);
		// }
	}

	public void display() {
		for (int row = 0; row < getSize(); row++) {
			for (int col = 0; col < getSize(); col++) {
				cells[row][col].display();
			}
			System.out.println();
		}

	}

}