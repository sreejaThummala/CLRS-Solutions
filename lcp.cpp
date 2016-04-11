class Solution {
public:    
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    string longestCommonPrefix(vector<string> &strs) {
        // write your code here
        int len = strs.size();
        if(len == 0 )return "";
        if(len == 1) return strs[0];
        int mLen = INT_MAX;
        for(int i= 0; i< len; i++) {
            int sLen = strs[i].size();
            mLen = min(mLen, sLen);
        }
        
        int low = 0;
        int high = mLen;
        
        while(low <= high) {
            int mid = (low+high) /2;
            bool isPrefix = true;
            for(int i = 1; i< strs.size(); i ++) {
                if(strs[i][mid] != strs[0][mid]) {
                    isPrefix = false;
                    break;
                }
            }
            
            if(isPrefix) low = mid +1;
            else high = mid -1;
        }
        
        return strs[0].substr(0, low);
    }
};
