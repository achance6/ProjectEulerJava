import java.util.ArrayList;

/**
 * Problem: What is the value of the first triangle number 
 * to have over five hundred divisors?
 */
public class Main {
	private static final int DIVISOR_AMOUNT = 500;

	public static void main(String[] args) {
		ArrayList<Integer> triNums;
		int divisors = 0;
		int j = 16384;
		while (divisors <= DIVISOR_AMOUNT) {
			System.out.println("Trying " + j + " triangle numbers");
			triNums = genTriangleNumbers(j);
			for (int triNum : triNums) {
				divisors = 0;
				for (int i = 1; i <= triNum; ++i) {
					if (triNum % i == 0) {
						divisors++;
					}
				}
				//System.out.println(triNum + " has " + divisors + " divisors.");
				if (divisors > DIVISOR_AMOUNT) {
					System.out.println(triNum + " has " + divisors + " divisors.");
					break;
				}
			}
			j = j * 2;
		}

	}

	private static ArrayList<Integer> genTriangleNumbers(int n) {
		ArrayList<Integer> triNums = new ArrayList<>();
		for (int i = 1; i <= n; ++i) {
			triNums.add((i * (i + 1)) / 2); //Summation formula from 1 to N
		}
		return triNums;
	}

}
