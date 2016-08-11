public class Solution {
    public int sqrt(int x) {
        if(x<0){
            return -1;
        }
        
        if(x==0||x==1){
            return x;
        }
        
        int mid = x/2;
        int left = 0;
        int right = x;
        
        while(left<mid && right > mid){
            if(mid == x/mid) return mid;
            if(mid<x/mid) left = mid;
            if(mid>x/mid)right = mid;
            mid = (left+right)/2;
        }
        return mid;
        
    }
}
