#Question
Given a matrix where every cell has some numbers. Count number of ways to reach bottom right from top left with exactly k coins.
i,j - > i+1,j || i,j+1

#Analysis

```
C(i,j,k) == C(i-1,j,k-m[i][j]) + C(i,j-1,k-m[i][j])

if(i == 0 || j==0 ) if ( m[0][0] == k) C(i,j,k) = 1 else 0
if(!isValid(i,j)) C(i,j,k) = 0
```
Overlapping subproblems exist
- so dynamic programming applies
- states (i,j,k)

```java
int[][][] dp;

int pathCount(int[][] M, int k){
  int m = M.length;
  int n = M[0].length;
  
  dp = new int[m][n][k];
  for(int[][] arr_1: dp){
    for(int[] arr_2: arr_1){
      Arrays.fill(arr_2,-1);
    }
  }
  
  return pathCountHelper(M,m,n,k);
}

int pathCountHelper(int[][] M, int m, int n, int k){
  if(!isValid(m,n)) return 0;
  if( m ==0 && n == 0) if(k == M[m][n]) return 1; else return 0;

  if(dp[m][n][k] != -1) return dp[m][n][k];
  dp[m][n][k] = pathCountHelper(M,m-1,n,k-M[m][n]) + pathCountHelper(M,m,n-1,kM[m][n]-);
  return dp[m][n][k];
}


