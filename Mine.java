package minesweeper;
class Mine
{
private int mine = 9;

public void check_Mine(int row,int col,Cell box)
{
	int chk_mine = box.get_cell(row,col);
	if(chk_mine == mine)
	{
		System.out.println("Sorry..You stepped on a Mine...\nGame Over");
		System.exit(0);
	}
}
}