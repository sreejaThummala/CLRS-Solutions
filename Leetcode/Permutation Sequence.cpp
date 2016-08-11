class Solution {
public:
    string getPermutation(int n, int k) {
        k--;
        vector<int> count(n+1,0);
        count[0]=1;
        count[1] = 1;
        for(int i = 2; i<n; i++){
            count[i] = i*count[i-1];
        }
        
        vector<string> per;
        for(int i = 1; i<= n ; i++) {
             per.push_back(to_string(i));
        }

        string res = "";
        for(int i = n-1; i>=0; i--){
            res += per[(k/count[i])];
            per.erase(per.begin()+(k/count[i]));
            k = k%count[i];
        }
        
        return res;
    }
};
