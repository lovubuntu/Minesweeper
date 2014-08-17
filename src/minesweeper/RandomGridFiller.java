package minesweeper;

public class RandomGridFiller implements CellsValuePopulator {
	private Grid grid;
	private int totalMines;
	private NeighbourRowsCalculator rowelt;
	private NeighbourColumnsCalculator colelt;

	@Override
	public void populate(Grid grid) {
		this.grid = grid;
		this.totalMines = grid.getTotalMinesCount();
		rowelt = new NeighbourRowsCalculator(getSize());
		colelt = new NeighbourColumnsCalculator(getSize());
		fill();
	}

	private void fill() {

		int rowCol, row, col;

		while (totalMines > 0) {
			int sizeSquare = getSize() * getSize();
			rowCol = (int) (Math.random() * (sizeSquare - 1));
			row = (int) rowCol / getSize();
			col = rowCol % getSize();
			checkMineIfNotPlaceOne(row, col);
		}
	}

	private int getSize() {
		// TODO Auto-generated method stub
		return grid.getSize();
	}

	private void checkMineIfNotPlaceOne(int row, int col) {

		if (!grid.getCellAt(row, col).isMine()) {
			grid.getCellAt(row, col).setValue(Cell.MINE_VALUE);
			countAdjacentMines(row, col);
			totalMines--;
		}
	}

	private void countAdjacentMines(int row, int col) {

		rowelt.set_Rmin_Rmax(row);
		/* Reaches the Row level for the generated MineChecker */
		for (int i = rowelt.get_Rmin(); i <= rowelt.get_Rmax(); i++) {
			setLocalMinesCount(i, col);
		}
	}

	private void setLocalMinesCount(int row, int col) {

		colelt.setColumnMinAndMax(col);
		/* Goes upto Column level for each row getting passed */
		for (int j = colelt.getColumnMin(); j <= colelt.getColumnMax(); j++) {
			setMineCount(row, j);
		}
	}

	private void setMineCount(int row, int col) {
		/* Increments Count if it is not MineChecker */
		if (!grid.getCellAt(row, col).isMine()) {
			grid.getCellAt(row, col).setValue(
					grid.getCellAt(row, col).getValue() + 1);
		}
	}

}
