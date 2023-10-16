import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Problem: Evaluate the sum of all the amicable numbers under 10000.
 */
public class Main {

	public static void main(String[] args) {
		
		long sum = 0;
		for (long i = 1; i < 10_000; ++i) {
			long j = sumProperDivisors(i);
			if (isAmicableNumbers(i, j)) {
				sum += i + j;
			}
		}
		System.out.println(sum / 2);
		

	}
	
	private static ArrayList<Long> genProperDivisors(long num) {
		ArrayList<Long> factors = new ArrayList<>();
		for (long i = 1; i < num; ++i) {
			if (num % i == 0) factors.add(i);
		}
		return factors;
	}
	
	private static long sumAll(Collection<Long> nums) {
		long sum = 0;
		for (long num : nums) sum+= num;
		return sum;
	}
	
	private static long sumProperDivisors(long num) {
		long sum = 0;
		for (long i = 1; i < num; ++i) {
			if (num % i == 0) sum += i;
		}
		return sum;
	}
	
	private static boolean isAmicableNumbers(long a, long b) {
		if (a == b) return false;
		if (sumProperDivisors(a) == b &&
				sumProperDivisors(b) == a) return true;
		return false;
	}

}
