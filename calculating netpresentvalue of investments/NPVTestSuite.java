package netpresentvalue;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import netpresentvalue.tests.FutureValueTest;
import netpresentvalue.tests.NetPresentValueTest;
import netpresentvalue.tests.PresentValueTest;
import netpresentvalue.tests.ProductDevelopmentStoryTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ FutureValueTest.class, PresentValueTest.class, ProductDevelopmentStoryTest.class,
		NetPresentValueTest.class })
public class NPVTestSuite {

}
