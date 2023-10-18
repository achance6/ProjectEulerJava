/**
 * Problem: By considering the terms in the Fibonacci sequence 
 * whose values do not exceed four million, find the sum of the even-valued terms.
 */
public class EP2 implements EulerSolution {
	static final int LIMIT = 4_000_000;
	
	@Override
	public String run() {
		int last_1 = 2;
		int last_2 = 1;
		int sum = 0;
		do {
			if (last_1 % 2 == 0) sum += last_1;
			int tmp = last_1;
			last_1 = last_1 + last_2;
			last_2 = tmp;
		} while (last_1 < LIMIT);
		return Integer.toString(sum);
	}

}
