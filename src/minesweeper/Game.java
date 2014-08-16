package minesweeper;

import java.io.*;

class Game {
	private static final int totalMineCount = 10;
	boolean allMinesIdentified = false;
	boolean openedMine = false;

	public Game() throws IOException {
		int row, col;

		Grid grid = new Grid(10, new RandomGridFiller());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		grid.test();
		grid.display();
		do {
			System.out.println("Enter the Row No:(From 0 to 9)");
			row = getUserVal(br);
			System.out.println("Enter the Col No:(From 0 to 9)");
			col = getUserVal(br);

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
			System.out.println("Congratulations\n You Won");
		} else if (openedMine) {
			System.out
					.println("Sorry..You stepped on a MineChecker...\nGame Over");
		}
	}

	int getUserVal(BufferedReader br) throws IOException {
		int value = 0;
		while (true) {
			try {
				value = Integer.parseInt(br.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Please Enter a Number");
				continue;
			}
			if (value < 0 || value > 9) {
				System.out.println("Value should be in the range of 0 - 9");
				continue;
			}
			return value;
		}
	}
}