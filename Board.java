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
		fill_Columns(i);
	}
}
void fill_Columns(int row)
{
//Sets the columns to '?'
	for(int j = 0;j <= 9; j++)
	{
		result[row][j] = '?';
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
		result[row][col] = Character.forDigit(cell_value, 10); 
	}
}
void disp_Board()
{
	for(int i = 0; i <= 9; i++)
	{
		get_Columns(i);
	}
}
void get_Columns(int row)
{
	for(int j = 0;j <= 9; j++)
	{
		System.out.print(result[row][j]+" ");
	}
	System.out.println();
}
void count_Unopened_Cells()
{
	int ucells_count = 0;
	for(int i=0;i<10;i++)
	{
		ucells_count = count_Unopened_Cols(i,ucells_count);
	}


	if(ucells_count == 10)
	{
		System.out.println("Congratulations\n You Won");
		System.exit(0);
	}
}
int count_Unopened_Cols(int row,int ucells_count)
{	
	for(int col = 0; col <10; col++)
	{
		ucells_count = check_Unopened_cell(row,col,ucells_count);
	}
	return ucells_count;
}
int check_Unopened_cell(int row,int col,int ucells_count)
{
	char unopened = '?';
	if(result[row][col] == unopened)
	{
		ucells_count++;
	}
	return ucells_count;
}
}