package minesweeper;

import java.io.*;

class Game {
	private static final int totalMineCount = 10;
	boolean allMinesIdentified = false;
	boolean openedMine = false;

	public Game() throws IOException {
		int row, col;

		Grid grid = new Grid(10, new RandomGridFiller());
		grid.display();
		do {
			IOUtil.println("Enter the Row No:(From 0 to 9)");
			row = getUserVal();
			IOUtil.println("Enter the Col No:(From 0 to 9)");
			col = getUserVal();

			if (grid.open(row, col)) {
				grid.display();
				if (grid.getUnopenedCellsCount() == totalMineCount) {

					allMinesIdentified = true;
				}
			} else {

				openedMine = true;
			}

		} while (!allMinesIdentified && !openedMine);

		decideGameStatus();

	}

	public static void main(String arg[]) throws IOException {
		new Game();
	}

	private void decideGameStatus() {
		if (allMinesIdentified) {
			IOUtil.println("Congratulations\n You Won");
		} else if (openedMine) {
			IOUtil.println("Sorry..You stepped on a MineChecker...\nGame Over");
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