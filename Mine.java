package minesweeper;
class Mine
{
int mine = 9;

void check_Mine(int row,int col,Cell box)
{
	int chk_mine = box.get_cell(row,col);
	if(chk_mine == mine)
	{
		System.out.println("It's a Mine... Game Over");
		System.exit(0);
	}
}
}