
public class Main {

	public static void main(String[] args) {
		final int LIMIT = 4_000_000;
		int last_1 = 2;
		int last_2 = 1;
		int sum = 0;
		do {
			if (last_1 % 2 == 0) sum += last_1;
			int tmp = last_1;
			last_1 = last_1 + last_2;
			last_2 = tmp;
		} while (last_1 < LIMIT);
		System.out.println(sum);
	}
}
