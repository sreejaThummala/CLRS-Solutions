public class Solution {
    public boolean wordBreak(String word, Set<String> dict) {
        int n = word.length();
	    boolean[] dp = new boolean[n+1];
	    
	    dp[0]  = true;
	    
	    for(int i = 0; i <= n; i++){
	        if(dp[i])
	        for(int j = i+1; j <= n; j++){
	            boolean contains = dict.contains(word.substring(i,j));
	            dp[j] |= contains;
	        }
	    }
	    
	   return dp[n];
    }
}
