import java.util.ArrayList;

/**
 * Problem: Find the sum of all the primes below two million.
 */
public class EP10 implements EulerSolution {

	@Override
	public String run() {
		ArrayList<Integer> primes = Methods.generatePrimes(2_000_000);
		long sum = 0;
		for (int i : primes) sum += i;
		return Long.toString(sum);
	}

}
