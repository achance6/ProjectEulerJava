import java.util.ArrayList;

/**
 * Problem: What is the value of the first triangle number 
 * to have over five hundred divisors?
 */
public class Main {
	private static final int DIVISOR_AMOUNT = 500;

	public static void main(String[] args) {
		ArrayList<Integer> triNums;
		int divisors = 0;
		int j = 16384;
		while (divisors <= DIVISOR_AMOUNT) {
			System.out.println("Trying " + j + " triangle numbers");
			triNums = genTriangleNumbers(j);
			for (int triNum : triNums) {
				divisors = 0;
				for (int i = 1; i <= triNum; ++i) {
					if (triNum % i == 0) {
						divisors++;
					}
				}
				//System.out.println(triNum + " has " + divisors + " divisors.");
				if (divisors > DIVISOR_AMOUNT) {
					System.out.println(triNum + " has " + divisors + " divisors.");
					break;
				}
			}
			j = j * 2;
		}

	}

	private static ArrayList<Integer> genTriangleNumbers(int n) {
		ArrayList<Integer> triNums = new ArrayList<>();
		for (int i = 1; i <= n; ++i) {
			triNums.add((i * (i + 1)) / 2); //Summation formula from 1 to N
		}
		return triNums;
	}
	
	private static ArrayList<Integer> genPrimeFactors(long num, ArrayList<Integer> primeNumbers) {
		ArrayList<Integer> factors = new ArrayList<>();
		long result = num;
		while (result != 1) {
			long tmp = result;
			for (int prime : primeNumbers) {
				if (result % prime == 0) {
					factors.add(prime);
					result = result / prime;
					break;
				}
			}
			if (tmp == result) break;
		}
		return factors;
	}
	
	// Sieve of Eratosthenes
		private static ArrayList<Integer> generatePrimes(int n) {
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
