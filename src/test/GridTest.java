/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import minesweeper.Grid;
import minesweeper.RandomGridFiller;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Prabhu
 */
public class GridTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	/**
	 * Test of fill_Cells method, of class Grid.
	 */


	@Test
	public void testGetUnopenedCellsCount() {
		Grid cells = new Grid(10, new RandomGridFiller());
		assertEquals(100, cells.getUnopenedCellsCount());
		cells.open(0, 0);
		cells.open(1, 1);
		cells.open(1, 2);
		assertEquals(97, cells.getUnopenedCellsCount());
	}
}