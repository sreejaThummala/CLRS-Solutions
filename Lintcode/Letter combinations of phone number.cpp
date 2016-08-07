class Solution {
public:
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    vector<string> letterCombinations(string& digits) {
        // Write your code here
        vector<string> res;
        string prefix = "";
        _letterCombinations(digits, prefix,res);
        return res;
    }

private:
    void _letterCombinations(string &digits, string prefix, vector<string> &res){
        int pLen = prefix.size();
        int dLen = digits.size();
        if(dLen == 0 ) return;
        if(pLen >= dLen) {
            res.push_back(prefix);
            return;
        }
        
        int i = (digits[pLen] - '0' - 2);
        int b = ((i==5 ||  i==7) ? 4: 3);
        i = i*3;
        if(digits[pLen] >= '8') i++;
        for(int  j = 0 ; j<b; j++){
            char next = i+j+'a';
            string nPrefix = prefix+next;
            _letterCombinations(digits,nPrefix,res);
        }
    }
};
