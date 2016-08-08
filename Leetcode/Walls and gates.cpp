public void wallsAndGates(int[][] rooms){
  for(int i = 0; i< rooms.length; i++){
    for(int j = 0; j < rooms[0].length; j++){
      if(rooms[i][j]== 0)
      dfs(rooms, i, j , 0);
  }}
}

private void dfs(int[][] rooms, int row,int col, int d){
  int n = rooms.length;
  int m = rooms[0].length;
  
  if(i<0||j<0||i>=n||j>=m||rooms[i][j]<d)return;
  rooms[i][j] =d;
  dfs(rooms,row-1,col,d+1);
  dfs(rooms,row,col-1,d+1);
  dfs(rooms,row+1,col,d+1);
  dfs(rooms,row,col+1,d+1);
}
