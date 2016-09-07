#Question
Given a number n, find two pairs that can represent the number as sum of two cubes

```java
void findPairs(int n)
{

  int cubeRoot = Math.pow(n,1.0/3.0);
  
  int cube[cubeRoot+1];
  
  for(int i = 1; i <= cubeRoot; i++)
  {
    cube[i] = i*i*i;
  }
  
  int l = 1;
  int r = cubeRoot;
  
  while(1<r)
  {
    if(cube[l]+cube[r]<n) l++;
    else
    if(cube[l]+cube[r]>n)r--;
    else {
      //print
      l++;
      r--;
      }
  }
}
