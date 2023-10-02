import java.util.ArrayList;
import java.util.Scanner;

/**
 * Problem: Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Main {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int num = scnr.nextInt();
		System.out.println(isPalindrome(num));
		
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
