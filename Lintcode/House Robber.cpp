class Solution {
public:
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    long long houseRobber(vector<int> A) {
        // write your code here
        
        
        vector<long long> dp;
        int len = A.size();
        
        if(len == 0) return 0;
        if(len == 1) return A[0];
        
        dp.resize(len+1);
        
        dp[0] = A[0];
        dp[1] = max(A[0],A[1]);
        for(int i=2; i< len; i++){
            
            dp[i] = max(dp[i-1], dp[i-2]+A[i]);
        }
        
        return dp[len-1];
    }
};
