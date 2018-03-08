/*
	ID: andrefm1
	LANG: JAVA
	TASK: barn1
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
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class barn1 {

	public final static boolean TESTING = true; // XXX change this and task name before submit

	public static void main(String[] args) throws IOException {
		String task = "barn1"; //XXX change this
		String path = !TESTING ? task + ".in"
				: System.getProperty("user.dir") + File.separator + "src" + File.separator + "test.in";
		InputReader in = new InputReader(new FileInputStream(path));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(task + ".out")));
		solve(in, out);
		out.close();
	}
	
	public static void solve(InputReader in, PrintWriter out) throws IOException {
		int totalBoards = in.nextInt();
		in.nextInt();
		int cowsInStalls = in.nextInt();
		if(totalBoards >= cowsInStalls){
			out.println(cowsInStalls);
		}else{
			List<Integer> occupiedStalls = new ArrayList<>();
			for(int i = 0; i < cowsInStalls; i++){
				occupiedStalls.add(in.nextInt());
			}
			Collections.sort(occupiedStalls);
			
			List<Integer> gaps = new ArrayList<>();
			for(int i = 0; i < cowsInStalls - 1; i++){
				gaps.add(occupiedStalls.get(i + 1) - occupiedStalls.get(i) - 1);
			}
			Collections.sort(gaps, Collections.reverseOrder());
			// Last occuppied stall minus the first occuppied stall
			int range = occupiedStalls.get(cowsInStalls - 1) - occupiedStalls.get(0) + 1;
			int emptySpaces = 0;
			for(int i = 0; i < totalBoards - 1; i++){
				emptySpaces += gaps.get(i);
			}
			out.println(range - emptySpaces);
		}
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