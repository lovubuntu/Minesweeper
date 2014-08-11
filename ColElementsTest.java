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
     * Test of set_Cmin_Cmax method, of class ColElements.
     */
    @Test
    public void testSet_Cmin_Cmax() {
        System.out.println("set_Cmin_Cmax");
        int col = 0;
        ColElements instance = new ColElements();
        instance.set_Cmin_Cmax(col);

        System.out.println("Checks the Cols set for counting mines on 1st row");
        instance.set_Cmin_Cmax(col);
        assertEquals(0,instance.get_Cmin());
        assertEquals(0,instance.get_Cmax());

        System.out.println("Checks the Cols set for counting mines on 10th row");
        col = 9;
        instance.set_Cmin_Cmax(col);
        assertEquals(0,instance.get_Cmin());
        assertEquals(0,instance.get_Cmax());

        System.out.println("Checks the Cols set for counting mines for 2-9 rows");
        for(col = 1;col < 9;col++)
        {
            instance.set_Cmin_Cmax(col);
            assertEquals(col-1,instance.get_Cmin());
            assertEquals(col+1,instance.get_Cmax());
        }

    }

    /**
     * Test of check_First_Col method, of class ColElements.
     */
    @Test
    public void testCheck_First_Col() {
        System.out.println("check_First_Col");
        int col = 0;
        ColElements instance = new ColElements();
        instance.check_First_Col(col);
        assertEquals(0,instance.get_Cmin());
        assertEquals(1,instance.get_Cmax());
    }

    /**
     * Test of check_Last_Col method, of class ColElements.
     */
    @Test
    public void testCheck_Last_Col() {
        System.out.println("check_Last_Col");
        int col = 9;
        ColElements instance = new ColElements();
        instance.check_Last_Col(col);
        assertEquals(8,instance.get_Cmin());
        assertEquals(9,instance.get_Cmax());
    }

}