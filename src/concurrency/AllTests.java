package concurrency;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({testAdditionTool.class, testEvenNumbersSum.class, testOddNumbersSum.class})
public class AllTests {

}
