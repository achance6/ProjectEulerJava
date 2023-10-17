import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Problem:
 * Using names.txt (right click and 'Save Link/Target As...'), 
 * a 46K text file containing over five-thousand first names, 
 * begin by sorting it into alphabetical order. 
 * Then working out the alphabetical value for each name, 
 * multiply this value by its alphabetical position in the list to obtain a name score.
 * 
 * What is the total of all name scores in the file?
 */
public class Main {

	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream("names.txt");
		int next;
		String cur = "";
		String[] names;
		byte[] bytes = in.readAllBytes(); 
		// pass byte array to string constructor, split string by comma delimiter
		names = (new String(bytes, StandardCharsets.UTF_8)).split(","); 
		
		// cut off " at beginning and end of every string
		for (int i = 0; i < names.length; ++i) {
			names[i] = names[i].substring(1, names[i].length() - 1); 
		}
		
		Arrays.sort(names);
		long sum = 0;
		for(int i = 0; i < names.length; ++i) {
			int value = 0;
			for (int j = 0; j < names[i].length(); ++j) {
				value += names[i].charAt(j) - 'A' + 1;
			}
			sum += (value * (i + 1)); // start index at 1
		}
		System.out.println(Long.toString(sum));	
	}
}
