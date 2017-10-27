/*
ID: andrefm1
LANG: JAVA
TASK: gift1
 */
package usaco;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class gift1 {
	public final static boolean TESTING = true; //XXX change this and task name before submit
	
	public static void main (String [] args) throws IOException {
		String task = "gift1";
		String path = !TESTING ? task + ".in" : System.getProperty("user.dir") + File.separator + "src" + File.separator + "test.in";
	    
		BufferedReader in = new BufferedReader(new FileReader(path));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(task + ".out")));
	    solve(in, out);
	    out.close();
	  }
	  
	  public static void solve(BufferedReader in, PrintWriter out) throws IOException{
		  int n = nextInt(in);
		  List<String> friendsList = new ArrayList<>(n);
		  HashMap<String, Integer> friendTotal = new HashMap<>();
		  
		  for(int i = 0; i < n; i++){
			  String name = next(in);
			  friendsList.add(name);
			  friendTotal.put(name, 0);
		  }
		  
		  String giver = null;
		  while((giver = in.readLine()) != null){
			  String[] temp = in.readLine().split(" ");
			  int total = Integer.parseInt(temp[0]);
			  int receivers = Integer.parseInt(temp[1]);
			  
			  if(receivers != 0){
				  
				  int part = (total - (total % receivers)) / receivers;
				  friendTotal.put(giver, friendTotal.get(giver) - part * receivers);
				  
				  for(int i = 0; i < receivers; i++){
					  String receiver = next(in);
					  friendTotal.put(receiver, friendTotal.get(receiver) + part);
				  }
			  }
		  }
		  
		  for(String friend : friendsList){
			  out.println(friend + " " + friendTotal.get(friend));
		  }
	  }
	  
	private static String next(BufferedReader in) throws IOException {
		return (new StringTokenizer(in.readLine())).nextToken();
	}

	private static int nextInt(BufferedReader in) throws NumberFormatException, IOException {
		return Integer.parseInt((new StringTokenizer(in.readLine())).nextToken());
	}
}
