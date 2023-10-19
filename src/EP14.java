/**
 * The following iterative sequence is defined for the set of positive integers:
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class EP14 implements EulerSolution {

	@Override
	public String run() {
		int largestSize = 0;
		int numWithLargestSeq = 1;
		for (int i = 1; i < 1_000_000; ++i) {
			int curSize = Methods.genCollatzSequence(i).size();
			if (curSize > largestSize) {
				largestSize = curSize;
				numWithLargestSeq = i;
			}
		}
		return Integer.toString(numWithLargestSeq);
	}

}
