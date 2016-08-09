/*
Pigeon hole principle
*/

int maximumGap(int[] nums){
  int n = nums.length;
  if(n<=1) return 0;
  int maxE = Integer.MIN_VALUE;
  int minE = Integer.MAX_VALUE;
  for(int i = 0; i < n; i++){
    maxE = Math.max(maxE, nums[i]);
    minE = Math.min(minE, nums[i]);
  }
  
  
  double len = doublw(maxE-minE)/double(n-1);
  int[] maxA = new int[n];
  int[] minA = new int[n];
  Array.fill(maxA, Integer.MIN_VALUE);
  Array.fill(minA, Integer.MAX_VALUE);
  
  for(int i = 0; i < n; i++){
    int idx = nums[i]-minE/len;
    maxA[idx] = Math.max(nums[i],maxA[idx]);
    minA[idx] = Math.min(nums[i],minA[idx]);
  }
  
  int gap = 0;
  int prev = maxA[0];
  
  for(int i =1; i < n; i++){
    if(minA[i] == Integer.MIN_VALUE) continue;
    gap = Math.max(gap, minA[i]-prev);
    prev = maxA[i];
  }
  
  return gap;
  
}
