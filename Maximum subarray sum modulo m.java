public int getMaximumSumModuloM(int[] nums , int M){
  int n = nums.length;
  int[] sum = new int[n];
  sum[0] = nums[0];
  int result = nums[0];
  
  TreeSet<Integer> set  = new TreeSet<Integer>();
  set.add(nums[0]);
  
  for(int i = 1; i < n; i++){
    sum[i] = sum[i-1]+nums[i];
    sum[i] %= M;
    Integer a = set.ceil(sum[i]);
    if(a != null)
    result = Math.max(sum[i]-a+M)%M, res);
    set.add(sum[i]);
    
  }
  
  return result;
}
