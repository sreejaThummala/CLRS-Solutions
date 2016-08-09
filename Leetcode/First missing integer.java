public class Solution{
  public int firstMissingPositive(int[] nums){
    int len = nums.length;
    
    int p = 0; 
    for(int i = 0; i < len; i++){
      if(nums[i] > 0){
        int tmp = nums[p];
        nums[p] = nums[i];
        nums[i] = tmp;
        p++;
      }
    }
    
    for(int i = 0; i < p ; i++){
    if(Math.abs(nums[i])-1 < p && nums[Math.abs(nums[i])-1] > 0)
      nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
    }
    
    
    for(int i = 0; i < p; i++){
      if(nums[i]>0) return i+1;
    }
    return p+1;
  }
}
