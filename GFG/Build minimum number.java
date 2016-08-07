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
		    int k = in.nextInt();
		    String n = in.next();
		    
		    List<Character> res = new ArrayList<Character>();
		    
		    getMinimumNumber(n,k,res);
		    
		    for(int i = 0; i < res.size(); i++){
		        System.out.print(res.get(i));
		    }
		    
		    System.out.println();
		}
	}
	
	private static void getMinimumNumber(String n, int k, List<Character> res){
	    if(k==0) {
	      for(int i = 0; i < n.length(); i++)
	      {
	          res.add(n.charAt(i));
	      }
	      
	      return;
	    } 
	    if( n.length()<=k) return;
	    
	    int minIndex = 0;
        for (int i = 1; i<=k ; i++)
        if (n.charAt(i) < n.charAt(minIndex))
            minIndex = i;
        
        res.add(n.charAt(minIndex));
        n = n.substring(minIndex+1);
        
        getMinimumNumber(n,k-minIndex,res );
	    
	}
}
