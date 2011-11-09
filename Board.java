package minesweeper;
import java.util.*;
class Board
{
char[][] result = new char[10][10];
void fill_Board()
{
//Sets the rows to '?'
	for(int i = 0; i <= 9; i++)
	{
		fill_Columns();
	}
}
void fill_Columns()
{
//Sets the columns to '?'
	for(int j = 0;j <= 9; j++)
	{
		result[i][j] = '?';
	}
}
void disp_Neighbours(int row,int col,Cell elements)
{
	RowElements rowelt 	= new RowElements();
	rowelt.set_Rmin_Rmax(row);
	rowelt.check_First_Row(row);
	rowelt.check_Last_Row(row);
//Reaches the Row level for the generated Mine
	for(int i = rowelt.get_Rmin();i<=rowelt.get_Rmax();i++)
	{
		disp_col(i,col,elements);
	}	
}
void disp_col(int row,int col,Cell elements)
{
	ColElements colelt 	= new ColElements();
	colelt.set_Cmin_Cmax(col);
	colelt.check_First_Col(col);
	colelt.check_Last_Col(col);
//Goes upto Column level for each row getting passed
	for(int j = colelt.get_Cmin();j<=colelt.get_Cmax();j++)
	{
		int cell_value	=	elements.get_cell(row,j);
		set_Result_Cell(row,j,cell_value);
	}
}
void set_Result_Cell(int row,int col,int cell_value)
{
	if(cell_value != 9)
	{
		result[row][col] = (char)cell_value;
	}
}
void disp_board()
{
	for(int i = 0; i <= 9; i++)
	{
		get_Columns();
	}
}
void get_Columns()
{
	for(int j = 0;j <= 9; j++)
	{
		System.out.print(result[i][j]+" ");
	}
	System.out.println();
}
}