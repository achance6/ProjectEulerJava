import java.math.BigInteger;

/**
 * Problem: How many lattice paths are there through a 20x20 grid?
 */
public class Main {

	public static void main(String[] args) {
		System.out.println(binCo(new BigInteger("40"), new BigInteger("20")));

	}
	
	private static long binCo(long n, long k) {
		return fact(n) / (fact(k) * fact(n - k));
	}
	
	private static BigInteger binCo(BigInteger n, BigInteger k) {
		return fact(n).divide((fact(k).multiply(fact(n.subtract(k)))));
	}
	
	private static long fact(long n) {
		if (n == 0) return 1;
		long result = n;
		while (n > 1) {
			n--;
			result = result * n;
		}
		if (result < 1) throw new IllegalArgumentException("Arithmetic overflow: Input too large");
		else return result;
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
