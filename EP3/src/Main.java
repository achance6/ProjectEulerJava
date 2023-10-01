import java.util.ArrayList;
import java.util.Scanner;

/**
 * Problem: What is the largest prime factor of the number 600851475143?
 */
public class Main {

	public static void main(String[] args) {
		final int PRIME_GEN_LIMIT = 100_000;
		Scanner scnr = new Scanner(System.in);
		System.out.println("Input number to compute prime factorization: ");
		long init = 0, result = scnr.nextLong();
		init = result;
		ArrayList<Integer> factors = new ArrayList<>();
		ArrayList<Integer> primeNumbers = generatePrimes(PRIME_GEN_LIMIT);
		while (result != 1) {
			long tmp = result;
			for (int prime : primeNumbers) {
				if (result % prime == 0) {
					factors.add(prime);
					result = result / prime;
					// System.out.println(prime + " " + tmp);
					break;
				}
			}
			if (tmp == result) break;
		}
		System.out.println(factors);
		factors.sort(null);
		System.out.println(factors.get(factors.size() - 1) + " is the largest prime factor of "
				+ init);
		scnr.close();
	}
	
	// Sieve of Eratosthenes
	static ArrayList<Integer> generatePrimes(int n) {
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
