import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		
	Scanner in = new Scanner(System.in);
	int t= in.nextInt();
	while(t>0)
	{
	    t--;
	    int n = in.nextInt();
	    int[] arr = new int[n];
	    for(int i = 0; i < n ; i++)
	    {
	        arr[i]= in.nextInt();
	    }
	    
	    int cnt = 0;
	    
	    for(int i  = 0 ; i<n; i++)
	    {
	        for(int j = i+1; j < n; j++)
	        {
	            cnt += Integer.bitCount(arr[i]^arr[j]);
	        }
	    }
	    
	    System.out.println(cnt*2);
	}
	}
}
