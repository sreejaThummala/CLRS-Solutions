class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
public:
    vector<int> searchRange(vector<int> &A, int target) {
        // write your code here
        vector<int> result;
        int len = A.size();
        if(len == 0) {
            result.push_back(-1);
            result.push_back(-1);
            return result;
        }
        //lower range
        int low = 0;
        int high = len-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(A[mid] < target) low = mid +1;
            else if(A[mid] >= target) high = mid-1;
        }
        if(A[low] != target){
            result.push_back(-1);
            result.push_back(-1);
            return result;
        }
        result.push_back(low);

        low = low;
        high = len-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(A[mid] <= target) low = mid +1;
            else if(A[mid] > target) high = mid-1;
        }
        
        result.push_back(high);
        
        return result;

    }
};
