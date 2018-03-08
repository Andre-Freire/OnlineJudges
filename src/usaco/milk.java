/*
	ID: andrefm1
	LANG: JAVA
	TASK: milk
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class milk {

	public final static boolean TESTING = true; // XXX change this and task name before submit

	public static void main(String[] args) throws IOException {
		String task = "milk"; //XXX change this
		String path = !TESTING ? task + ".in"
				: System.getProperty("user.dir") + File.separator + "src" + File.separator + "test.in";
		InputReader in = new InputReader(new FileInputStream(path));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(task + ".out")));
		solve(in, out);
		out.close();
	}
	
	public static void solve(InputReader in, PrintWriter out) throws IOException {
		int milkNeeded = in.nextInt();
		int numbFarmers = in.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		Set<Integer> prices = new TreeSet<>();
		for(int i = 0; i < numbFarmers; i++){
			int price = in.nextInt();
			prices.add(price);
			if(map.containsKey(price)){
				map.put(price, map.get(price) + in.nextInt());
			}else{
				map.put(price, in.nextInt());
			}
		}
		
		int minimumCost = 0;
		Iterator<Integer> it = prices.iterator();
		while(milkNeeded > 0){
			int lowestPrice = it.next();
			int farmerStock = map.get(lowestPrice);
			if(milkNeeded >= farmerStock){
				milkNeeded -= farmerStock;
				minimumCost += farmerStock * lowestPrice;
			}else{
				minimumCost += milkNeeded * lowestPrice;
				milkNeeded = 0;
			}
		}
		out.println(minimumCost);
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