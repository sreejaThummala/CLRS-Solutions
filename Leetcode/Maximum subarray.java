public class Solution {
    public int maxSubArray(int[] nums) {
        int pMax = nums[0];
        int res = nums[0];
        for(int i =1; i <  nums.length; i++){
            pMax = Math.max(pMax+nums[i], nums[i]);
            res = Math.max(pMax, res);
        }
        return res;
    }
}
