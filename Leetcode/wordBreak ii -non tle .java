public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> cache = new HashMap<>();
        return wordBreakHelper(s,wordDict, cache);
    }
    
    private List<String> wordBreakHelper(String s, Set<String> dict, Map<String,List<String>> cache){
        
        if(cache.containsKey(s)) return cache.get(s);
        List<String> result = new ArrayList<String>();
        if(dict.contains(s)) {
            result.add(s);
        }
        
        for(int i = 1; i < s.length(); i++){
            String left = s.substring(0,i);
            String right = s.substring(i);
            if(!dict.contains(left)) continue;
            List<String> rResult = wordBreakHelper(right,dict,cache);
             for(String r: rResult){
                    result.add(left+" "+r);
            }
        }
    cache.put(s,result);
    return result;
    }
    
}
