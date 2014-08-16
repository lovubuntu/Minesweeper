package minesweeper;

class MineChecker {
	private int mineValue = 9;

	public void checkMine(int row, int col, Cells box) {
		int cellValue = box.getCellAt(row, col).getValue();
		if (cellValue == mineValue) {
			System.out
					.println("Sorry..You stepped on a MineChecker...\nGame Over");
			System.exit(0);
		}
	}
}