public class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            int t1 = max*nums[i];
            int t2 = min*nums[i];
            max = Math.max(t1, Math.max(t2,nums[i]));
            min = Math.min(t1, Math.min(t2, nums[i]));
            res = Math.max(max,res);
        }
        
        return res;
    }
}
