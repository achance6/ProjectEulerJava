import java.math.BigInteger;

/**
 * Problem: Find the sum of the digits in the number 100!.
 */
public class EP20 implements EulerSolution {

	@Override
	public String run() {
		BigInteger big = Methods.fact(new BigInteger("100"));
		char[] charNums = big.toString().toCharArray();
		int sum = 0;
		for(char c : charNums) sum += Character.getNumericValue(c);
		return Integer.toString(sum);
	}

}
