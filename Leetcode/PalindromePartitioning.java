public class Solution {
    public int minCut(String s) {
      
        int len  = s.length();
        
        int[][] dp = new int[len][len];
        
        for(int i = 0; i < len; i++)
        {
            Arrays.fill(dp[i],-1);
        }
        
        int[][] p = new int[len][len];
        
        for(int i = 0; i < len; i++)
        {
            Arrays.fill(p[i],-1);
        }
        
        for(int i = 0; i < len ; i++)
        {
            for(int j = 0; j < len; j++)
            {
               isPalindrome(s,p, i , j);

            }
        }
        return minCutDpHelper(dp, 0, len-1,s,p);
    }
    
    
    public int minCutDpHelper(int[][] dp, int row, int col, String s,int[][] p)
    {
        
        if(dp[row][col]!=-1)
            return dp[row][col];
        if(p[row][col]==1)
            return dp[row][col] = 0;
        if(row == col)
            return (dp[row][col]=0);
        if(row>col)
            return 0;
        int dpValue = Integer.MAX_VALUE;
        for(int i = row; i < col; i++ )
        {
            dpValue = Math.min(dpValue, minCutDpHelper(dp,row,i,s,p)+1+minCutDpHelper(dp,i+1,col,s,p));
        }
        
        return  (dp[row][col] = dpValue);
    }
    
    public int isPalindrome(String s, int[][] p, int row, int col)
    {
        if(row > s.length()-1 || col <0)
            return 1;
        if(p[row][col]!=-1)
         return p[row][col];
         
        if(row == col) 
            return p[row][col] = 1;
        if(row - col == 1)
        {
            if(s.charAt(row)==s.charAt(col))
            {
                p[row][col] =1;
                return p[row][col];
            }
            
            return p[row][col] = -1;
        }
        
        if(isPalindrome(s, p, row+1, col-1) == 1) 
        {
            if(s.charAt(row) == s.charAt(col))
            {
                p[row][col] = 1;
                return 1;
            }
            
        }
        
        return p[row][col] = -1;
    }
}
