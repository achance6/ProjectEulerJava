import java.util.ArrayList;

/**
 * Problem: Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Main {

	public static void main(String[] args) {
		int largest = -1, factor1 = -1, factor2 = -1;
		for (int i = 100; i < 1000; ++i) {
			for (int j = 100; j < 1000; ++j) {
				if (isPalindrome(i * j) && (i * j) > largest) {
					largest = i * j;
					factor1 = i;
					factor2 = j;
				}
			}
		}
		System.out.println(factor1 + " * " + factor2 + " = " + largest);
		System.out.println("This is the largest palindrome formed from the product of two 3-digit numbers");
	}
	
	public static boolean isPalindrome(int num) {
		String n = ((Integer) num).toString();
		ArrayList<Character> firstHalf = new ArrayList<>();
		ArrayList<Character> secondHalf = new ArrayList<>();
		for (int i = 0; i < n.length() / 2; ++i) {
			firstHalf.add(n.charAt(i));
			secondHalf.add(n.charAt(n.length() - 1 - i));
		}
		if (firstHalf.equals(secondHalf)) return true;
		return false;
	}

}
