import java.util.ArrayList;

/**
 * Find the maximum total from top to bottom of the triangle below
 */
public class Main {

	public static void main(String[] args) {
		String tri = "75\r\n"
				+ "95 64\r\n"
				+ "17 47 82\r\n"
				+ "18 35 87 10\r\n"
				+ "20 04 82 47 65\r\n"
				+ "19 01 23 75 03 34\r\n"
				+ "88 02 77 73 07 63 67\r\n"
				+ "99 65 04 28 06 16 70 92\r\n"
				+ "41 41 26 56 83 40 80 70 33\r\n"
				+ "41 48 72 33 47 32 37 16 94 29\r\n"
				+ "53 71 44 65 25 43 91 52 97 51 14\r\n"
				+ "70 11 33 28 77 73 17 78 39 68 17 57\r\n"
				+ "91 71 52 38 17 14 91 43 58 50 27 29 48\r\n"
				+ "63 66 04 68 89 53 67 30 73 16 69 87 40 31\r\n"
				+ "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
		String[] rows = tri.split("\r\n");
		ArrayList<String[]> stringNums = new ArrayList<>();
		for(String s : rows) {
			stringNums.add(s.split("\s"));
		}
		ArrayList<ArrayList<Integer>> triInts = new ArrayList<>();
		for(int i = 0; i < stringNums.size(); ++i) {
			triInts.add(new ArrayList<>());
			for(int j = 0; j < stringNums.get(i).length; ++j) {
				triInts.get(i).add(Integer.parseInt(stringNums.get(i)[j]));
			}
		}
		for(ArrayList<Integer> c : triInts) {
			System.out.println(c);
		}

	}

}
