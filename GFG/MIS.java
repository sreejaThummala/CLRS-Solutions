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
		    
		    for(int i = 0; i < n; i++){
		        arr[i] = in.nextInt();
		    }
		    System.out.println(getMIS(arr,n));
		}
	}
	
	private static int getMIS(int[] arr, int n){
	    int[] dp = new int[n];
	    
	    for(int i = 0; i < n ; i++){
	        dp[i] = arr[i];
	    }
	    
	    for(int i = 1; i <n ; i++){
	        for(int j = 0; j <i; j++){
	            if(arr[i]>arr[j] && dp[i] < dp[j]+arr[i]){
	                dp[i] = dp[j]+arr[i];
	            }
	        }
	    }
	    
	    int maximumSum = 0;
	    for(int i =0 ; i < n; i++ ){
	        maximumSum = Math.max(maximumSum, dp[i]);
	    }
	    
	    return maximumSum;
	}
}
