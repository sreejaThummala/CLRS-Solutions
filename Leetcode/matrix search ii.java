public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int r = matrix.length-1;
       int c = 0;
       while(r>=0 && c< matrix[0].length){
           if(target < matrix[r][c]){
               r--;
               continue;
           }
           
           if(target > matrix[r][c]){
               c++;
               continue;
           }
           
           return true;
       }
       
       return false;
    }
}
