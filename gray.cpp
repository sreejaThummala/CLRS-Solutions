class Solution {
public:
    /**
     * @param n a number
     * @return Gray code
     */
    vector<int> grayCode(int n) {
        // Write your code here
            vector<int> v(1,0);
    for (int i=1;i<(1<<n);i++) v.push_back(v[i-1]^(i&-i));
    return v;
    }
};
