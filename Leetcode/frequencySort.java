public class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        Map<Character,Integer> freq = new HashMap<>();
        List[] bucket = new List[len+1];
        for(int i = 0; i < len; i++){
            freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)+1);;
        }
        
        for(Character c: freq.keySet()){
            if(bucket[freq.get(c)]==null) bucket[freq.get(c)] = new ArrayList<Integer>();
            bucket[freq.get(c)].add(c);
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i = len; i >= 0; i--){
            if(bucket[i] == null)continue;
            for(Object j : bucket[i]){
                for(int k =0 ; k < i; k++){
                builder.append((char)j);
                }
            }
            
        }
        
        return builder.toString();
        
    }
}
