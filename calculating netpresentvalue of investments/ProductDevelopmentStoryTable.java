package netpresentvalue;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ProductDevelopmentStoryTable {
	public static void main(String[] args) {
		// modified from unknown author

		//
		// Story parameters from https://en.wikipedia.org/wiki/Net_present_value#Example
		//
		int investment = 100000;
		int payout = 10000;
		double r = 0.10;

		System.out.println(" Year    Present Value    Net Present Value");
		System.out.println("======  ===============  ===================");

		for (int year = 0; year <= 12; ++year) {
			double dollars = year == 0 ? -investment : payout;
			double presentValueThisYear = NPV.presentValue(dollars, year, r);
			double netPresentValue = NPV.netPresentValue(investment, year, payout, r);
			String text = String.format(" T=%2d   %12.2f  %17.2f", year, presentValueThisYear, netPresentValue);
			System.out.println(text);
		}

		System.out.println();
		System.out.println();
		System.out.println("Note: Your table may differ from wikipedia's results by a cent.");
		System.out.println("      https://en.wikipedia.org/wiki/Net_present_value#Example");
		System.out.println("      This appears to be due to wikipedia rounding each year to the nearest cent.");
		System.out.println("      Do not worry about this difference.");
	}
}
