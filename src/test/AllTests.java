package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GridTest.class, NeighbourColumnsCalculatorTest.class, NeighbourRowsCalculatorTest.class,
		CellTest.class })
public class AllTests {

}
