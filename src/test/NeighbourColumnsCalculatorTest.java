/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import minesweeper.NeighbourColumnsCalculator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Prabhu
 */
public class NeighbourColumnsCalculatorTest {

	public NeighbourColumnsCalculatorTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	/**
	 * Test of set_Cmin_Cmax method, of class NeighbourColumnsCalculator.
	 */
	@Test
	public void testSet_Cmin_Cmax() {
		System.out.println("set_Cmin_Cmax");
		int col = 0;
		NeighbourColumnsCalculator instance = new NeighbourColumnsCalculator(10);
		instance.setColumnMinAndMax(col);

		System.out.println("Checks the Cols set for counting mines on 1st row");
		instance.setColumnMinAndMax(col);
		assertEquals(0, instance.getColumnMin());
		assertEquals(1, instance.getColumnMax());

		System.out
				.println("Checks the Cols set for counting mines on 10th row");
		col = 9;
		instance.setColumnMinAndMax(col);
		assertEquals(8, instance.getColumnMin());
		assertEquals(9, instance.getColumnMax());

		System.out.println("Checks the Cols set for mid level");
		col = 5;
		instance.setColumnMinAndMax(col);
		assertEquals(col - 1, instance.getColumnMin());
		assertEquals(col + 1, instance.getColumnMax());

	}

}