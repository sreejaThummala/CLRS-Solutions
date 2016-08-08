public class Solution{

  public int bombEnemies(char[][] matrix){
    int maxNumber = 0;
    int rowHit = 0;
    int n = matrix.size();
    int m = matrix[0].size();
    
    int[] columnHit = mew int[m];
    
    for(int i = 0; i < n; i++){
      for(int j =0; j < m; j++){
        if(j==0||matrix[i][j-1] == 'Y'){
          rowHit = 0;
          for(int k = j; k<m && matrix[x][k] != 'Y' ; k++){
            if(matrix[i][k] == 'X') rowHit++;
          }
        }
        
        if(i == 0|| matrix[i-1][j]=='Y'){
          columnHit[j]=0;
          for(int k = i; j < n && matrix[k][x] != 'Y' ; k++){
            if(matrix[k][j] == 'X') columnHit[j]++;
          }
        }
        
        if(matrix[i][j] == '0'){
          maxNumber = Math.max(maxNumber, rowHit+columnHit[j]);
        }
      }
    }
  }
}
