public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z==0) return true;
        if(z>x+y) return false;
        int gcd = getGCD(x,y);
        if(gcd == 0) return false;
        return z%gcd == 0;
    }
    
    private int getGCD(int x, int y){
        if(y==0) return x;
        return getGCD(y, x%y);
    }
}
