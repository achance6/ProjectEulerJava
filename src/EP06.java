/**
 * Problem: Find the difference between the sum of the squares of the 
 * first one hundred natural numbers and the square of the sum.
 */
public class EP06 implements EulerSolution {

	@Override
	public String run() {
		int sum = 0;
		int sumOfTheSquares = 0;
		int squareOfTheSum = 0;
		
		for (int i = 1; i <= 100; ++i) {
			sumOfTheSquares += i * i;
			sum += i;
		}
		squareOfTheSum = sum * sum;
		
		int difference = sumOfTheSquares - squareOfTheSum;
		return Integer.toString(Math.abs(difference));
	}

}
