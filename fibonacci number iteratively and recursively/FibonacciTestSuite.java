package fibonacci;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fibonacci.tests.IterativeFibonacciTest;
import fibonacci.tests.RecursiveFibonacciTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ RecursiveFibonacciTest.class, IterativeFibonacciTest.class })
public class FibonacciTestSuite {
}
