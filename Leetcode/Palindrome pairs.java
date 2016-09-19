public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> tmp = new ArrayList<>();
        Map<String, Integer> idxMap = new HashMap<>();
        for(int i = 0; i < words.length; i++) idxMap.put(words[i],i);
        for(int i = 0; i < words.length; i++){
            String word = words[i];
                List<Integer> res = new ArrayList<>();
                if(word.length() == 0)
                {
                    for(String w: words)
                    {
                        if(isPalindrome(w) && w.length() != 0)
                        {
                            res = new ArrayList<>();
                            res.add(i);
                            res.add(idxMap.get(w));
                            tmp.add(res);
                        }
                    }
                }
                for(int j = 0; j < word.length() ; j++)
                {
                    String front = word.substring(0,j);
                    String back = word.substring(j);
                    String rFront = new StringBuilder(front).reverse().toString();
                    String rBack = new StringBuilder(back).reverse().toString();
                    
                    if(isPalindrome(back)&&idxMap.containsKey(rFront)){
                        res = new ArrayList<>();
                        if(idxMap.get(word)!=idxMap.get(rFront)){
                        res.add(idxMap.get(word));
                        res.add(idxMap.get(rFront));
                        tmp.add(res);
                        }
                    }
                    
                    if(isPalindrome(front)&&idxMap.containsKey(rBack)){
                        res = new ArrayList<>();
                        if(idxMap.get(word)!=idxMap.get(rBack)){
                        res.add(idxMap.get(rBack));
                        res.add(idxMap.get(word));
                        tmp.add(res);
                        }
                    }
                }
            
        }
        
        return tmp;
    }
    
    private boolean isPalindrome(String word)
    {
        for(int i = 0; i < word.length() /2; i++)
        {
            if(word.charAt(i) != word.charAt(word.length()-1-i))
            {
                return false;
            }
        }
        
        return true;
    }
}
