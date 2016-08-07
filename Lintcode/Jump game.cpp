class Solution {
public:
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    bool canJump(vector<int> A) {
        // write you code here
        if(A.size()==0) return false;
        if(A.size()==1) return true;
        vector<bool> dp;
        int len = A.size();
        dp.resize(len,false);
        
        dp[0] =true;
        for(int i=0;i< len;i++) {
            if(!dp[i]) continue;
            for(int j= 1; j<= A[i]; j++) {
                dp[i+j] = true;
            }
        }
        
        return dp[len-1];
    }
};
