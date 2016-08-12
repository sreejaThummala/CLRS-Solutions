public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0; 
        int end = nums.length -1;
        IntArray arr = new IntArray();
        arr.arr = nums;
        k = end-k+1;
        return partition(arr,k,start,end);
        
    }
    
    private int partition(IntArray nums, int k, int start, int end){
        int lo = start;
        int mid = start+1;
        int hi = end;
        int pivot = nums.arr[lo];
        int[] arr = nums.arr;
        while(mid <= hi){
            switch(compare(arr[mid],pivot)){
                case -1:
                    swap(nums, lo++, mid++);
                    break;
                case 0:
                    mid++;
                    break;
                case 1:
                    swap(nums, mid, hi--);
                    break;
            }
        }
        if(lo > k) return partition(nums,k,start,lo-1);
        if(hi < k) return partition(nums,k,hi+1,end);
        return pivot;
        
    }
    
    private int compare(int i , int j){
        if(i - j<0) return -1;
        if(i-j == 0) return 0;
        if(i - j > 0) return 1;
        return -2;
    }
    
    private void swap(IntArray nums, int i, int j){
        int temp = nums.arr[i];
        nums.arr[i] = nums.arr[j];
        nums.arr[j] = temp;
    }
    
    
}

class IntArray{
    int[] arr;
}
