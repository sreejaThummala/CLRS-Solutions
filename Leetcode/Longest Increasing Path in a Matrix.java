public class Solution {
    private static final int[] DX = new int[]{0,0,-1,1};
    private static final int[] DY = new int[]{1,-1,0,0};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length ==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int result = 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ;j++){
                result = Math.max(result, helper(i,j,dp,matrix));
            }
        }
        
        return result;
    }
    
    private int helper(int r, int c, int[][] dp,int[][] matrix){
        if(dp[r][c]!=0) return dp[r][c];
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        for( int i  = 0; i < 4; i++){
            int x = r+DX[i];
            int y = c+DY[i];
            if(x>=0 && x<m && y >=0 && y < n && matrix[r][c] < matrix[x][y]){
                result = Math.max(result, helper(x,y,dp,matrix));
            }
        }
        
        dp[r][c] = result+1;
        return dp[r][c];
    }
}
