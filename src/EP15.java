import java.math.BigInteger;

/**
 * Problem: How many lattice paths are there through a 20x20 grid?
 */
public class EP15 implements EulerSolution {

	@Override
	public String run() {
		// 40 choose 20
		return Methods.binCo(new BigInteger("40"), new BigInteger("20")).toString();
	}

}
