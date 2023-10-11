import java.math.BigInteger;

/**
 * Problem: What is the sum of the digits of the number 2^1000?
 */
public class Main {

	public static void main(String[] args) {
		BigInteger num = (new BigInteger("2")).pow(1000);
		char[] s = num.toString().toCharArray();
		int sum = 0;
		for (int i = 0; i < s.length; ++i) 
			sum += Character.getNumericValue(s[i]);
		System.out.println(sum);
	}
}
