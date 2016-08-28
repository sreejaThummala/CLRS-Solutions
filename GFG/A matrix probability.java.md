#Question
Given a rectangular matrix, we can move from all the current cell in 4 directions with equal probability.
Calculate the probability that after N moves from a given position (i,j) in the matrix.

``` java
public int getNStep(int m, int n,int i, int j int N){
    return findProbability(m,n,i,j,N);
}

private double findProbability(int m, int n, int i, int j , int N){
  if(!isValid(x,y,m,n)) return 0;
  if(N==0) return 1.0;
  
  double prod = 0.0;
  
  prob += findProbability(m,n,i-1,j,N-1)*0.25;
  prob += findProbability(m,n,i+1,j,N-1)*0.25;
  prob += findProbability(m,n,i,j-1,N-1)*0.25;
  prob += findProbability(m,n,i,j+1,N-1)*0.25;
  
  return prob;

}

```
