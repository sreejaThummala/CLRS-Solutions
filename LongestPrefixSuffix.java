import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner in =  new Scanner(System.in);
		int t  = in.nextInt();
		while(t>0){
		    t--;
		    String s = in.next();
		    System.out.println(getLongestPrefixSuffix(s));
		}
	}
	
	private static int getLongestPrefixSuffix(String s){
	    
	    int len = s.length();
	    int[] p = new int[len+1];
	    
	    p[0] = 0;
	    int j = 0;
	    
	    int maxLength = -1;
	    for(int i = 1; i<len; i++){
	        
	        while(j>0 && s.charAt(j) != s.charAt(i)){
	            j = p[j-1];
	        }
	        
	        if(s.charAt(j) == s.charAt(i)){
	            j++;
	        }
	        
	        p[i] = j;
	        
	        if(p[i]> maxLength){
	            maxLength = j;
	        }
	        
	    }
	    
	    return maxLength;
	}
}
