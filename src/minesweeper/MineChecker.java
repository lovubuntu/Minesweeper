package minesweeper;
class MineChecker
{
private int mine = 9;

public void check_Mine(int row,int col,Cells box)
{
	int chk_mine = box.getCellAt(row,col);
	if(chk_mine == mine)
	{
		System.out.println("Sorry..You stepped on a MineChecker...\nGame Over");
		System.exit(0);
	}
}
}