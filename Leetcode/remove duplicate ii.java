public class Solution {
      public int removeDuplicates(int[] A) {
        int len = A.length;
        if(len <=2 ) return len;
        int index = 2;
        for(int i = index; i < len; i++){
            if(A[i] != A[index-2]){
                A[index] = A[i];
                index++;
            }
        }
        return index;
    }
}
