import java.util.ArrayList;

/**
 * Problem: What is the index of the first term in the 
 * Fibonacci sequence to contain 1000 digits?
 */
public class EP25 implements EulerSolution {

	@Override
	public String run() {
		String limit = "1";
		for (int i = 1; i < 1100; ++i) // 1100 digit number.
			limit += "0";
		ArrayList<String> fibs = Methods.genFibSeq(limit);
		for (int i = 0; i < fibs.size(); ++i) {
			if (fibs.get(i).length() >= 1000) {
				return Integer.toString(i + 1);
			}
		}
		return "Error";
	}

}
