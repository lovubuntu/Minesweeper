/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package minesweeper;

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
     * Test of set_Rmin_Rmax method, of class RowElements.
     */
    @Test
    public void testSet_Rmin_Rmax() {
        System.out.println("sets Rmin Rmax");
        int row = 0;
        RowElements instance = new RowElements();

        System.out.println("Checks the rows set for counting mines on 1st row");
        instance.set_Rmin_Rmax(row);
        assertEquals(0,instance.get_Rmin());
        assertEquals(0,instance.get_Rmax());

        System.out.println("Checks the rows set for counting mines on 10th row");
        row = 9;
        instance.set_Rmin_Rmax(row);
        assertEquals(0,instance.get_Rmin());
        assertEquals(0,instance.get_Rmax());

        System.out.println("Checks the rows set for counting mines for 2-9 rows");
        for(row=1;row<9;row++)
        {
            instance.set_Rmin_Rmax(row);
            assertEquals(row-1,instance.get_Rmin());
            assertEquals(row+1,instance.get_Rmax());
        }

    }


    /**
     * Test of check_First_Row method, of class RowElements.
     */
    @Test
    public void testCheck_First_Row() {
        System.out.println("Checks 1st 2 rows are acted on selecting 1st row");
        int row = 0;
        RowElements instance = new RowElements();
        instance.check_First_Row(row);
        assertEquals(0,instance.get_Rmin());
        assertEquals(1,instance.get_Rmax());
    }

    /**
     * Test of check_Last_Row method, of class RowElements.
     */
    @Test
    public void testCheck_Last_Row() {
        System.out.println("Checks last 2 rows are acted on selecting 10th row");
        int row = 9;
        RowElements instance = new RowElements();
        instance.check_Last_Row(row);
        assertEquals(8,instance.get_Rmin());
        assertEquals(9,instance.get_Rmax());
    }

}