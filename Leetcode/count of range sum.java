public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count  = 0;
        long[] sum =  new long[nums.length+1];
        TreeMap<Long,Integer> map = new TreeMap<Long,Integer>();
        map.put(0L,1);
        for(int i = 0; i < nums.length; i++){
            sum[i+1] = sum[i]+nums[i];
            int cnt = 1;
            if(map.containsKey(sum[i+1])) cnt = map.get(sum[i+1])+1;
            map.put(sum[i+1],cnt);
        }
        
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            map.put(sum[i],map.get(sum[i])-1);
            if(map.get(sum[i])==0) map.remove(sum[i]);
            for(Map.Entry<Long,Integer> entry: map.subMap(sum[i]+lower, sum[i]+upper+1).entrySet()){
                res += entry.getValue();
            }
        }
        
        return res;
        
        
    }
}
