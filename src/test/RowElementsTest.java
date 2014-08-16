/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import minesweeper.RowProperties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Prabhu
 */
public class RowElementsTest {

	public RowElementsTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	/**
	 * Test of set_Rmin_Rmax method, of class RowProperties.
	 */
	@Test
	public void testSet_Rmin_Rmax() {
		System.out.println("sets Rmin Rmax");
		int row = 0;
		RowProperties instance = new RowProperties(3);

		System.out.println("Checks the rows set for counting mines on 1st row");
		instance.set_Rmin_Rmax(row);
		assertEquals(0, instance.get_Rmin());
		assertEquals(1, instance.get_Rmax());

		System.out.println("Checks the rows set for counting mines on 3th row");
		row = 2;
		instance.set_Rmin_Rmax(row);
		assertEquals(1, instance.get_Rmin());
		assertEquals(2, instance.get_Rmax());

		row = 1;
		instance.set_Rmin_Rmax(row);
		assertEquals(row - 1, instance.get_Rmin());
		assertEquals(row + 1, instance.get_Rmax());

	}

}