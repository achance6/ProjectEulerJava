import java.util.ArrayList;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Main {

	public static void main(String[] args) {
		int largestSize = 0;
		int numWithLargestSeq = 1;
		for (int i = 1; i < 1_000_000; ++i) {
			int curSize = genCollatzSequence(i).size();
			if (curSize > largestSize) {
				largestSize = curSize;
				numWithLargestSeq = i;
			}
		}
		System.out.println(numWithLargestSeq);

	}
	
	private static ArrayList<Long> genCollatzSequence(long n) {
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
			System.out.println("out of bounds");
		}
		return seq;
	}

}
