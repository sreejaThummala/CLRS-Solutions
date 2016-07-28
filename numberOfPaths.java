import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    private static int ncr(int m , int n) {
        int res = 1;
        for(int i = 0; i < n ; i++)
        {
            res *= (m-i);
            res /= (i+1);
        }
        
        return res;
    }
	public static void main (String[] args) {
		//code
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0)
		{
		    t--;
		    int m = in.nextInt();
		    int n = in.nextInt();
		    System.out.println(ncr(m+n-2,m-1));
		}
		
		
	}
}
