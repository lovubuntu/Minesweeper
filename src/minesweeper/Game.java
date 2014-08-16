package minesweeper;

import java.io.*;

class Game {
	// total mine count should be determined by the Game
	private static final int totalMineCount = 10;

	public static void main(String arg[]) throws IOException {

		int row, col;
		Cells box = new Cells();
		Board play = new Board();
		MineChecker bomb = new MineChecker();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		box.fillCells();
		box.test();
		play.fillBoard();
		play.display();
		do {
			System.out.println("Enter the Row No:(From 0 to 9)");
			row = get_User_Val(br);
			System.out.println("Enter the Col No:(From 0 to 9)");
			col = get_User_Val(br);

			bomb.check_Mine(row, col, box);
			play.assignValueOfCellAt(row, col, box);
			play.display();

			// Board should not decide winning of Game. It should be in Game
			if (play.getUnopenedCellsCount() == totalMineCount) {
				System.out.println("Congratulations\n You Won");
				System.exit(0);
			}

		} while (true);
	}

	static int get_User_Val(BufferedReader br) throws IOException {
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