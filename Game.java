package minesweeper;
import java.io.*;
class Game 
{
	public static void main(String arg[]) throws IOException
	{	
		
		int row,col,test=10;
		Cell  box  = new Cell();
		Board play = new Board();
		Mine  bomb = new Mine();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		box.fill_Cells();
		box.test();
		play.fill_Board();
		play.disp_Board();
		String flag = "Lost",match;
		do{			
			System.out.println("Enter the Row No:(From 0 to 9)")	;
			row = get_User_Val(br);
			System.out.println("Enter the Col No:(From 0 to 9)")	;
			col = get_User_Val(br);

			bomb.check_Mine(row,col,box);
			play.disp_Neighbours(row,col,box);			
			play.disp_Board();
			play.count_Unopened_Cells();
		}while(true);		
	}
	static int get_User_Val(BufferedReader br) throws IOException
		{
			int value = 0;
			while(true){
			try{
				value = Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Please Enter a Number");
				continue;
			}
			if(value < 0 || value > 9)
			{
				System.out.println("Value should be in the range of 0 - 9");
				continue;
			}			
			return value;
			}
		}
}