/**
 * What is the smallest positive number that is evenly divisible 
 * by all of the numbers from 1 to 20?
 */
public class Main {

	public static void main(String[] args) {
		int sum = 0, cur = 0;
		while (sum != 20) {
			cur++;
			sum = 0;
			for (int i = 1; i < 21; ++i) {
				if (cur % i == 0) sum++;
			}
		}
		System.out.println(cur);
	}
}
