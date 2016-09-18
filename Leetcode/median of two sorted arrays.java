public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        int L = N1+N2;
        if(N1 == 0) return findMedian(nums2);
        if(N2 == 0) return findMedian(nums1);
        
        if(L%2 != 0) return findKthSortedArrays(nums1,nums2, L/2);
        
        double M1 =  ((double)findKthSortedArrays(nums1,nums2,(L)/2-1));
        double M2 = ((double)findKthSortedArrays(nums1,nums2,L/2));
    
        return (M1+M2)/2;
        
    }
    
    private double findMedian(int[] nums1)
    {
        int L  = nums1.length;
        if(L%2 == 0) return ((double)nums1[(L)/2-1]+ (double)nums1[L/2]) /2;
        return  (double)nums1[L/2];
    }
    
    private int findKthSortedArrays(int[] nums1, int[] nums2, int k)
    {
        if(nums1.length > nums2.length)return findKthSortedArrays(nums2,nums1,k);
        if(k<0) return -1;
        if(k==0) return Math.min(nums1[0],nums2[0]);
        int low = 0;
        int high = Math.min(nums1.length,k);

        while(low<=high)
        {
            int k1 = (low+high)/2;
            int k2 = k-k1;
            
            int L1 = (k1 == 0)? Integer.MIN_VALUE: nums1[k1-1];
            int L2 = (k2 == 0)? Integer.MIN_VALUE: nums2[k2-1];
            int R1 = (k1 == nums1.length)? Integer.MAX_VALUE: nums1[k1];
            int R2 = (k2 == nums2.length )? Integer.MAX_VALUE: nums2[k2];
            
            if(L2<=R1 && R1 <= R2) return R1;
            if(L1<=R2 && R2 <= R1) return R2;
            if (R1 <= R2) low = k1 + 1;	
            else high = k1 - 1;
        }
        return -1;
    }
}
