import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<>();
		int i = 0;
		// Try to generate lists of primes until 10000 are generated.
		while (primes.size() <= 10_000) {
			primes = generatePrimes(i);
			i += 1000;
		}
		System.out.println(primes.get(10_000));

	}
	
	// Sieve of Eratosthenes
	public static ArrayList<Integer> generatePrimes(int n) {
		if (n < 3) return new ArrayList<>();
		Boolean[] ints = new Boolean[n];
		int p = 2; //smallest prime number
		ints[0] = true; ints[1] = true;
		for (int i = 2; i < n; ++i) {
			ints[i] = false;
		}
		
		boolean flg = true;
		while (flg) {
			for (int i = 2 * p; i < n; i = i + p) {
				ints[i] = true;
			}
			int tmp = p;
			for (int i = p + 1; i < n; ++i) {
				if (!ints[i]) {
					p = i;
					break;
				}
			}
			if (tmp == p) flg = false;
		}
		ArrayList<Integer> primes = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			if (!ints[i]) primes.add(i);
		}
		return primes;
	}

}
