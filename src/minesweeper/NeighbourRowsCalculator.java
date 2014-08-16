package minesweeper;

public class NeighbourRowsCalculator {
	private int rmin, rmax;

	private int size;

	public int getSize() {
		return size;
	}

	public NeighbourRowsCalculator(int size) {
		this.size = size;
	}

	public int get_Rmin() {
		return rmin;
	}

	public void set_Rmin_Rmax(int row) {
		if (row > 0 && row < getSize() - 1) {
			rmin = row - 1;
			rmax = row + 1;
		}
		check_First_Row(row);
		check_Last_Row(row);
	}

	public int get_Rmax() {
		return rmax;
	}

	private void check_First_Row(int row) {
		if (row == 0) {
			rmin = row;
			rmax = row + 1;
		}
	}

	private void check_Last_Row(int row) {
		if (row == getSize() - 1) {
			rmin = row - 1;
			rmax = row;
		}
	}
}