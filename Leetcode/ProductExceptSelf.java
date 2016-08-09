public class Solution{
  public int[] productExceptSelf(int[] nums){
    int len = nums.length;
    
    int[] res = new int[len];
    if(len == 0) return res;
    
    res[len-1] = 1;
    for(int i = len-2; i >=0; i--){
      res[i] = res[i+1]*nums[i+1];
    }
    
    int left = 1;
    for(int i = 0; i <len;i++){
      res[i] = left*res[i];
      left = left*nums[i];
    }
    
    return res;
  }
}
