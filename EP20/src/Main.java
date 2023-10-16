import java.math.BigInteger;

/**
 * Problem: Find the sum of the digits in the number 100!.
 */
public class Main {

	public static void main(String[] args) {
		BigInteger big = fact(new BigInteger("100"));
		char[] charNums = big.toString().toCharArray();
		int sum = 0;
		for(char c : charNums) sum += Character.getNumericValue(c);
		System.out.println(sum + " is the sum of the digits in 100!");
	}
	
	private static BigInteger fact(BigInteger n) {
		if (n.equals(BigInteger.ZERO)) return BigInteger.ONE;
		BigInteger result = new BigInteger(n.toString());
		while (n.compareTo(BigInteger.ONE) > 0) {
			n = n.subtract(BigInteger.ONE);
			result = result.multiply(n);
		}
		return result;
	}
}
