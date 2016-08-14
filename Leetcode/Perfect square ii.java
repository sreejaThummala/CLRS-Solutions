public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i*i <= n; i++){
            if(i*i == n) return 1;
            dp[i*i] = 1;
            q.offer(i*i);
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 1; i*i<=n-cur; i++){
                if(cur+i*i == n){
                    return dp[cur]+1;
                }
                
                if(cur+i*i<n && dp[cur+i*i] == 0){
                    dp[cur+i*i] = dp[cur]+1;
                    q.offer(cur+i*i);
                    continue;
                }
            }
            
        }
        
        return -1;
        
    }
}
