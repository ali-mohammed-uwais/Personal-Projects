package sortanalysis;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import sortanalysis.tests.EchoInputTestSuite;
import sortanalysis.tests.FormatTestSuite;
import sortanalysis.tests.MaxTestSuite;
import sortanalysis.tests.MeanTestSuite;
import sortanalysis.tests.MedianTestSuite;
import sortanalysis.tests.MinTestSuite;
import sortanalysis.tests.RangeTestSuite;
import sortanalysis.tests.SortedTestSuite;
import support.cse131.SystemOutputUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ FormatTestSuite.class, EchoInputTestSuite.class, SortedTestSuite.class, MeanTestSuite.class,
		MedianTestSuite.class, MinTestSuite.class, MaxTestSuite.class, RangeTestSuite.class })
public class DataSortingAndAnalysisTestSuite {
	public static String invokeMainWithSizeAndContents(Integer... data) throws IOException {
		return invokeMainWithSizeAndContents(Arrays.asList(data));
	}

	public static String invokeMainWithSizeAndContents(List<Integer> data) throws IOException {
		String[] args = new String[data.size() + 1];
		args[0] = Integer.toString(data.size());
		int i = 1;
		for (int v : data) {
			args[i] = Integer.toString(v);
			++i;
		}
		return SystemOutputUtils.capture(() -> {
			DataSortingAndAnalysis.main(args);
		});
	}
}
