import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner in  = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int k   = in.nextInt();
		    		    String n = in.next();

		    StringBuffer s =  new StringBuffer(n);
		    StringBuffer sb = new StringBuffer();
		    sb.append(n);
		    getMaximumNumber(s,k,sb);
		    System.out.println(sb.toString());
		}
	}
	
	private static void getMaximumNumber(StringBuffer s, int k , StringBuffer sb){
	    
	    if(k==0) return;
	    for(int i = 0; i < s.length(); i++){
	        for(int j = i+1; j < s.length(); j++){
	           if(s.charAt(i) < s.charAt(j))
	           {
	               swap(s,i,j);
	               
	               if(sb.toString().compareTo(s.toString())<0){
	                   sb.setLength(0);
	                   sb.append(s.toString());
	               }
	               
	               getMaximumNumber(s,k-1,sb);
	               
	               swap(s,j,i);
	           }
	        }
	    }
	}
	
	private static void swap(StringBuffer s, int i , int j){
	    char tmp = s.charAt(i);
	    s.setCharAt(i,s.charAt(j));
	    s.setCharAt(j,tmp);
	}
}
