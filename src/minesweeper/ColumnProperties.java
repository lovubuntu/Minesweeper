package minesweeper;

public class ColumnProperties
{
private int columnMin,columnMax;
	public int getColumnMin()
	{
		return columnMin;
	}
	public void setColumnMinAndMax(int column)
	{
		if(column > 0 && column < 9)
		{
			columnMin = column-1;
			columnMax = column + 1;
		}		
	}
	public int getColumnMax()
	{
		return columnMax;
	}	
	public void checkFirstColumn(int column)
	{
		if(column == 0)
		{
			columnMin = column;
			columnMax = column + 1;
		}
	}
	public void checkLastColumn(int column)
	{
		if(column == 9)
		{
			columnMin = column - 1;
			columnMax = column;
		}
	}
}