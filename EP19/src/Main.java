import java.util.Calendar;
import java.util.Locale;

/**
 * Problem: 

You are given the following information, but you may prefer to do some research for yourself.

    1 Jan 1900 was a Monday.
    Thirty days has September,
    April, June and November.
    All the rest have thirty-one,
    Saving February alone,
    Which has twenty-eight, rain or shine.
    And on leap years, twenty-nine.
    A leap year occurs on any year evenly divisible by 4, 
    but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during 
the twentieth century (1 Jan 1901 to 31 Dec 2000)?

 */
public class Main {

	public static void main(String[] args) {
		Calendar cur = Calendar.getInstance();
		cur.set(1901, 0, 1); 
		int sum = 0;
		while (cur.get(Calendar.YEAR) < 2001) {
			//If the day is Sunday and it's the first day of the month, increment sum
			if ((cur.get(Calendar.DAY_OF_MONTH) == 1) && 
					(cur.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
				sum++;
//				System.out.print(cur.get(Calendar.YEAR) + " ");
//				System.out.print(cur.get(Calendar.MONTH) + 1 + " ");
//				System.out.println(cur.get(Calendar.DAY_OF_WEEK_IN_MONTH));
			}
			cur.add(Calendar.DATE, 1); 
		}	
		System.out.println("There are " + sum + " Sundays that fell on the first of the month "
				+ "during the twentieth century");
	}
}
