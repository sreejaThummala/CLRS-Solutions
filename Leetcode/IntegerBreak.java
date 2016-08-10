public class Solution{
  public int integerBreak(int n){
    if(n==2 || n==3) return n-1;
    if(n==1 || n==0) return n;
    int res = 1;
    while(n > 4){
      res*=3;
      n -= 3;
    }
    
    return res*n;
  }
}
