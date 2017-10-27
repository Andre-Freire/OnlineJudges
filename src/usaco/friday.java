/*
ID: andrefm1
LANG: JAVA
TASK: friday
 */
package usaco;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class friday {
	public final static boolean TESTING = false; // XXX change this and task name before submit

	public static void main(String[] args) throws IOException {
		String task = "friday";
		String path = !TESTING ? task + ".in"
				: System.getProperty("user.dir") + File.separator + "src" + File.separator + "test.in";

		BufferedReader in = new BufferedReader(new FileReader(path));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(task + ".out")));
		solve(in, out);
		out.close();
	}

	public static void solve(BufferedReader in, PrintWriter out) throws IOException {
		int n = nextInt(in);
		// Saturday, Sunday, Monday, Tuesday, Wednesday, Thursday, Friday
		int[] days = new int[7];
		// >> January 1, 1900 was on a Monday.
		// >> Thirty days has September, April, June, and November, all the rest
		// have 31 except for
		// February which has 28 except in leap years when it has 29.
		// >> Every year evenly divisible by 4 is a leap year (1992 = 4*498 so
		// 1992 will be a leap year,
		// but the year 1990 is not a leap year)
		// >> The rule above does not hold for century years. Century years
		// divisible by 400 are leap
		// years, all other are not. Thus, the century years 1700, 1800, 1900
		// and 2100 are not leap years,
		// but 2000 is a leap year
		// 1  jan > 31
		// 2  fev > 28/29
		// 3  mar > 31
		// 4  apr > 30
		// 5  mai > 31
		// 6  jun > 30
		// 7  jul > 31
		// 8  ago > 31
		// 9  set > 30
		// 10 out > 31
		// 11 nov > 30
		// 12 dez > 31

		int currYear = 1900;
		int currDayOfTheWeek = 2;
		for (int i = 0; i < n; i++, currYear++) {
			for (int currMonth = 1; currMonth <= 12; currMonth++) {
				int currMonthDays;
				if (currMonth < 8 && currMonth % 2 == 1) {		// jan, mar, may, jul
					currMonthDays = 31;
				} else if (currMonth == 2) {
					if (currYear % 100 == 0) {					// february cases
						if (currYear % 400 == 0) { 	// century leap year
							currMonthDays = 29;
						} else {					// century not leap
							currMonthDays = 28;
						}
					} else if (currYear % 4 == 0) {	// normal leap year
						currMonthDays = 29;
					} else {						// normal not leap year
						currMonthDays = 28;
					}
				} else if(currMonth > 7 && currMonth % 2 == 0) {// aug, oct, dez
					currMonthDays = 31;
				}else{											// apr, jun, sept, nov		
					currMonthDays = 30;
				}
				
				currDayOfTheWeek = (currDayOfTheWeek + 12) % 7;
				days[currDayOfTheWeek]++;
				currDayOfTheWeek = (currDayOfTheWeek + currMonthDays - 12) % 7;
			}
		}
		
		for(int i = 0; i < days.length - 1; i++){
			out.print(days[i] + " ");
		}
		out.println(days[days.length - 1]);
	}

	@SuppressWarnings("unused")
	private static String next(BufferedReader in) throws IOException {
		return (new StringTokenizer(in.readLine())).nextToken();
	}

	private static int nextInt(BufferedReader in) throws NumberFormatException, IOException {
		return Integer.parseInt((new StringTokenizer(in.readLine())).nextToken());
	}
}