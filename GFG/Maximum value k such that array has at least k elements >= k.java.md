```java

//HBASE
int findMaxNum(int[] arr)
{

  int n  = arr.length;
  int[] fre = new int[n+1]
  
  for(int i = 0; i < n; i++)
  {
    if(arr[i]<n) freq[arr[i]]++;
    else freq[n]++;
  }
  
  int sum = 0;
  for(int i = n; i > 0; i--)
  {
    sum += freq[i];
    
    if(sum >=i) return i;
  }
  
  return -1;
}
