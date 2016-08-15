public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int cur = 0;
        int start = 0;
        int end = 0;
        while(true){
            if(cur<s){
                if(end == nums.length) break;
                cur += nums[end++];
            }
            else{
                min = Math.min(min, end-start); //no need for start boundary check
                //end will always be less than start - positive integers. that is why two pinters work
                cur -= nums[start++];
            }
        }
        
        return min == Integer.MAX_VALUE? 0: min;
    }
}
