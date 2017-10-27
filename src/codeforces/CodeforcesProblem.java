package codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CodeforcesProblem {
	static class Solver {
        public void solve(InputReader in, PrintWriter out) {
        	int n = in.nextInt();
        	
        	boolean[] notPrime = new boolean[1000001];
        	notPrime[1]= true;
        	for(int i = 2; i * i < notPrime.length; i++){
        		if(!notPrime[i]){
        			for(int j = i; i * j < notPrime.length; j++){
        				notPrime[i * j] = true;
        			}
        		}
        	}
        	for(int i = 0; i < n; i++){
        		long x = Long.parseLong(in.next());
    			long root = (long) Math.sqrt(x);
        		if(root * root == x && !notPrime[(int) root]){
        			out.println("YES");
        		}else{
        			out.println("NO");
        		}
        	}
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
