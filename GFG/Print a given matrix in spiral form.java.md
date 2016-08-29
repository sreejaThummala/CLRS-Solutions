#Question
Given a 2D matrix, print it in spiral form.

```java

void print(int[][] M){
  int m = M.length;
  int n = M[0].length;
  
  int i, k = 0, l = 0;
  
  while(k < m && l < n){
    for( i = l; i < n; i++){
      System.out.println(M[k][i]);
    }
    k++;
    
    for(int i = k ; i < n; i++){
      System.out.println(M[i][n-1]);
    }
    
    n--;
    
    if(k<m){
      for(i = n-1; i>=l; --i){
        System.out.println(M[m-1][i]);
      }
      m--;
    }
    
    if(l<n){
      for(i = m-1; i >=k; --i){
        System.out.println(M[i][l]);
      }
      l++;
    }
  
  }

}
