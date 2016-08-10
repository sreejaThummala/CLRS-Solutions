public class Solution{
  public boolean isPerfectSquare(int num){
  
    long left = 1; //poisitve integer 
    long right = num;
    
    while(left <= right){
      long mid = left + (right - left)/2; // mid*mid will be greater than Integer.MAX_VALUE when num is near Integer.MAX_VALUE
      if(mid * mid == num) return true;
      if(mid * mid < num) {
        left = mid + 1;
        continue;
      }
      
      right = mid -1;
    }
    
    return false;
  }
}
