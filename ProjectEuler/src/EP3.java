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
		factors.sort((a, b) -> b - a); //reverse natural order (descending)
		return Integer.toString(factors.get(0));
	}

}
