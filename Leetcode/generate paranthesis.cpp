class Solution {
public:
    void _generateParanthesis(int left, int right, string str, vector<string>& results, int n){
        if(right > left) return;
        if(left > n) return;
        if(right == left && right == n){
            results.push_back(str);
            return;
        }
        
        _generateParanthesis(left+1, right, str+"(", results, n);
        _generateParanthesis(left,right+1,str+")", results,n);
        
        
    }
    vector<string> generateParenthesis(int n) {
        vector<string> results;
        _generateParanthesis(0,0,"",results,n);
        return results;
        
    }
};
