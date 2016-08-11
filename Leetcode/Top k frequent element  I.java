//bucket sort inspired - O(n)
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        int maxFreq = -1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            int count = 1;
            if(map.containsKey(num)){
                count = map.get(num)+1;
            }
            
            map.put(num,count);
            maxFreq = Math.max(maxFreq, count);
        }
        
        List[] bucket = new ArrayList[maxFreq];
        for(int i = 0 ; i < maxFreq; i++){
            bucket[i] = new ArrayList();
        }
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            bucket[entry.getValue()-1].add(entry.getKey());
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for(int i = maxFreq-1; i >=0 && k>0; i--){
            for(Object j : bucket[i]){
                if(k==0) break;
                res.add((Integer)j);
                k--;
            }
            
        }
        
        return res;
        
        
    }
}
