import java.util.ArrayList;

/**
 * Problem: What is the value of the first triangle number 
 * to have over five hundred divisors?
 */
public class EP12 implements EulerSolution {
	private static final int DIVISOR_AMOUNT = 500;
	
	@Override
	public String run() {
		ArrayList<Long> triNums;
		int divisors = 0;
		int j = 16384;
		String ans = "";
		while (divisors <= DIVISOR_AMOUNT) {
			//System.out.println("Trying " + j + " triangle numbers");
			triNums = Methods.genTriangleNumbers(j);
			for (long triNum : triNums) {
				divisors = 0;
				for (int i = 1; i <= triNum; ++i) {
					if (triNum % i == 0) {
						divisors++;
					}
				}
				//System.out.println(triNum + " has " + divisors + " divisors.");
				if (divisors > DIVISOR_AMOUNT) ans = Long.toString(triNum);
			}
			j = j * 2;
		}
		return ans;
	}

}
