public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mark = new int[n];
        
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int k = 0 ; k < words[i].length(); k++){
                mark[i] |= 1 << (words[i].charAt(k) - 'a');
            }
            
            for(int j = 0; j <i; j++){
                if((mark[j]&mark[i]) == 0){
                    res = Math.max(res, words[i].length()*words[j].length());
                }
            }
        }
        
        return res;
        
    }
}
