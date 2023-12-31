import java.util.ArrayList;

public class EP17 implements EulerSolution {

	@Override
	public String run() {
		ArrayList<String> nums = genNumsAsStrings();
		int sum = 0;
		for (String s : nums) {
			char[] ch = s.toCharArray(); // why String not iterable :(
			for (char c : ch) {
				if (c != ' ' && c != '-') sum++;
			}
		}
		return Integer.toString(sum);
	}
	
	private static ArrayList<String> genNumsAsStrings() {
		ArrayList<String> nums = new ArrayList<>();
		nums.add("one"); nums.add("two"); nums.add("three");
		nums.add("four"); nums.add("five"); nums.add("six");
		nums.add("seven"); nums.add("eight"); nums.add("nine");
		nums.add("ten"); nums.add("eleven"); nums.add("twelve");
		nums.add("thirteen"); nums.add("fourteen"); nums.add("fifteen");
		nums.add("sixteen"); nums.add("seventeen"); nums.add("eighteen");
		nums.add("nineteen"); nums.add("twenty");
		for (int i = 0; i < 9; ++i) nums.add("twenty-" + nums.get(i));
		nums.add("thirty");
		for (int i = 0; i < 9; ++i) nums.add("thirty-" + nums.get(i));
		nums.add("forty");
		for (int i = 0; i < 9; ++i) nums.add("forty-" + nums.get(i));
		nums.add("fifty");
		for (int i = 0; i < 9; ++i) nums.add("fifty-" + nums.get(i));
		nums.add("sixty");
		for (int i = 0; i < 9; ++i) nums.add("sixty-" + nums.get(i));
		nums.add("seventy");
		for (int i = 0; i < 9; ++i) nums.add("seventy-" + nums.get(i));
		nums.add("eighty");
		for (int i = 0; i < 9; ++i) nums.add("eighty-" + nums.get(i));
		nums.add("ninety");
		for (int i = 0; i < 9; ++i) nums.add("ninety-" + nums.get(i));
		
		for (int i = 1; i < 10; ++i) {
			nums.add(nums.get(i - 1) + "-hundred");
			for (int j = 0; j < 99; ++j) {
				nums.add(nums.get((i * 100) - 1) + " and " + nums.get(j));
			}
		}
		nums.add("one-thousand");
		return nums;
	}

}
