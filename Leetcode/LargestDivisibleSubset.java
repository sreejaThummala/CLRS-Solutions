public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
      List<Integer> res=new ArrayList<>();
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 1, maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        map.put(nums[i], nums[j]);
                    }
                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }
        int key = nums[maxIndex];
        res.add(key);
        while (map.containsKey(key)) {
            res.add(map.get(key));
            key = map.get(key);
        }
        return res;
    }
}
