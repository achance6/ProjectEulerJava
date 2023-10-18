import java.util.ArrayList;

/**
 * Problem: What is the 10001st prime number?
 */
public class EP7 implements EulerSolution {

	private static final int LIM = 10_001;
	
	@Override
	public String run() {
		ArrayList<Integer> primes = new ArrayList<>();
		int i = 0;
		// Try to generate lists of primes until 10000 are generated.
		while (primes.size() < LIM) {
			primes = Methods.generatePrimes(i);
			i += 1000;
		}
		return Integer.toString(primes.get(LIM - 1));
	}

}
