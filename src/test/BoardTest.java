/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import minesweeper.Board;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Prabhu
 */
public class BoardTest {

	public BoardTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	/**
	 * Test of count_Unopened_Cols method, of class Board.
	 */
	@Test
	public void testCount_Unopened_Cols_InGivenRow() {
		System.out.println("count Unopened Cols in a Row");
		int row = 0;
		int ucells_count = 0;
		int expResult = 10;
		Board instance = new Board();
		instance.fill_Board();
		int result = instance.count_Unopened_Cols(row, ucells_count);
		assertEquals(expResult, result);
	}

	/**
	 * Test of check_Unopened_cell method, of class Board.
	 */
	@Test
	public void testCheck_Unopened_cell_IncrementsCountByOneIfUnOpened() {
		System.out.println("check Unopened cell");
		int row = 0;
		int col = 0;
		int ucells_count = 0;
		Board instance = new Board();
		instance.fill_Board();
		int expResult = 1;
		int result = instance.check_Unopened_cell(row, col, ucells_count);
		assertEquals(expResult, result);
	}

}