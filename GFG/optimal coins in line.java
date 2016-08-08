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
		    int[] arr = new int[n];
		    for(int i = 0; i<n; i++){
		        arr[i] = in.nextInt();
		    }
		    
		    System.out.println(getMaximumCoins(arr,n));
		}
	}
	
	private static int getMaximumCoins(int[] arr, int n){
	    int[][] dp = new int[n][n];
	    int gap = 0;
	    int x = 0,y=0,z=0;
	    for(gap = 0 ; gap<n; gap++){
	        for(int j=gap,i=0; j<n; j++,i++){
	        x = ((i+2) <= j) ? dp[i+2][j] : 0;
            y = ((i+1) <= (j-1)) ? dp[i+1][j-1] : 0;
            z = (i <= (j-2))? dp[i][j-2]: 0;
 
            dp[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));

	        }
	    }
	    
	    return dp[0][n-1];
	}
}
