package minesweeper;
class Board
{
private char[][] result;
Board()
{
    result = new char[10][10];
}
public void fill_Board()
{
/*Sets the rows to '?'*/
	for(int i = 0; i <= 9; i++)
	{
		fill_Columns(i);
	}
}
public void fill_Columns(int row)
{
/*Sets the columns to '?'*/
	for(int j = 0;j <= 9; j++)
	{
		result[row][j] = '?';
	}
}
public void get_Cell_Value_To_Board(int row,int col,Cell elements)
{
	int cell_value	=	elements.get_cell(row,col);
	if(cell_value != 9)
	{
		result[row][col] = Character.forDigit(cell_value, 10); 
	}
}
public void disp_Board()
{
	for(int i = 0; i <= 9; i++)
	{
		disp_Columns(i);
	}
}
public void disp_Columns(int row)
{
	for(int j = 0;j <= 9; j++)
	{
		System.out.print(result[row][j]+" ");
	}
	System.out.println();
}
public void count_Unopened_Cells()
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
public int count_Unopened_Cols(int row,int ucells_count)
{	
	for(int col = 0; col <10; col++)
	{
		ucells_count = check_Unopened_cell(row,col,ucells_count);
	}
	return ucells_count;
}
public int check_Unopened_cell(int row,int col,int ucells_count)
{
	char unopened = '?';
	if(result[row][col] == unopened)
	{
		ucells_count++;
	}
	return ucells_count;
}
}