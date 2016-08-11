public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 0) return false;
        int exp =  (int)(Math.log(num)/ Math.log(4));
        return num == Math.pow(4,exp);
        
    }
}
