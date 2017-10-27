/*
ID: andrefm1
LANG: JAVA
TASK: beads
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

public class beads {
	public final static boolean TESTING = true; //XXX change this and task name before submit
	
	public static void main (String [] args) throws IOException {
		String task = "beads";
		String path = !TESTING ? task + ".in" : System.getProperty("user.dir") + File.separator + "src" + File.separator + "test.in";
	    
		BufferedReader in = new BufferedReader(new FileReader(path));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(task + ".out")));
	    solve(in, out);
	    out.close();
	  }
	  
	  public static void solve(BufferedReader in, PrintWriter out) throws IOException{
		int n = nextInt(in);
		String beads = next(in);
		int result = 0;

		for(int i = 0; i < n; i++){
			int total = 0;
			int leftIndex = i - 1 < 0 ? beads.length() - 1 : i - 1;
			char leftRef = beads.charAt(leftIndex);
			int rightIndex = i;
			char rightRef = beads.charAt(rightIndex);
			while((leftRef == 'w' || beads.charAt(leftIndex) == leftRef || beads.charAt(leftIndex) == 'w') && total < n){
				if(leftRef == 'w' && beads.charAt(leftIndex) != 'w'){
					leftRef = beads.charAt(leftIndex);
				}
				
				leftIndex = leftIndex - 1 < 0 ? beads.length() - 1 : leftIndex - 1;
				total++;
			}
			while((rightRef == 'w' || beads.charAt(rightIndex) == rightRef || beads.charAt(rightIndex) == 'w') && total < n){
				if(rightRef == 'w' && beads.charAt(rightIndex) != 'w'){
					rightRef = beads.charAt(rightIndex);
				}
				
				rightIndex = rightIndex + 1 >= beads.length() ? 0 : rightIndex + 1;
				total++;
			}
			if(total > result){
				result = total;
			}
		}
		
		out.println(result);
	  }
	  
	private static String next(BufferedReader in) throws IOException {
		return (new StringTokenizer(in.readLine())).nextToken();
	}

	private static int nextInt(BufferedReader in) throws NumberFormatException, IOException {
		return Integer.parseInt((new StringTokenizer(in.readLine())).nextToken());
	}
}