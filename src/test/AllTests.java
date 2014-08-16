package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GridTest.class, ColElementsTest.class, RowElementsTest.class,
		CellTest.class })
public class AllTests {

}
