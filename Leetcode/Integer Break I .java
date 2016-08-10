public class Solution{

  public int integerBreak(int n ){
    int[] dp = new int[n+1];
    for(int i = 7; i <= n; i++){
      dp[i] = 3*dp[i-3];
    }
    
    return dp[n];
  }
}
