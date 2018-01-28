/*
	ID: andrefm1
	LANG: JAVA
	TASK: namenum
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class namenum {

	public final static boolean TESTING = true; // XXX change this and task name before submit

	public static void main(String[] args) throws IOException {
		String task = "namenum"; //XXX change this
		String path = !TESTING ? task + ".in"
				: System.getProperty("user.dir") + File.separator + "src" + File.separator + "test.in";
		InputReader in = new InputReader(new FileInputStream(path));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(task + ".out")));
		solve(in, out);
		out.close();
	}
	
	public static void solve(InputReader in, PrintWriter out) throws IOException {
		InputReader in2 = new InputReader(new FileInputStream(!TESTING ? "dict.txt"
				: System.getProperty("user.dir") + File.separator + "src" + File.separator + "dict.txt"));
		HashMap<String, List<String>> numericNamesOccurrences = new HashMap<>();

		HashMap<String, Integer> encoder = new HashMap<>();
		encoder.put("ABC", 2);
		encoder.put("DEF", 3);
		encoder.put("GHI", 4);
		encoder.put("JKL", 5);
		encoder.put("MNO", 6);
		encoder.put("PRS", 7);
		encoder.put("TUV", 8);
		encoder.put("WXY", 9);
		
		for(int i = 0; i < 4617; i++){
			String realName = in2.next();
			String numericName = code(realName, encoder);
			if(numericNamesOccurrences.containsKey(numericName)){
				numericNamesOccurrences.get(numericName).add(realName);
			}else{
				List<String> l = new ArrayList<>();
				l.add(realName);
				numericNamesOccurrences.put(numericName, l);
			}
		}

		String number = in.next();

		if(numericNamesOccurrences.containsKey(number)){
			for(String name : numericNamesOccurrences.get(number)){
				out.println(name);
			}
		}else{
			out.println("NONE");
		}
	}

	private static String code(String realName, HashMap<String, Integer> encoder) {
		String res = "";
		for(int i = 0; i < realName.length(); i++){
			String c = realName.substring(i, i + 1);
			for(String code : encoder.keySet()){
				if(code.contains(c)){
					res += encoder.get(code);
					break;
				}
			}
		}
		return res;
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