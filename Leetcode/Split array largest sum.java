public class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        for(int i : nums) sum += i;
        return Math.toIntExact(binarySearch(nums,m, sum));
        
    }
    
    private long binarySearch(int[] nums, int m , long sum){
        long l = 0;
        long r = sum;
        while(l<=r){
            long mid = l+(r-l)/2;
            if(valid(nums,m,mid)){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    
    private boolean valid(int[] nums, int m, long mid){
        long tmp = 0;
        int count = 1;
        for(int i : nums){
            if(i>mid) return false;
            tmp += i;
            if(tmp  > mid ){
                if(++count > m) return false;
                tmp = i;
            
            }
            
        }
   
        return true;
    }
}
