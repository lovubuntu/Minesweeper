package minesweeper;
import java.util.*;
class Cell
{
char[][] res = new char[10][10];
int cell[][] = new int[10][10];
void fill_Cells()
{
	int total_mines = 10,row_col,row,col;
	Random rand 		= new Random();
	while(total_mines > 0)
	{
		row_col 		= (int)(Math.random()*99);
		row				= (int)row_col / 10;
		col				= row_col % 10;		
		total_mines 	= check_For_Mine(row,col,total_mines);		
	}	
}
int check_For_Mine(int row,int col,int total_mines)
{
	if(cell[row][col] != 9)
	{
		cell[row][col] = 9;
		count_Adjacent_Mines(row,col);
		total_mines    = total_mines - 1;
	}
	return total_mines;
}
void count_Adjacent_Mines(int row,int col)
{
	RowElements rowelt 	= new RowElements();
	rowelt.set_Rmin_Rmax(row);
	rowelt.check_First_Row(row);
	rowelt.check_Last_Row(row);
//Reaches the Row level for the generated Mine
	for(int i = rowelt.get_Rmin();i<=rowelt.get_Rmax();i++)
	{
		set_Local_Mines_Count(i,col);
	}
}
void set_Local_Mines_Count(int row,int col)
{
	ColElements colelt 	= new ColElements();
	colelt.set_Cmin_Cmax(col);
	colelt.check_First_Col(col);
	colelt.check_Last_Col(col);
//Goes upto Column level for each row getting passed
	for(int j = colelt.get_Cmin();j<=colelt.get_Cmax();j++)
	{
		set_Mine_Count(row,j);
	}
}
void set_Mine_Count(int row,int col)
{
//Increments Count if it is not Mine
	if(cell[row][col] != 9)
	{
		cell[row][col] += 1;
	}
}
int get_cell(int row,int col)
{
//Returns the Cell Value
	return cell[row][col] ;	
}


void test()
{
	for(int i=0;i<10;i++)
	{
		for(int j=0;j<10;j++)		
			System.out.print(cell[i][j]+" ");
		System.out.println();
	}
}
void log(int row_col,int row,int col)
{
	System.out.println(row_col+" "+row+" "+col);
}
}