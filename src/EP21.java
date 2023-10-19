/**
 * Problem: Evaluate the sum of all the amicable numbers under 10000.
 */
public class EP21 implements EulerSolution {

	@Override
	public String run() {
		long sum = 0;
		for (long i = 1; i < 10_000; ++i) {
			long j = Methods.sumProperDivisors(i);
			if (Methods.isAmicableNumbers(i, j)) {
				sum += i + j;
			}
		}
		return Long.toString(sum);
	}

}
