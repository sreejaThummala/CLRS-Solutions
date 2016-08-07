import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int n = in.nextInt();
		    Set<String> dict  = new HashSet<String>();
		    for(int i = 0; i < n; i++){
		        dict.add(in.next());
		    }
		    
		    String word = in.next();
		    
		    System.out.println(isWordBreak(dict,word));
		}
	}
	
	private static String isWordBreak(Set<String> dict, String word){
	    
	    int n = word.length();
	    boolean[] dp = new boolean[n+1];
	    
	    dp[0]  = true;
	    
	    for(int i = 0; i <= n; i++){
	        if(dp[i])
	        for(int j = i+1; j <= n; j++){
	            boolean contains = dict.contains(word.substring(i,j));
	            dp[j] = contains;
	        }
	    }
	    
	   if(dp[n]) return "1";
	   return "0";
	    
	}
}
