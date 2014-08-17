package minesweeper;

import java.io.IOException;

public class Player {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		new Minesweeper(10, new RandomGridFiller()).play();
		
	}

}
