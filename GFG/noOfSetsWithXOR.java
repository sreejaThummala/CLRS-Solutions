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
		    int k = in.nextInt();
		    int[] arr = new int[n];
		    for(int i = 0; i < n; i++){
		        arr[i] = in.nextInt();
		    }
		    
		    System.out.println(getCount(arr,k,n));
		}
	}
	
	private static int getCount(int[] arr, int k , int n){
	    
	    int maximumXOR = (1<<((int)(Math.log(100) /Math.log(2)) +1)) -1;
	    int[][] dp = new int[101][maximumXOR+1];
	    
	    dp[0][0] = 1;
	    
	    
	    
	    for (int i=1; i<=n; i++)
          for (int j=0; j<=maximumXOR; j++)
            dp[i][j] = dp[i-1][j] + dp[i-1][j^arr[i-1]];
 
	    
	    return dp[n][k];
	    
	}
}
