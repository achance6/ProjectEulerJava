import java.util.ArrayList;

/**
 * Problem: Find the value of d < 1000 for which 1/d contains the 
 * longest recurring cycle in its decimal fraction part.
 */
public final class EP26 implements EulerSolution {
	private final static int LIM = 1000;

	@Override
	public String run() {
		ArrayList<String> nums = new ArrayList<>();
		for (int i = 1; i < LIM; ++i) {
			nums.add(Double.toString((double) 1 / i));
		}
		int longest = 0;
		String biggestCycle = "";
		for (String c : nums) {
			int digits = Methods.DigitsInRecurringCycle(c);
			if (digits > longest) {
				biggestCycle = c;
				longest = digits;
			}
		}
		return null;
	}

}
