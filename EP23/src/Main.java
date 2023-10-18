import java.util.ArrayList;

/**
 * Problem: Find the sum of all the positive integers 
 * which cannot be written as the sum of two abundant numbers.
 * all integers greater than 28123 can be written as the sum of two abundant numbers.
 */
public class Main {

	private static final int LIM = 28123;
	public static void main(String[] args) {
		ArrayList<Integer> abundantNums = new ArrayList<>();
		for (int i = 0; i <= LIM; ++i) {
			if (isAbundant(i)) abundantNums.add(i);
		}
		long sum = 0;
		System.out.println(abundantNums);
//		for (int i = 0; i <= LIM; ++i) {
//			boolean isSum = false;
//			for (int j : abundantNums) {
//				for (int k : abundantNums) {
//					if (i == j + k) {
//						isSum = true;
//						break;
//					}
//				}
//			}
//			if (! isSum) {
//				sum += i;
//				System.out.println(i);
//			}
//		}
		System.out.println(sum);
		
	}
	
	private static ArrayList<Long> genProperDivisors(long num) {
		ArrayList<Long> factors = new ArrayList<>();
		for (long i = 1; i < num; ++i) {
			if (num % i == 0) factors.add(i);
		}
		return factors;
	}
	
	private static long sumProperDivisors(long num) {
		long sum = 0;
		for (long i = 1; i < num; ++i) {
			if (num % i == 0) sum += i;
		}
		return sum;
	}
	
	private static boolean isAbundant(long num) {
		return sumProperDivisors(num) > num;
	}

}
