/**
 * Problem: What is the value of the first triangle number 
 * to have over five hundred divisors?
 */
public class EP12 implements EulerSolution {
	private static final int DIVISOR_AMOUNT = 500;
	
	@Override
	public String run() {
		long divisors = 0, cur = 1;
		while (divisors <= DIVISOR_AMOUNT) {
			long triNum = Methods.genTriNum(cur);
			/* Checking up to sqrt(num) will yield approx(?) half of its factors.
			 * can then add 2 to the divisors for every factor under sqrt(num) found
			 * Unsure if cases where this fails.
			 */
			for (int j = 1; j <= Math.sqrt(triNum); ++j) {
				if (triNum % j == 0) {
					divisors += 2;
				}
				if (divisors > DIVISOR_AMOUNT) return Long.toString(triNum); //shortcut
			}
			divisors = 0;
			cur++;
		}
		return "Error";
	}

}
