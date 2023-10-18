import java.util.ArrayList;

/**
 * Problem: What is the largest prime factor of the number 600851475143?
 */
public class EP3 implements EulerSolution {
	static final int PRIME_GEN_LIMIT = 100_000;
	
	@Override
	public String run() {
		long result = Long.parseLong("600851475143");
		ArrayList<Integer> factors = Methods.genPrimeFactors(result, PRIME_GEN_LIMIT);
		factors.sort(null);
		return Integer.toString(factors.get(factors.size() - 1));
	}

}
