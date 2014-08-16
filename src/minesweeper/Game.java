package minesweeper;

import java.io.*;

class Game {
	// total mine count should be determined by the Game
	private static final int totalMineCount = 10;

	public static void main(String arg[]) throws IOException {

		int row, col;
		Cells cells = new Cells();
		// Board board = new Board();
		// MineChecker bomb = new MineChecker(); // deleted the class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		cells.fillCells();
		cells.test();
		// board.fillBoard();
		cells.display();
		do {
			System.out.println("Enter the Row No:(From 0 to 9)");
			row = getUserVal(br);
			System.out.println("Enter the Col No:(From 0 to 9)");
			col = getUserVal(br);

			// checking a cell is mine or not Game resp. checking a cell is mine
			// is a resp of Cell.
			// and finding a cell using Row,Column is a resp of cells.
			// cells are a data of Cells class. it should not be accessed in
			// MineChecker. Mine checker is not needed.

			if (cells.hasMineAt(row, col)) {
				System.out
						.println("Sorry..You stepped on a MineChecker...\nGame Over");
				System.exit(0);
			}
			// bomb.checkMine(row, col, cells);
			/*
			 * Board opens a Cell in cells. for this Cells can access its
			 * members.
			 * 
			 * This step makes the Board unused Class. remove Board
			 */
			cells.open(row, col);
			cells.display();

			// Board should not decide winning of Game. It should be in Game
			if (cells.getUnopenedCellsCount() == totalMineCount) {
				System.out.println("Congratulations\n You Won");
				System.exit(0);
			}

		} while (true);
	}

	static int getUserVal(BufferedReader br) throws IOException {
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