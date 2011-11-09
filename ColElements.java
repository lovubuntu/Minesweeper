package minesweeper;
class ColElements
{
private int cmin,cmax;
	int get_Cmin()
	{
		return cmin;
	}
	void set_Cmin_Cmax(int col)
	{
		if(col > 0)
		{
			cmin = col-1;
		}		
		if (col < 9 )
		{
			cmax = col + 1;
		}
	}
	int get_Cmax()
	{
		return cmax;
	}	
	void check_First_Col(int col)
	{
		if(col == 0)
		{
			cmin = col;
			cmax = col + 1;
		}
	}
	void check_Last_Col(int col)
	{
		if(col == 9)
		{
			cmin = col - 1;
			cmax = col;
		}
	}
}