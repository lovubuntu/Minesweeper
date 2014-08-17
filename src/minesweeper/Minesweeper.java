package minesweeper;

import java.io.*;

class Minesweeper {
	private int totalMineCount;
	boolean allMinesIdentified = false;
	boolean openedMine = false;
	Grid grid;

	public Minesweeper(int lengthOfFieldSquareSide,
			CellsValuePopulator cellsValuePopulator) throws IOException {
		int row, col;
		this.totalMineCount = lengthOfFieldSquareSide;
		grid = new Grid(lengthOfFieldSquareSide, cellsValuePopulator);
		grid.display();
		do {
			IOUtil.println("Enter the Row No:(From 0 to 9)");
			row = getUserVal();
			IOUtil.println("Enter the Col No:(From 0 to 9)");
			col = getUserVal();

			if (grid.open(row, col)) {

				if (grid.getUnopenedCellsCount() == totalMineCount) {

					allMinesIdentified = true;
				}
			} else {

				openedMine = true;
			}
			grid.display();
		} while (!allMinesIdentified && !openedMine);

		decideGameStatus();

	}

	public boolean open(int row, int col) {
		return grid.open(row, col);
	}

	public void flag(int row, int col) {
	}

	private void decideGameStatus() {
		if (allMinesIdentified) {
			IOUtil.println("Congratulations\n You Won");
		} else if (openedMine) {
			IOUtil.println("Sorry..You stepped on a Mine...\nGame Over");
		}
	}

	int getUserVal() throws IOException {
		int value = 0;
		while (true) {
			try {
				value = Integer.parseInt(IOUtil.read());
			} catch (NumberFormatException nfe) {
				IOUtil.println("Please Enter a Number");
				continue;
			}
			if (value < 0 || value > 9) {
				IOUtil.println("Value should be in the range of 0 - 9");
				continue;
			}
			return value;
		}
	}
}