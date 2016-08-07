class Solution {
public:
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */
    vector<vector<int> > kSumII(vector<int> A, int k, int target) {
        // write your code here
        vector<vector<int> > result;
        vector<int> partial;
        ksumHelper(A,k,0,target,result,partial,0);
        return result;
    }
    
    void ksumHelper(vector<int> A, int k, int idx, int target, vector<vector<int> > &result, vector<int> partial, int sum)
    {
        
        if(sum> target)
        {
            return;
        }
        if(partial.size() == k){
            if(sum == target)
            {
                result.push_back(partial);
                
                return;
            }
            return;
        }
        if(idx >= A.size()){
            return;
        }
        
        ksumHelper(A, k, idx+1, target, result, partial, sum);
        partial.push_back(A[idx]);
        ksumHelper(A, k, idx+1, target, result, partial, sum+A[idx]);
    }
};
