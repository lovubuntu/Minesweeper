package minesweeper;

//Grid is an collective class. But it stores collection of int not Cell or its kind. It is doing some aggregative functions 
//addition to that it does some singular work too . this shows more responsibility. So extracting those singular behaviour to 
// new class called Cell.

// Grid are checking the singular function whether a cell is mine or not. that can be inside the cell.

/*
 * Make replace all loop termination condition with getSize()
 * */
public class Grid {
	private int size;

	private int getSize() {
		return size;
	}

	private Cell[][] cells;

	// total Mine count decided by Game. So remove from Grid
	private int totalMines = 10;

	public Grid(int size, CellsValuePopulator cellsValuePopulator) {
		// first need to initialise all the Cell objects in Grid
		this.size = size;
		totalMines = size;
		initialiseCells();
		cellsValuePopulator.populate(cells, totalMines);
	}

	private void initialiseCells() {
		cells = new Cell[getSize()][getSize()];
		for (int row = 0; row < getSize(); row++) {
			for (int column = 0; column < getSize(); column++) {
				cells[row][column] = new Cell();
			}

		}

	}

	public Cell getCellAt(int row, int col) {
		/* Returns the Grid Value */
		return cells[row][col];
	}

	public void test() {
		for (int row = 0; row < getSize(); row++) {
			for (int column = 0; column < getSize(); column++)
				cells[row][column].display();
			System.out.println();
		}
	}

	private boolean hasMineAt(int row, int col) {
		return cells[row][col].isMine();
	}

	// open method can return something to Game whether it is opened cell is
	// mine or not.
	// from Game , open is not changing the status of its memeber variable. It
	// is affecting
	// the status of distant object(Cell) state
	public boolean open(int row, int col) {
		cells[row][col].open();
		return !hasMineAt(row, col);
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