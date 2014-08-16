package minesweeper;

public class Grid {
	private int size;

	private int getSize() {
		return size;
	}

	private Cell[][] cells;

	private int totalMines = 10;

	public Grid(int size, CellsValuePopulator cellsValuePopulator) {
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