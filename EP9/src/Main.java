

/**
 * Problem: There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Main {

	public static void main(String[] args) {
		final int LIMIT = 1000;
		
		for (int a = 1; a < LIMIT; ++a) {
			for (int b = 1; b < LIMIT; ++b) {
				for (int c = 1; c < LIMIT; ++c) {
					if (a + b + c == LIMIT && (a * a) + (b * b) == (c * c)) {
						System.out.println(a * b * c);
					}
				}
			}
		}

	}

}
