import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public final class Methods {
	
	/**
	 * Generates Fibonacci numbers up to a max number
	 * @param LIM max number to potentially generate
	 * @return ArrayList of fibonacci numbers. Ascending order
	 */
	public static ArrayList<Long> genFibSeq(final long LIM) {
		ArrayList<Long> seq = new ArrayList<>();
		long last_1 = 2;
		long last_2 = 1;
		do {
			seq.add(last_1);
			long tmp = last_1;
			last_1 = last_1 + last_2;
			last_2 = tmp;
		} while (last_1 <= LIM);
		return seq;
	}
	
	/**
	 * Generates Fibonacci numbers up to a max number
	 * @param limit max number to potentially generate
	 * @return ArrayList of string fibonacci numbers. Ascending order
	 */
	public static ArrayList<String> genFibSeq(String limit) {
		ArrayList<String> seq = new ArrayList<>();
		BigInteger last_1 = BigInteger.TWO;
		BigInteger last_2 = BigInteger.ONE;
		seq.add("1"); seq.add("1"); // first two terms;
		do {
			seq.add(last_1.toString());
			BigInteger tmp = new BigInteger(last_1.toString());
			last_1 = last_1.add(last_2);
			last_2 = new BigInteger(tmp.toString());
		} while (last_1.compareTo(new BigInteger(limit)) <= 0);
		return seq;
	}
	
	public static boolean isPalindrome(long num) {
		String n = Long.toString(num);
		ArrayList<Character> firstHalf = new ArrayList<>();
		ArrayList<Character> secondHalf = new ArrayList<>();
		for (int i = 0; i < n.length() / 2; ++i) {
			firstHalf.add(n.charAt(i));
			secondHalf.add(n.charAt(n.length() - 1 - i));
		}
		if (firstHalf.equals(secondHalf)) return true;
		return false;
	}
	
	// Sieve of Eratosthenes
	public static ArrayList<Integer> generatePrimes(int n) {
		if (n < 2) return new ArrayList<Integer>();
		Boolean[] ints = new Boolean[n];
		int p = 2; //smallest prime number
		ints[0] = true; ints[1] = true;
		for (int i = 2; i < n; ++i) ints[i] = false;
		boolean flg = true;
		while (flg) {
			for (int i = 2 * p; i < n; i = i + p) 
				ints[i] = true;
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
	
	public static ArrayList<Integer> genPrimeFactors(long num) {
		ArrayList<Integer> primes;
		if (num > Integer.MAX_VALUE) {
			primes = generatePrimes(Integer.MAX_VALUE);
		}
		else primes = generatePrimes((int) num);
		long result = num;
		ArrayList<Integer> factors = new ArrayList<>();
		while (result != 1) {
			long tmp = result;
			for (int prime : primes) {
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
	
	public static ArrayList<Integer> genPrimeFactors(long num, int lim) {
		ArrayList<Integer> primes = generatePrimes(lim);
		long result = num;
		ArrayList<Integer> factors = new ArrayList<>();
		while (result != 1) {
			long tmp = result;
			for (int prime : primes) {
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
	
	public static ArrayList<Long> genTriangleNumbers(long n) {
		ArrayList<Long> triNums = new ArrayList<>();
		for (long i = 1; i <= n; ++i) {
			triNums.add(Methods.genTriNum(i)); //Summation formula from 1 to N
		}
		return triNums;
	}
	
	/**
	 * Generates the Nth triangle number. Starts at 1.
	 * @param n Nth triangle to generate
	 * @return Nth triangle number
	 */
	public static Long genTriNum(long n) {
		return (n * (n + 1)) / 2; //triangle number formula
	}
	
	public static ArrayList<Long> genCollatzSequence(long n) {
		ArrayList<Long> seq = new ArrayList<>();
		seq.add(n);
		long res = n;
		try {
			while (res != 1) {
				if (res % 2 == 0) {
					res = res / 2;
					seq.add(res);
				}
				else {
					res = (3 * res) + 1;
					seq.add(res);
				}
			}
		} catch (Exception e) {
			return seq;
		}
		return seq;
	}
	
	public static long binCo(long n, long k) {
		return fact(n) / (fact(k) * fact(n - k));
	}
	
	public static BigInteger binCo(BigInteger n, BigInteger k) {
		return fact(n).divide((fact(k).multiply(fact(n.subtract(k)))));
	}
	
	public static long fact(long n) {
		if (n == 0) return 1;
		long result = n;
		while (n > 1) {
			n--;
			result = result * n;
		}
		if (result < 1) throw new IllegalArgumentException("Arithmetic overflow: Input too large");
		else return result;
	}
	
	public static BigInteger fact(BigInteger n) {
		if (n.equals(BigInteger.ZERO)) return BigInteger.ONE;
		BigInteger result = new BigInteger(n.toString());
		while (n.compareTo(BigInteger.ONE) > 0) {
			n = n.subtract(BigInteger.ONE);
			result = result.multiply(n);
		}
		return result;
	}
	
	public static ArrayList<Long> genProperDivisors(long num) {
		ArrayList<Long> factors = new ArrayList<>();
		for (long i = 1; i < num; ++i) {
			if (num % i == 0) factors.add(i);
		}
		return factors;
	}
	
	public static long sumAll(Collection<Long> nums) {
		long sum = 0;
		for (long num : nums) sum += num;
		return sum;
	}
	
	public static long sumProperDivisors(long num) {
		long sum = 0;
		for (long i = 1; i < num; ++i) {
			if (num % i == 0) sum += i;
		}
		return sum;
	}
	
	public static boolean isAmicableNumbers(long a, long b) {
		if (a == b) return false;
		if (sumProperDivisors(a) == b &&
				sumProperDivisors(b) == a) return true;
		return false;
	}
	
	public static boolean isAbundant(long num) {
		return sumProperDivisors(num) > num;
	}

	/**
	 * Generates all permutations of a given array of elements and stores them 
	 * in a set. Utilizes recursive implementation of Heap's algorithm.
	 * @param <T> type of elements in array
	 * @param k length of array
	 * @param elems elements to generate permutations from
	 * @param perms set to store permutations in
	 */
	public static <T> void genPerms(int k, T[] elems, Set<String> perms) {
		if (k == 1) {
			String c = "";
			for (T elem: elems) c += elem;
			perms.add(c);
		}
		else {
			genPerms(k - 1, elems, perms);
			
			for (int i = 0; i < k - 1; ++i) {
				if (k % 2 == 0) 
					swap(elems, i, k - 1);
				else 
					swap(elems, 0, k - 1);
				genPerms(k - 1, elems, perms);
			}
			
		}
	}

	private static <T> void swap(T[] arr, int i, int j) {
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
