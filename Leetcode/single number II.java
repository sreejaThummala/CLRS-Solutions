public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; i++ ){
            int cnt = 0;
            for(int j : nums){
                if((j & (1<<i))!=0) cnt++;;
               
            }
            
            int shift = cnt%3;
            res = res | (shift<<i);
        }
        
        return res;
        
    }
}
