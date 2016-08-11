class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int len = nums.size();
        
        sort(nums.begin(), nums.end());
        
        int mdiff = INT_MAX;
        int closest = 0;
        if(len <= 3) {
            for(int i = 0; i < len; i++) closest += nums[i];
            return closest;
        }

        for(int i = 0; i<len-2 ; i++)
        {
            int start = i+1;
            int end = len-1;
            while(start < end && start < len && end > i+1)
            {
                int diff = nums[start] + nums[end] + nums[i] - target;
                
                if(abs(diff)<mdiff) 
                {
                 closest = nums[start]+ nums[end] + nums[i];
                 mdiff = abs(diff);
                    
                }
                if(diff<0)
                {
                    start++;
                }
                
                if(diff> 0)
                {
                    end--;
                }
                
                if(diff == 0) return closest;
            }
        }
        
        return closest;
    }
};
