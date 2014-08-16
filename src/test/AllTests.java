package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BoardTest.class, CellsTest.class, ColElementsTest.class,
		RowElementsTest.class })
public class AllTests {

}
