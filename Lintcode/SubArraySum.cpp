class Solution {
public:
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    vector<int> subarraySum(vector<int> nums){
        // write your code here
        unordered_map<int,int> table;
        int sum = 0;
        vector<int> res;
        table[sum] = 0;
        for(int i=0; i< nums.size();i++) {
            sum += nums[i];
            if(table.count(sum)>0) {
                res.push_back(table[sum]);
                res.push_back(i);
                return res;
            }
            table[sum] = i+1;
        }
        return res;
    }
};
