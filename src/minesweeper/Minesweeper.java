package minesweeper;

import java.io.*;

class Minesweeper {
	boolean allMinesIdentified = false;
	boolean openedMine = false;
	Grid grid;
	private int maxInput;

	public Minesweeper(int lengthOfFieldSquareSide,
			CellsValuePopulator cellsValuePopulator) throws IOException {
		grid = new Grid(lengthOfFieldSquareSide, cellsValuePopulator);
		calculateMaxInputRange();
		// play();

	}

	public void play() throws IOException {
		grid.display();

		int row;
		int col;
		int action;
		do {
			IOUtil.println("Enter the Row No:(From 0 to " + maxInput + ")");
			row = getUserVal();
			IOUtil.println("Enter the Col No:(From 0 to " + maxInput + ")");
			col = getUserVal();
			IOUtil.println("Enter the Option : For Open press 1, For Flag Press 2");
			action = getAction();
			if (action == 1)
				openedMine = !open(row, col);
			else if (action == 2)
				flag(row, col);
			grid.display();
		} while (!grid.isIdentifiedAllMines() && !openedMine);

		decideGameStatus();
	}

	private void calculateMaxInputRange() {
		maxInput = (grid.getSize() - 1);
	}

	private int getMaxInput() {
		return maxInput;
	}

	private boolean open(int row, int col) {
		return grid.open(row, col);
	}

	private void flag(int row, int col) {
		grid.flag(row, col);
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
			if (value < 0 || value > getMaxInput()) {
				IOUtil.println("Value should be in the range of 0 -"
						+ getMaxInput());
				continue;
			}
			return value;
		}
	}

	int getAction() throws IOException {
		int value = 0;
		while (true) {
			try {
				value = Integer.parseInt(IOUtil.read());
			} catch (NumberFormatException nfe) {
				IOUtil.println("Please Enter a Number");
				continue;
			}
			if (value != 1 && value != 2) {
				IOUtil.println("Option should be 1 or 2");
				continue;
			}
			return value;
		}

	}
}