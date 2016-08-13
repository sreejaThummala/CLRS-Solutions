public class Solution {
    public int[] searchRange(int[] A, int target) {
          int[] ret = new int[]{-1, -1};
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] < target)
                start = mid + 1;
            else
                end = mid;
        }
        int low;
        if (A[start] != target)
            return ret;
        else
            low = start;
        start = 0;
        end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] < target + 1)
                start = mid + 1;
            else
                end = mid;
        }
        int high = A[start] == target ? start : start - 1;
        ret[0] = low;
        ret[1] = high;
        return ret;
        
    }
}
