/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import minesweeper.Cell;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Prabhu
 */
public class CellTest {

    public CellTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of fill_Cells method, of class Cell.
     */
    @Test
    public void test_Fill_Cells_PopulatesMinesAndOtherCells() {
        Cell instance = new Cell();
        System.out.println("Checks whether total no. mines is 10");
        assertEquals(10,instance.return_Total_Mines());
        System.out.println("Checks 10 cells are mines & others no.of mines nearby");
        instance.fill_Cells();
        assertEquals(0,instance.return_Total_Mines());
    }

    /**
     * Test of check_For_Mine method, of class Cell.
     */
    @Test
    public void testCheck_Mine_If_Not_Place_One() {
        System.out.println("Tests Check Mine If Not Place One");
        int row = 0;
        int col = 0;
        int total_mines = 0;
        int row_col;
        Cell instance = new Cell();
        while(total_mines > 0)
        {
            row_col 		= (int)(Math.random()*99);
            row				= (int)row_col / 10;
            col				= row_col % 10;
        assertEquals(instance.return_Total_Mines(),
                instance.check_Mine_If_Not_Place_One(row,col,total_mines));
        }

    }

    /**
     * Test of set_Mine_Count method, of class Cell.
     */
    @Test
    public void test_Set_Mine_Count_IncrementsNeighbouringCellCountByOne() {
        System.out.println("Tests Mine Neighbouring cells are incremented");
        int row = 0;
        int col = 0;
        int mine_count = 0;
        Cell instance = new Cell();
        instance.set_Mine_Count(row, col);
        assertEquals(mine_count+1,instance.get_cell(row, col));
    }

}