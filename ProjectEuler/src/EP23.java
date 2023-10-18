import java.util.ArrayList;
import java.util.HashSet;

/**
 * Problem: Find the sum of all the positive integers 
 * which cannot be written as the sum of two abundant numbers.
 * all integers greater than 28123 can be written as the sum of two abundant numbers.
 */
public class EP23 implements EulerSolution {
	private static final int LIM = 28123;
	/**
	 * Put abundant numbers in array, put sums of every pairs of numbers
	 * in array into a set (as there will be duplicate sums that aren't needed)
	 * then add all numbers that aren't in the set i.e. numbers that aren't the
	 * sum of two abundant numbers.
	 * @param args
	 */
	@Override
	public String run() {
		ArrayList<Integer> abundantNums = new ArrayList<>();
		for (int i = 0; i <= LIM; ++i) {
			if (Methods.isAbundant(i)) abundantNums.add(i);
		}
		HashSet<Integer> abundantSums = new HashSet<>();
		for (int i : abundantNums) {
			for (int j : abundantNums) {
				abundantSums.add(i + j);
			}
		}
		long sum = 0;
		for (int i = 0; i <= LIM; ++i) {
			if (!abundantSums.contains(i)) sum += i;
		}
		
		return Long.toString(sum);
	}

}
