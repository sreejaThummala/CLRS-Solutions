public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        int min = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<Integer>();
        for(int i = nums.length - 1; i >=0; i--){
            if(nums[i]< min){
                res.add(0);
            }else{
                
        
            int cnt = 0;
            for(Map.Entry<Integer,Integer> entry: map.subMap(min,true,nums[i],false).entrySet()){
                cnt += entry.getValue();
            }
            
            res.add(cnt);
                
            }
            int cnt = 1;
            if(map.containsKey(nums[i])) cnt = map.get(nums[i])+1;
            map.put(nums[i],cnt);
            min = Math.min(min, nums[i]);
        }
        
        Collections.reverse(res);
        return res;
        
    }
}
