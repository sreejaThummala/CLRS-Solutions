public class Solution{
  public int threeSmaller(int[] nums, int target){
    Arrays.sort(nums);
    int cnt = 0;
    for(int i = 0; i < nums.length - 2; i++){
      int left = i+1;
      int right = nums.length-1;
      while(left < right){
        int sum = nums[i]+nums[left]+nums[right];
        
        if(sum>=target){
          right--;
        }else{
          cnt+= right-left; //i and left are fixated. third can take values from left +1 to right
          left++;
        }
      } 
    }
    return cnt;
  }
  
}
