package minesweeper;
class ColElements
{
private int cmin,cmax;
	public int get_Cmin()
	{
		return cmin;
	}
	public void set_Cmin_Cmax(int col)
	{
		if(col > 0 && col < 9)
		{
			cmin = col-1;
			cmax = col + 1;
		}		
	}
	public int get_Cmax()
	{
		return cmax;
	}	
	public void check_First_Col(int col)
	{
		if(col == 0)
		{
			cmin = col;
			cmax = col + 1;
		}
	}
	public void check_Last_Col(int col)
	{
		if(col == 9)
		{
			cmin = col - 1;
			cmax = col;
		}
	}
}