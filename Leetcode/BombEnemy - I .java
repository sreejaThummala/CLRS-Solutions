public class Solution{

public boolean bombEnemies(String[][] grid){
  int n = grid.length;
  int m = grid[0].length;
  Integer[][] steps = new Integer[n][m];
  
  for(int i = 0; i < n; i++){
    Arrays.fill(steps[i], 0);
  }
  for(int i = 0; i < n ; i++){
    for(int j = 0; j < m ; j++){
      if(grid[i][j] == "X"){
        bfs(grid, steps, i, j, n, m);
  }}}
  
  int maxValue = 0;
  for(int i = 0; i < n; i++){
    for(int j = 0; j < m ; j++){
      maxValue = Math.max(maxValue, steps[i][j]);
  }}
  
}

private void bfs(String[][] grid, Integer[][] steps, int i, int j, int n, int m){
  for(int k = i+1; k< n && grid[k][j] != "Y"; k++){
    steps[k][j]++;
  }
  
  for(int k = j+1; j<m && grid[i][k] != "Y" ; k++){
    steps[i][k]++;
  }
  
  for(int k = i; k>=0 && grid[k][j] != "Y" ; k--){
    steps[k][j]++;
  }
  
  for(int k = j; k>=0 && grid[i][k] != "Y"; k--){
    steps[i][k]++;
  }
}
}
