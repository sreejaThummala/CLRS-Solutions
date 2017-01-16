public class Solution {
    public boolean validWordSquare(List<String> words) {
        int len = words.size();
 
        for(int k = 0; k < len; k++){
            for(int j = 0; j < words.get(k).length(); j++){
                if(j>=len || words.get(j).length() <= k || words.get(j).charAt(k) != words.get(k).charAt(j))
                {
                    return false;
                }
            }
        }
        
        return true;
        
    }
}
