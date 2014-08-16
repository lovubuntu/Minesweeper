package minesweeper;

public class RandomGridFiller implements CellsValuePopulator {
	private Cell[][] cells;
	private int totalMines;

	@Override
	public void populate(Cell[][] cells, int minesToBePlaced) {
		this.cells = cells;
		this.totalMines = minesToBePlaced;
		fill();
	}

	private void fill() {

		int rowCol, row, col;

		while (totalMines > 0) {
			int sizeSquare = getSize() * getSize();
			rowCol = (int) (Math.random() * (sizeSquare - 1));
			row = (int) rowCol / getSize();
			col = rowCol % getSize();
			totalMines = checkMineIfNotPlaceOne(row, col, totalMines);
		}
	}

	private int getSize() {
		// TODO Auto-generated method stub
		return cells.length;
	}

	private int checkMineIfNotPlaceOne(int row, int col, int totalMinesCount) {
		if (!cells[row][col].isMine()) {
			cells[row][col].setNeighbourMinesCount(Cell.MINE_VALUE);
			countAdjacentMines(row, col);
			totalMinesCount = totalMinesCount - 1;
		}
		return totalMinesCount;
	}

	private void countAdjacentMines(int row, int col) {
		NeighbourRowsCalculator rowelt = new NeighbourRowsCalculator(getSize());
		rowelt.set_Rmin_Rmax(row);
		/* Reaches the Row level for the generated MineChecker */
		for (int i = rowelt.get_Rmin(); i <= rowelt.get_Rmax(); i++) {
			setLocalMinesCount(i, col);
		}
	}

	private void setLocalMinesCount(int row, int col) {
		NeighbourColumnsCalculator colelt = new NeighbourColumnsCalculator(getSize());
		colelt.setColumnMinAndMax(col);
		/* Goes upto Column level for each row getting passed */
		for (int j = colelt.getColumnMin(); j <= colelt.getColumnMax(); j++) {
			setMineCount(row, j);
		}
	}

	private void setMineCount(int row, int col) {
		/* Increments Count if it is not MineChecker */
		if (!cells[row][col].isMine()) {
			cells[row][col]
					.setNeighbourMinesCount(cells[row][col].getValue() + 1);
		}
	}

}
