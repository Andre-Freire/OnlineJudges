package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeforcesProblem {
	static class Solver {
		public void solve(InputReader in, PrintWriter out) {
			int[] cube = new int[24];
			String result = "NO";
			for(int i = 0; i < 24; i++){
				cube[i] = in.nextInt();
			}
			int[] r1 = new int[]{1, 3, 5, 7, 9, 11, 22, 24};
			int[] r2 = new int[]{2, 4, 6, 8, 10, 12, 21, 23};
			int[] r3 = new int[]{13, 14, 5, 6, 17, 18, 21, 22};
			int[] r4 = new int[]{15, 16, 7, 8, 19, 20, 23, 24};
			int[] r5 = new int[]{3, 4, 17, 19, 10, 9, 16, 14};
			int[] r6 = new int[]{1, 2, 18, 20, 12, 11, 15, 13};

			int[] test = Arrays.copyOf(cube, cube.length);
			// r1
			for(int i = 0; i < r1.length; i++){
				test[r1[i] - 1] = test[r1[(i + 2) % 8] - 1];
			}
			if(verifica(test)){
				result = "YES";
			}
			
			// r1 inverso
			test = Arrays.copyOf(cube, cube.length);
			for(int i = 0; i < r1.length; i++){
				test[r1[i] - 1] = test[r1[i - 2 < 0 ? 6 + i - 2 : i - 2] - 1];
			}
			if(verifica(test)){
				result = "YES";
			}
			
			
			test = Arrays.copyOf(cube, cube.length);
			// r2
			for(int i = 0; i < r2.length; i++){
				test[r2[i] - 1] = test[r2[(i + 2) % 8] - 1];
			}
			if(verifica(test)){
				result = "YES";
			}
			
			// r2 inverso
			test = Arrays.copyOf(cube, cube.length);
			for(int i = 0; i < r2.length; i++){
				test[r2[i] - 1] = test[r2[i - 2 < 0 ? 6 + i - 2 : i - 2] - 1];
			}
			if(verifica(test)){
				result = "YES";
			}
			
			
			
			test = Arrays.copyOf(cube, cube.length);
			// r3
			for(int i = 0; i < r3.length; i++){
				test[r3[i] - 1] = test[r3[(i + 2) % 8] - 1];
			}
			if(verifica(test)){
				result = "YES";
			}
			
			// r3 inverso
			test = Arrays.copyOf(cube, cube.length);
			for(int i = 0; i < r3.length; i++){
				test[r3[i] - 1] = test[r3[i - 2 < 0 ? 6 + i - 2 : i - 2] - 1];
			}
			if(verifica(test)){
				result = "YES";
			}
			
			
			
			test = Arrays.copyOf(cube, cube.length);
			// r4
			for(int i = 0; i < r4.length; i++){
				test[r4[i] - 1] = test[r4[(i + 2) % 8] - 1];
			}
			if(verifica(test)){
				result = "YES";
			}
			
			// r4 inverso
			test = Arrays.copyOf(cube, cube.length);
			for(int i = 0; i < r4.length; i++){
				test[r4[i] - 1] = test[r4[i - 2 < 0 ? 6 + i - 2 : i - 2] - 1];
			}
			if(verifica(test)){
				result = "YES";
			}
			
			
			
			test = Arrays.copyOf(cube, cube.length);
			// r5
			for(int i = 0; i < r5.length; i++){
				test[r5[i] - 1] = test[r5[(i + 2) % 8] - 1];
			}
			if(verifica(test)){
				result = "YES";
			}
			
			// r5 inverso
			test = Arrays.copyOf(cube, cube.length);
			for(int i = 0; i < r5.length; i++){
				test[r5[i] - 1] = test[r5[i - 2 < 0 ? 6 + i - 2 : i - 2] - 1];
			}
			if(verifica(test)){
				result = "YES";
			}
			
			
			test = Arrays.copyOf(cube, cube.length);
			// r6
			for(int i = 0; i < r6.length; i++){
				test[r6[i] - 1] = test[r6[(i + 2) % 8] - 1];
			}
			if(verifica(test)){
				result = "YES";
			}
			
			// r6 inverso
			test = Arrays.copyOf(cube, cube.length);
			for(int i = 0; i < r6.length; i++){
				test[r6[i] - 1] = test[r6[i - 2 < 0 ? 6 + i - 2 : i - 2] - 1];
			}
			if(verifica(test)){
				result = "YES";
			}
			
			out.println(result);
		}
		
		private boolean verifica(int[] array){
			for(int i = 0; i < array.length; i += 4){
				int numb = array[i];
				for(int j = i + 1; j < i + 4; j++){
					if(numb != array[j]){
						return false;
					}
				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Solver solver = new Solver();
		solver.solve(in, out);
		out.close();
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
