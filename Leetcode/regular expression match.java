public class Solution {
    public boolean isMatch(String s, String p) {
        int S = s.length();
        int P = p.length();
        boolean[][] dp = new boolean[S+1][P+1];
        dp[0][0] = true;
        for(int i = 0; i < P; i++)
        {
 
            if(p.charAt(i) == '*')
            {
                for(int j = 0; j < s.length(); j++)
                {
                    dp[j+1][i+1] = dp[j+1][i-1];
                    if(p.charAt(i-1) == '.' || p.charAt(i-1) == s.charAt(j))
                    dp[j+1][i+1] |= dp[j][i-1]|| dp[j][i+1];
                }
            }else
            {
               for(int j = 0; j < s.length(); j++)
                dp[j+1][i+1] = (s.charAt(j) == p.charAt(i) 
                ||p.charAt(i) == '.')&&dp[j][i];
            }
        }
        
        return dp[S][P];
        
    }
}
