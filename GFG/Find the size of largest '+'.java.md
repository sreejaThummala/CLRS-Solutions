#Question
Given a NXN binary matrix, find the size of the largest + formed b all 1s

```java
int findLargestPlus(int M[][]){
  int N = M.length;
  
  int left[N][N], right[N][N], top[N][N], bottom[N][N];
  
  for(int i = 0; i < N; i++){
    top
  }
  
  for(int i = 0; i < N; i++){
    for(int j = 1; j < N; j++){
      if(M[i][j] == 1) left[i][j] = left[i][j-1]+1;
    }
  }
  
  for(int i = 1; i < N; i++){
    for(int j = 0; j < N; j++){
      if(M[i][j] == 1) top[i][j] = top[i-1][j]+1;
    }
  }
  
  for(int i = N; i >=0; i--){
    for(int j = N; j >=1; j--){
      if(M[i][j] == 1) right[i][j] = right[i][j+1]+1;
    }
  }
  
  for(int i = N; i >=1; i--){
    for(int j = N; j>=0; j--){
      if(M[i][j] == 1) bottom[i][j] = bottom[i+1][j]+1;
    }
  }
  
  
}
