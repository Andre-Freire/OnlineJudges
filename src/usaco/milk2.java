/*
	ID: andrefm1
	LANG: JAVA
	TASK: milk2
 */
package usaco;

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
import java.util.StringTokenizer;

public class milk2 {

	public final static boolean TESTING = true; // XXX change this and task name
												// before submit

	public static void main(String[] args) throws IOException {
		String task = "milk2";
		String path = !TESTING ? task + ".in"
				: System.getProperty("user.dir") + File.separator + "src" + File.separator + "test.in";
		InputReader in = new InputReader(new FileInputStream(path));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(task + ".out")));
		solve(in, out);
		out.close();
	}

	public static void solve(InputReader in, PrintWriter out) throws IOException {
		int n = in.nextInt();
		ArrayList<Integer> starts = new ArrayList<>();
		ArrayList<Integer> ends = new ArrayList<>();
		for(int i = 0; i < n; i++){
			int start =in.nextInt(); 
			int end = in.nextInt();
			boolean saved = false;
			for(int j = 0; j < starts.size(); j++){
				if(start <= starts.get(j)){
					starts.add(j, start);
					ends.add(j, end);
					saved = true;
					break;
				}
			}
			if(!saved){
				starts.add(start);
				ends.add(end);
			}
		}

		for(int i = 0; i < starts.size(); i++){
			int maxLast = ends.get(i);
			while(i < starts.size() - 1 && maxLast >= starts.get(i+1)){
				starts.remove(i + 1);
				int temp = ends.remove(i + 1);
				maxLast = temp > maxLast ? temp : maxLast;
			}
			ends.remove(i);
			ends.add(i, maxLast);
		}

		int maxTime = ends.get(0) - starts.get(0);
		int maxInterval = 0;
		for(int i = 1; i < starts.size(); i++){
			int time = ends.get(i) - starts.get(i);
			int interval = starts.get(i) - ends.get(i - 1);
			if(time > maxTime){
				maxTime = time;
			}
			if(interval > maxInterval){
				maxInterval = interval;
			}
		}
		out.println(maxTime + " " + maxInterval);
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
