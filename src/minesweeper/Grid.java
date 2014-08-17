package minesweeper;

public class Grid {
	private int size;

	public int getSize() {
		return size;
	}

	private Cell[][] cells;
	private int ucells_count;

	private int totalMines = 10;

	public Grid(int size, CellsValuePopulator cellsValuePopulator) {
		this.size = size;
		totalMines = size;
		initialiseCells();
		cellsValuePopulator.populate(this);
		ucells_count = getSize() * getSize();
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

	private boolean hasMineAt(int row, int col) {
		return cells[row][col].isMine();
	}

	public boolean open(int row, int col) {
		cells[row][col].open();
		ucells_count--;
		return !hasMineAt(row, col);
	}

	public int getUnopenedCellsCount() {

		return ucells_count;
	}

	public void display() {
		for (int row = 0; row < getSize(); row++) {
			for (int col = 0; col < getSize(); col++) {
				cells[row][col].display();
			}
			IOUtil.println("");
		}

	}

	public int getTotalMinesCount() {
		// TODO Auto-generated method stub
		return totalMines;
	}

}