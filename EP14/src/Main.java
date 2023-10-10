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
		ArrayList<Integer> seq = genCollatzSequence(900000);
		int largestSize = 0;
		int numWithLargestSeq = 1;
//		for (int i = 1; i < 1_000_000; ++i) {
//			if (genCollatzSequence(i).size() > largestSize) numWithLargestSeq = i;
//		}
//		System.out.println(numWithLargestSeq);

	}
	
	private static ArrayList<Integer> genCollatzSequence(int n) {
		ArrayList<Integer> seq = new ArrayList<>();
		seq.add(n);
		int res = n;
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
		return seq;
	}

}
