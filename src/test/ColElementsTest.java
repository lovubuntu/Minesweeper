/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import minesweeper.ColumnProperties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Prabhu
 */
public class ColElementsTest {

    public ColElementsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of set_Cmin_Cmax method, of class ColumnProperties.
     */
    @Test
    public void testSet_Cmin_Cmax() {
        System.out.println("set_Cmin_Cmax");
        int col = 0;
        ColumnProperties instance = new ColumnProperties();
        instance.setColumnMinAndMax(col);

        System.out.println("Checks the Cols set for counting mines on 1st row");
        instance.setColumnMinAndMax(col);
        assertEquals(0,instance.getColumnMin());
        assertEquals(0,instance.getColumnMax());

        System.out.println("Checks the Cols set for counting mines on 10th row");
        col = 9;
        instance.setColumnMinAndMax(col);
        assertEquals(0,instance.getColumnMin());
        assertEquals(0,instance.getColumnMax());

        System.out.println("Checks the Cols set for counting mines for 2-9 rows");
        for(col = 1;col < 9;col++)
        {
            instance.setColumnMinAndMax(col);
            assertEquals(col-1,instance.getColumnMin());
            assertEquals(col+1,instance.getColumnMax());
        }

    }

    /**
     * Test of check_First_Col method, of class ColumnProperties.
     */
    @Test
    public void testCheck_First_Col() {
        System.out.println("check_First_Col");
        int col = 0;
        ColumnProperties instance = new ColumnProperties();
        instance.checkFirstColumn(col);
        assertEquals(0,instance.getColumnMin());
        assertEquals(1,instance.getColumnMax());
    }

    /**
     * Test of check_Last_Col method, of class ColumnProperties.
     */
    @Test
    public void testCheck_Last_Col() {
        System.out.println("check_Last_Col");
        int col = 9;
        ColumnProperties instance = new ColumnProperties();
        instance.checkLastColumn(col);
        assertEquals(8,instance.getColumnMin());
        assertEquals(9,instance.getColumnMax());
    }

}