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
		    int a = in.nextInt();
		    System.out.println(getCount(a));
		}
	}
	
	private static int getCount(int a){
	    if(a <= 0) return 0;
	    
	    int count = 1;
	    for(int i = 2; i*i <= a; i++){
	        if(a%i == 0)
	        {
	            int b = a/i;
	            count++;
	            if(i%2 == 0 && ((b)%2==0))
	            {
	                if(i!=b)
	                count--;
	            }
	        }
	    }
	    
	    
	    return count;
	}
}
