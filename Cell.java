package minesweeper;
public class Cell
{
private int cell[][] = new int[10][10];
private int total_mines = 10;
public void fill_Cells()
{
	int row_col,row,col;
	while(total_mines > 0)
	{
		row_col 		= (int)(Math.random()*99);
		row				= (int)row_col / 10;
		col				= row_col % 10;		
		total_mines 	= check_Mine_If_Not_Place_One(row,col,total_mines);
	}
}
public int check_Mine_If_Not_Place_One(int row,int col,int total_mines)
{
	if(cell[row][col] != 9)
	{
		cell[row][col] = 9;
		count_Adjacent_Mines(row,col);
		total_mines    = total_mines - 1;
	}
	return total_mines;
}
public void count_Adjacent_Mines(int row,int col)
{
	RowElements rowelt 	= new RowElements();
	rowelt.set_Rmin_Rmax(row);
	rowelt.check_First_Row(row);

    rowelt.check_Last_Row(row);
/*Reaches the Row level for the generated Mine*/
	for(int i = rowelt.get_Rmin();i<=rowelt.get_Rmax();i++)
	{
		set_Local_Mines_Count(i,col);
	}
}
public void set_Local_Mines_Count(int row,int col)
{
	ColElements colelt 	= new ColElements();
	colelt.set_Cmin_Cmax(col);
	colelt.check_First_Col(col);
	colelt.check_Last_Col(col);
/*Goes upto Column level for each row getting passed*/
	for(int j = colelt.get_Cmin();j<=colelt.get_Cmax();j++)
	{
		set_Mine_Count(row,j);
	}
}
public void set_Mine_Count(int row,int col)
{
/*Increments Count if it is not Mine*/
	if(cell[row][col] != 9)
	{
		cell[row][col] += 1;
	}
}
public int get_cell(int row,int col)
{
/*Returns the Cell Value */
	return cell[row][col] ;	
}
public int return_Total_Mines()
{
    return total_mines;
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