public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++){
            String key  = getUnorderedStringHash(strs[i]);
            List<String> values = new ArrayList<String>();
            if(map.containsKey(key)){
                values = map.get(key);
            }
            
            values.add(strs[i]);
            map.put(key,values);
        }
        
        List<List<String>> res  = new ArrayList<List<String>>();
        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        
        return res;
    }
    
    //O(1) hash
    private String getUnorderedStringHash(String s){
        int[] count = new int[26];
        StringBuffer sb  = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)-'a']++;
            
        }
        
        for(int i = 0; i < 26; i++){
            sb.append(count[i]);
            sb.append(":");
        }
        
        return sb.toString();
    }
}
