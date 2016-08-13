public List<Integer> largeDivisibleSubset(int[] nums){
  Arrays.sort(nums);
  int n = nums.length;
  int[] dp = = new int[n];
  Arrays.fill(dp,1);
  
  int[] pre = new int[n];
  int res_idx = 0;
  int res = -1;
  Arrays.fill(pre,0);
  for(int i = 0; i < n; i++){
    for(int j = 0; j<i; j++){
      if(nums[i]%nums[j] ==0 && dp[j]+1 > dp[i]){
        dp[i] = dp[j]+1;
        pre[i] = j;
      }
      if(res < dp[i]){
        res = dp[i];
        res_idx = i;
      }
    }
  }
  
  
  List<Integer> ans = new ArrayList<>();
  while(pre[res_idx] != -1){
    ans.add(nums[res_idx];
    res_idx = pre[res_idx];
  }
  
  return ans;
}
