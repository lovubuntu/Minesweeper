package test;

import junit.framework.Assert;
import minesweeper.Cell;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CellTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsMine() {
		Cell cell = new Cell();
		cell.setNeighbourMinesCount(1);
		Assert.assertEquals(false, cell.isMine());
		cell.setNeighbourMinesCount(Cell.MINE_VALUE);
		Assert.assertEquals(true, cell.isMine());

	}

	@Test
	public void testIsOpened() {
		Cell cell = new Cell();
		Assert.assertEquals(false, cell.isOpened());
		cell.open();
		Assert.assertEquals(true, cell.isOpened());

	}

}
