/**
 * Problem: Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class EP04 implements EulerSolution {

	@Override
	public String run() {
		int largest = -1;
		for (int i = 100; i < 1000; ++i) {
			for (int j = 100; j < 1000; ++j) {
				if (Methods.isPalindrome(i * j) && (i * j) > largest) {
					largest = i * j;
				}
			}
		}
		return Integer.toString(largest);
		
	}

}
