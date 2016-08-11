public class Solution {
    public int singleNumber(int[] A) {
        
        if(A == null){
            return -1;
        }
        
        int length = A.length;
        
        if(length == 0 ){
            return -1;
        }
        
        if(length == 1){
            return A[0];
        }
        
        if(length%2==0){
            return -1;
        }
        
        int elem = A[0];
        
        for(int i=1;i<length;i++){
            elem = elem ^ A[i];
        }
        
        return elem;
        
    }
}
