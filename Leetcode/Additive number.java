public class Solution{
  public boolean isAdditiveNumber(String num){
    Map<String,String>[] dp = new Map<String,String>[]();
    Arrays.fill(dp,new HashMap<String,String>());
    for(int i = 1; i < num.length(); i++){
      for(int j = i-1; j >=0; j--){
        String cur = num.subString(j+1,i-j);
        if(num.charAt(j+1) == '0' && cur.length() >1) continue;
        if(dp[j].containsKey(cur)){
         int sum = Integer.parseInt(dp.get(j).get(cur))+Integer.parseInt(cur);
         dp[i].put(sum,cur);
         }
         
         int sum = Integer.parseInt(num.subString(0,j+1))+ Integer.parseInt(cur);
         dp[i].put(sum,cur);
     }
    }
    for(int j = nums.length()-2; j>=0; j--){
      String cur = num.subString(j+1);
      if(dp[j].contains(cur)){
      return true;
      }
    }
    
    return false;
  }
}
