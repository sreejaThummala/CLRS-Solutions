class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        
        int len = nums.size();
        
        vector<vector<int>> results;
        
        sort(nums.begin(), nums.end());
        
        for(int i = 0; i< len -2; i++)
        {
            int start = i+1;
            int end = len-1;
            if (!(i == 0 || nums[i] > nums[i - 1])) continue;
            while(start < end)
            {
               int sum = nums[start]+ nums[end];
               if(sum< -nums[i]) start++;
               if(sum> -nums[i]) end--;
               if(sum == -nums[i])
               {
                   results.push_back(vector<int>({nums[i], nums[start], nums[end]}));
                   start++;
                   end--;
                   
              while(nums[start] == nums[start-1]) start++;
               while(nums[end] == nums[end+1])end--;
               }
               
               
            }
        }
        
        return results;
        
    }
};
