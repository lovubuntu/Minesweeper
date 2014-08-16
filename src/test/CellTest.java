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
		cell.setValue(1);
		Assert.assertEquals(false, cell.isMine());
		cell.setValue(9);
		Assert.assertEquals(true, cell.isMine());

	}

}
