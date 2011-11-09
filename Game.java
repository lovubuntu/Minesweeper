package minesweeper;
import java.io.*;
class Game 
{
	public static void main(String arg[]) throws IOException
	{
		Cell box = new Cell();
		box.fill_Cells();
		box.test();
		Board play = new Board();
		play.fill_Board();
		play.disp_Board();
		String flag = "Lost",match;
		int row,col,test=10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do{			
			System.out.println("Enter the Row No:(From 0 to 9)")	;
			row = get_User_Val(br);
			System.out.println("Enter the Col No:(From 0 to 9)")	;
			col = get_User_Val(br);
			play.disp_Neighbours(row,col,box);			
			play.disp_Board();
			test--;
		}while(test>0);		
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
				//System.exit(0);
			}
			if(value < 0 || value > 9)
			{
				System.out.println("Value should be in the range of 0 - 9");
				continue;
				//System.exit(0);
			}			
			return value;
			}
		}
}