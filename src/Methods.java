import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
		seq.add((long) 1); seq.add((long) 1); // first two terms
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
	
	/**
	 * Determines if the given number is a palindrome.
	 * A palindrome number is a number which is the same
	 * read forwards or backwards.
	 * @param num Number to check
	 * @return True if num is a palindrome
	 */
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
	
	/**
	 * Generates list of prime numbers up to a given number.
	 * Uses Sieve of Eratosthenes algorithm
	 * @param n Highest prime to potentially generate
	 * @return ArrayList of primes. Ascending order.
	 */
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
	
	/**
	 * Generate list of prime factors of a number.
	 * Warning: Large number can be extremely computationally costly.
	 * @param num Number to generate prime factors of
	 * @return ArrayList containing Prime Factors
	 */
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
	
	/**
	 * Generate list of prime factors of a number. 
	 * Limit parameter applied for performance purposes only as
	 * generating primes up to a given number can become extremely costly.
	 * @param num Number to calculate prime factors of
	 * @param lim Highest prime number to generate
	 * @return ArrayList of prime factors of a number
	 */
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
	
	/**
	 * Generates triangle numbers up to a given number
	 * @param n highest triangle number to generate
	 * @return ArrayList of triangle numbers up to n
	 */
	public static ArrayList<Long> genTriangleNumbers(long n) {
		ArrayList<Long> triNums = new ArrayList<>();
		for (long i = 1; i <= n; ++i) {
			triNums.add(genTriNum(i)); //Summation formula from 1 to N
		}
		return triNums;
	}
	
	/**
	 * Generates the Nth triangle number. 1-based index.
	 * @param n Nth triangle to generate
	 * @return Nth triangle number
	 */
	public static Long genTriNum(long n) {
		return (n * (n + 1)) / 2; //triangle number formula
	}
	
	/**
	 * Generates Collatz Sequence for a given number.
	 * Collatz sequence is generated by taking a given positive number and
	 * if even, divide by 2; if odd, triple it and add 1 until the result
	 * is 1. Throws exception 
	 * if given non-positive number or if overflow occurs.
	 * @param n Number to use to generate sequence
	 * @return ArrayList containing Collatz sequence. 
	 * First element is always the given number.
	 */
	public static ArrayList<Long> genCollatzSequence(long n) {
		if (n < 1) { 
			throw new IllegalArgumentException
			("Collatz Sequence doesn't work on non-positive numbers"); 
		}
		ArrayList<Long> seq = new ArrayList<>();
		seq.add(n);
		long result = n;
		
		// Collatz Sequence
		while (result != 1) {
			if (result % 2 == 0) {
				result = result / 2;
				seq.add(result);
			}
			else {
				// in case of overflow
				result = Math.addExact(Math.multiplyExact(3, result), 1);
				seq.add(result);
			}
		}
		return seq;
	}
	
	/**
	 * Returns binomial coefficient of two longs. 
	 * Also known as n choose k
	 * @param n
	 * @param k
	 * @return binomial coefficient
	 */
	public static long binCo(long n, long k) {
		return fact(n) / (fact(k) * fact(n - k));
	}
	
	/**
	 * Returns binomial coefficient of two BigInteger objects
	 * @param n
	 * @param k
	 * @return binomial coefficient
	 */
	public static BigInteger binCo(BigInteger n, BigInteger k) {
		return fact(n).divide((fact(k).multiply(fact(n.subtract(k)))));
	}
	
	/**
	 * Returns factorial of a long. 
	 * Throws exception if computation results in overflow.
	 * @param n number to compute factorial of
	 * @return factorial of n
	 */
	public static long fact(long n) {
		if (n < 0) 
			throw new IllegalArgumentException
			("Illegal argument, can't compute factorial of a negative.");
		if (n == 0) return 1;
		long result = n;
		while (n > 1) {
			n--;
			// Throws exception if results in overflow
			result = Math.multiplyExact(result, n); 
		}
		return result;
	}
	
	/**
	 * Returns factorial of a BigInteger. Can't overflow!
	 * @param n number to compute factorial of
	 * @return factorial of n
	 */
	public static BigInteger fact(BigInteger n) {
		if (n.compareTo(BigInteger.ZERO) < 0) 
			throw new IllegalArgumentException
			("Illegal argument, can't compute factorial of a negative.");
		// 0! == 1
		if (n.equals(BigInteger.ZERO)) { return BigInteger.ONE; }
		
		BigInteger result = new BigInteger(n.toString());
		while (n.compareTo(BigInteger.ONE) > 0) {
			n = n.subtract(BigInteger.ONE);
			result = result.multiply(n);
		}
		return result;
	}
	
	/**
	 * Generates proper divisors of a number.
	 * Proper divisors of a natural number are all positive divisors that
	 * are less than the number.
	 * @param num Number to calculate proper divisors of
	 * @return ArrayList containing all proper divisors in ascending order.
	 */
	public static ArrayList<Long> genProperDivisors(long num) {
		ArrayList<Long> factors = new ArrayList<>();
		// TODO: Crude way, could be improved
		for (long i = 1; i < num; ++i) {
			if (num % i == 0) factors.add(i);
		}
		return factors;
	}
	
	/**
	 * Sums all longs within a List
	 * @param nums collection of longs
	 * @return sum of all longs in List
	 */
	public static long sumAll(List<Long> nums) {
		long sum = 0;
		for (long num : nums) sum += num;
		return sum;
	}
	
	/**
	 * Sums the proper divisors of a number.
	 * Proper divisors of a natural number are all positive divisors that
	 * are less than the number.
	 * @param num number to get sum of proper divisors from
	 * @return sum of proper divisors
	 */
	public static long sumProperDivisors(long num) {
		long sum = 0;
		for (long i = 1; i < num; ++i) {
			if (num % i == 0) sum += i;
		}
		return sum;
	}
	
	/**
	 * Calculates whether two numbers are "amicable"
	 * Amicable numbers are numbers a and b 
	 * where the sum of the proper divisors of a is equal to b
	 * and the sum of the proper divisors of b is equal to a
	 * @param a
	 * @param b
	 * @return True if a and b are amicable
	 */
	public static boolean isAmicableNumbers(long a, long b) {
		if (a == b) return false; // Number can't be amicable with itself
		if (sumProperDivisors(a) != b || 
			sumProperDivisors(b) != a) return false;
		return true;
	}
	
	/**
	 * Determines whether given number is "abundant."
	 * A number is abundant if the sum of its proper divisors
	 * are greater than the number itself. 
	 * @param num Number to check if abundant
	 * @return True if abundant
	 */
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

	/**
	 * Swaps two elements in an array
	 * @param <T> Type of array
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static <T> void swap(T[] arr, int i, int j) {
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static int DigitsInRecurringCycle(String c) {
		// TODO Auto-generated method stub
		return 0;
	}
}
