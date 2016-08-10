public class Solution{
  public boolean isPerfectSquare(int num){
  
    if(num < 0) return false;
    int left = 0;
    int right = num;
    
    while(left <= right){
      int mid = left + (right - left) /2;
      if(mid * mid == x) return true;
      if(mid * mid < x) {
        left = mid + 1;
        continue;
      }
      
      right = mid -1;
    }
    
    return false;
  }
}
