/*
	ID: andrefm1
	LANG: JAVA
	TASK: dualpal
 */
package usaco; //XXX comment this before submiting

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class dualpal {

	public final static boolean TESTING = true; // XXX change this and task name before submit

	public static void main(String[] args) throws IOException {
		String task = "dualpal"; //XXX change this
		String path = !TESTING ? task + ".in"
				: System.getProperty("user.dir") + File.separator + "src" + File.separator + "test.in";
		InputReader in = new InputReader(new FileInputStream(path));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(task + ".out")));
		solve(in, out);
		out.close();
	}
	
	public static void solve(InputReader in, PrintWriter out) throws IOException {
		int n = Integer.parseInt(in.next());
		int s = Integer.parseInt(in.next());
		int counter = 0;
		for(int i = s + 1;counter < n;i++){
			int numbBasesPal = 0;
			for(int base = 2; base <= 10 && numbBasesPal < 2; base++){
				if(isPalindrome(changeBase(i, base))){
					numbBasesPal++;
				}
			}
			if(numbBasesPal >= 2){
				counter++;
				out.println(i);
			}
		}
	}

	static final String[] DIGITS = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}; 
	private static String changeBase(int number, int base) {
		int exp = (int) (Math.log10(number) / Math.log10(base));
		int remainder = number;
		String result = new String();
		for(; exp >= 1; exp--){
			int digit = 0;
			int power = (int) Math.pow(base, exp);
			while(remainder - power >= 0){
				remainder -= power;
				digit++;
			}
			result += DIGITS[digit];
		}
		result += DIGITS[remainder];
		return result;
	}
	
	private static boolean isPalindrome(String square) {
		int size = square.length();
		int middle = size/2;
		if(square.charAt(0) == '0'){
			return false;
		}
		
		for(int i = 0; i < middle; i++){
			if(square.charAt(i) != square.charAt(size - i - 1)){
				return false;
			}
		}
		return true;
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}