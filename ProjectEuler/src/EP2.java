/**
 * Problem: By considering the terms in the Fibonacci sequence 
 * whose values do not exceed four million, find the sum of the even-valued terms.
 */
public class EP2 implements EulerSolution {
	static final int LIMIT = 4_000_000;
	
	@Override
	public String run() {
		long sum = 0;
		for (Long c : Methods.genFibSeq(LIMIT)) {
			if (c % 2 == 0) sum += c;
		}
		return Long.toString(sum);
	}
}
