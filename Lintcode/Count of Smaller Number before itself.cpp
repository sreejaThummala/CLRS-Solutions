#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>

using namespace std;
using namespace __gnu_pbds;

class Solution {
public:
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */
    vector<int> countOfSmallerNumberII(vector<int> &A) {
        // write your code here
        typedef pair<int,int> pli;
        tree<pli, null_type, less<pli>, rb_tree_tag, tree_order_statistics_node_update> t;
        
        vector<int> ans;
        ans.resize(A.size());

        int id = 0;
        
        for(int i = 0 ; i< A.size(); i++) {
            ans[i] = t.order_of_key({A[i],0});
            t.insert({A[i],id});
            id++;
        }
        
        return ans;
    }
};
