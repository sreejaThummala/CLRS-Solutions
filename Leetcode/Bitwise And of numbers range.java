/**
The only bits that will be 11 will be bits that are common to the upper bits of AA and BB. Everything else will have at least one instance of a 00 in that range. So just start from the high order bit downwards. Output the matching bits. As soon as you hit a disagreement between the binaries of AA and BB (which will be 00 in AA and 11 in BB) output zeros until you get to the length of BB.
**/
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int x = 0;
        while((m|x) < n){
            x = (x<<1)|1;
        }
        
        return m & ~x;
        
    }
}
