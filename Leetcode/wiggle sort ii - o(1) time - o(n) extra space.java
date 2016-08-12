public class Solution {
    public void wiggleSort(int[] nums) {
        
        IntArray arr = new IntArray();
        arr.arr = nums;
        int n = nums.length, mid = (n-1)/2, index = 0;
        partition(arr,(n-1)/2,0,n-1);

        int[] temp = new int[n];
        for (int i = 0; i <= mid; i++) {
            temp[index] = nums[mid-i];
            if (index+1 < n) {
                temp[index+1] = nums[n-1-i];
            }
            index += 2;
        }
        System.arraycopy(temp, 0, nums, 0, n);
        
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
