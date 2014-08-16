package minesweeper;

import java.io.*;

class Game {
	// total mine count should be determined by the Game
	private static final int totalMineCount = 10;

	public static void main(String arg[]) throws IOException {

		int row, col;
		Cells cells = new Cells();
		Board board = new Board();
		MineChecker bomb = new MineChecker();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		cells.fillCells();
		cells.test();
		board.fillBoard();
		board.display();
		do {
			System.out.println("Enter the Row No:(From 0 to 9)");
			row = getUserVal(br);
			System.out.println("Enter the Col No:(From 0 to 9)");
			col = getUserVal(br);

			bomb.checkMine(row, col, cells);
			board.open(row, col, cells);
			board.display();

			// Board should not decide winning of Game. It should be in Game
			if (board.getUnopenedCellsCount() == totalMineCount) {
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