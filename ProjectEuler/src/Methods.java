import java.util.ArrayList;

public final class Methods {
	public static ArrayList<Long> genFibSeq(final long LIM) {
		ArrayList<Long> seq = new ArrayList<>();
		long last_1 = 2;
		long last_2 = 1;
		do {
			seq.add(last_1);
			long tmp = last_1;
			last_1 = last_1 + last_2;
			last_2 = tmp;
		} while (last_1 <= LIM);
		return seq;
	}
}
