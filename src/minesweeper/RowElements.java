package minesweeper;

public class RowElements
{
	private int rmin,rmax;
	public int get_Rmin()
	{
		return rmin;
	}
	public void set_Rmin_Rmax(int row)
	{
		if(row > 0 && row < 9)
		{
			rmin = row-1;
			rmax = row + 1;
		}
	}
	public int get_Rmax()
	{
		return rmax;
	}
	public void check_First_Row(int row)
	{
		if(row == 0)
		{
			rmin = row;
			rmax = row + 1;
		}
	}
	public void check_Last_Row(int row)
	{
		if(row == 9)
		{
			rmin = row - 1;
			rmax = row;
		}
	}
}