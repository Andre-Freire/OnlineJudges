/*
	ID: andrefm1
	LANG: JAVA
	TASK: transform
 */
//package usaco; //XXX comment this before submiting

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

public class transform {

	public final static boolean TESTING = false; // XXX change this and task name before submit

	public static void main(String[] args) throws IOException {
		String task = "transform"; //XXX change this
		String path = !TESTING ? task + ".in"
				: System.getProperty("user.dir") + File.separator + "src" + File.separator + "test.in";
		InputReader in = new InputReader(new FileInputStream(path));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(task + ".out")));
		solve(in, out);
		out.close();
		
//		boolean[][] a = new boolean[][]{new boolean[]{true, false, true},
//										new boolean[]{false, false, false},
//										new boolean[]{false, true, false}};
//		boolean[][] b = rotate90(a);
//		System.out.println("ola");
	}
	
	public static void solve(InputReader in, PrintWriter out) throws IOException {
		int n = in.nextInt();
		boolean[][] original = new boolean[n][n];
		boolean[][] transform = new boolean[n][n];
		int result = 7; // invalid transformation
		for(int i = 0; i < n; i++){
			String line = in.next();
			for(int j = 0; j < n; j++){
				original[i][j] = line.charAt(j) == '@';
			}
		}
		for(int i = 0; i < n; i++){
			String line = in.next();
			for(int j = 0; j < n; j++){
				transform[i][j] = line.charAt(j) == '@';
			}
		}
		
		boolean passedTest = false;
		boolean[][] copy = original.clone();
		// rotated 90
		if(!passedTest){
			copy = rotate90(copy);
			if(passedTest = sameArray(transform, copy)){
				result = 1;
			}
		}
		
		// rotated 180
		if(!passedTest){
			copy = rotate90(copy);
			if(passedTest = sameArray(transform, copy)){
				result = 2;
			}
		}
		
		// rotated 270
		if(!passedTest){
			copy = rotate90(copy);
			if(passedTest = sameArray(transform, copy)){
				result = 3;
			}
		}
		
		// Horizontal reflection
		if(!passedTest){
			copy = reflect(original);
			if(passedTest = sameArray(transform, copy)){
				result = 4;
			}
		}

		// Horizontal reflection + 1,2,3
		if(!passedTest){
			copy = rotate90(copy);
			passedTest = sameArray(transform, copy);
			if(!passedTest){
				copy = rotate90(copy);
				passedTest = sameArray(transform, copy);
			}
			if(!passedTest){
				copy = rotate90(copy);
				passedTest = sameArray(transform, copy);
			}
			if(passedTest){
				result = 5;
			}
		}
		// no transformation done
		if(!passedTest && sameArray(original, transform)){
			result = 6;
		}
		
		out.println(result);
	}
	
	private static boolean[][] reflect(boolean[][] original) {
		boolean[][] res = new boolean[original.length][original.length]; 
		for(int i = 0; i < original.length; i++){
			for(int j = 0; j < original.length; j++){
				res[i][j] = original[i][original.length - 1 - j];
			}
		}
		return res;
	}

	private static boolean[][] rotate90(boolean[][] original) {
		boolean[][] res = new boolean[original.length][original.length];
		for(int y = 0; y < original.length; y++){
			for(int x = 0; x < original.length; x++){
				res[x][y] = original[original.length - 1 - y][x];
			}
		}
		return res;
	}

	private static boolean sameArray(boolean[][] original, boolean[][] transform) {
		for(int i = 0; i < original.length; i++){
			for(int j = 0; j < original.length; j++){
				if(original[i][j] != transform[i][j]){
					return false;
				}
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