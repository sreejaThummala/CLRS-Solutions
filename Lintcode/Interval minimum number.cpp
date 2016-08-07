/**
 * Definition of Interval:
 * classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 */
class Solution {
    vector<int> t;
    int len;
public:
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    vector<int> intervalMinNumber(vector<int> &A, vector<Interval> &queries) {
        // write your code here
        len = A.size();
        t.resize(2*(len+1),INT_MAX);
        for(int i=0;i<len;i++){
            t[i+len] = A[i];
        }
        build();
        vector<int> results;
        for(int i=0;i<queries.size();i++){
            results.push_back(query(queries[i].start,queries[i].end ));
        }
        
        return results;
       
        
    }
    
    private:
    void build() {
        for (int i = len - 1; i > 0; --i) t[i] = min(t[i<<1] , t[i<<1|1]);
    }
    int query(int l, int r) {  // sum on interval [l, r)
  int res = INT_MAX;
  for (l += len, r += len+1; l < r; l >>= 1, r >>= 1) {
    if (l&1) res = min (res,t[l++]);
    if (r&1) res = min(res,t[--r]);
  }
  return res;
}
    
};
