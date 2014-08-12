package minesweeper;
public class Cells
{
private int cell[][] = new int[10][10];
private int totalMines = 10;
public void fillCells()
{
	int rowCol,row,col;
	while(totalMines > 0)
	{
		rowCol 		= (int)(Math.random()*99);
		row				= (int)rowCol / 10;
		col				= rowCol % 10;		
		totalMines 	= checkMineIfNotPlaceOne(row,col,totalMines);
	}
}
public int checkMineIfNotPlaceOne(int row,int col,int total_mines)
{
	if(cell[row][col] != 9)
	{
		cell[row][col] = 9;
		countAdjacentMines(row,col);
		total_mines    = total_mines - 1;
	}
	return total_mines;
}
public void countAdjacentMines(int row,int col)
{
	RowElements rowelt 	= new RowElements();
	rowelt.set_Rmin_Rmax(row);
	rowelt.check_First_Row(row);

    rowelt.check_Last_Row(row);
/*Reaches the Row level for the generated MineChecker*/
	for(int i = rowelt.get_Rmin();i<=rowelt.get_Rmax();i++)
	{
		setLocalMinesCount(i,col);
	}
}
public void setLocalMinesCount(int row,int col)
{
	ColumnProperties colelt 	= new ColumnProperties();
	colelt.setColumnMinAndMax(col);
	colelt.checkFirstColumn(col);
	colelt.checkLastColumn(col);
/*Goes upto Column level for each row getting passed*/
	for(int j = colelt.getColumnMin();j<=colelt.getColumnMax();j++)
	{
		setMineCount(row,j);
	}
}
public void setMineCount(int row,int col)
{
/*Increments Count if it is not MineChecker*/
	if(cell[row][col] != 9)
	{
		cell[row][col] += 1;
	}
}
public int getCellAt(int row,int col)
{
/*Returns the Cells Value */
	return cell[row][col] ;	
}
public int getTotalMinesCount()
{
    return totalMines;
}
public void test()
{
	for(int i=0;i<10;i++)
	{
		for(int j=0;j<10;j++)		
			System.out.print(cell[i][j]+" ");
		System.out.println();
	}
}
}