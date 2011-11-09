package minesweeper;
class RowElements
{
	private int rmin,rmax;
	int get_Rmin()
	{
		return rmin;
	}
	void set_Rmin_Rmax(int row)
	{
		if(row > 0)
		{
			rmin = row-1;
		}
		if (row < 9 )
		{
			rmax = row + 1;
		}
	}
	int get_Rmax()
	{
		return rmax;
	}
	void check_First_Row(int row)
	{
		if(row == 0)
		{
			rmin = row;
			rmax = row + 1;
		}
	}
	void check_Last_Row(int row)
	{
		if(row == 9)
		{
			rmin = row - 1;
			rmax = row;
		}
	}
}