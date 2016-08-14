public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, Set<String>> cache = new HashMap<>();
        List<String> res = new ArrayList<>();
        res.addAll(wordBreakHelper(s,wordDict, cache));
        return res;
    }
    
    private Set<String> wordBreakHelper(String s, Set<String> dict, Map<String,Set<String>> cache){
        
        if(cache.containsKey(s)) return cache.get(s);
        Set<String> result = new HashSet<String>();
        if(dict.contains(s)) {
            result.add(s);
        }
        
        for(int i = 1; i < s.length(); i++){
            String left = s.substring(0,i);
            String right = s.substring(i);
            Set<String> lResult = wordBreakHelper(left,dict,cache);
            Set<String> rResult = wordBreakHelper(right,dict,cache);
            for(String l :lResult){
                for(String r: rResult){
                    result.add(l+" "+r);
                }
            }
        }
        cache.put(s,result);
    return result;
    }
    
}
