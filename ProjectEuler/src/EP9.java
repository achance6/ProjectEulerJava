/**
 * Problem: There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class EP9 implements EulerSolution {

	private static final int LIMIT = 1000;
	int product = -1;
	@Override
	public String run() {
		for (int a = 1; a < LIMIT; ++a) {
			for (int b = 1; b < LIMIT; ++b) {
				for (int c = 1; c < LIMIT; ++c) {
					if (a + b + c == LIMIT && (a * a) + (b * b) == (c * c)) {
						product = a * b * c;
					}
				}
			}
		}
		return Integer.toString(product);
	}

}
