class Solution {
    
    Map<String, Integer> cache = new HashMap<>();
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){
                cache = new HashMap<>();
                res += _helper((long)A[j]-(long)A[i], j+1,j, A);
            }
        }
        
        return res;
    }
    
    int _helper(long diff, int start, int present, int[] A){
        int len = A.length;;
        if(start >= len) {
            return 0;
        }
        
        String key = new StringBuilder().append(diff).append(present).toString();
        if(cache.containsKey(key)) return cache.get(key);
        
        int res = 0;       
        if( (long)A[start]-(long)A[present] == diff) {
                res += _helper(diff, start+1, start, A)+1;
        } 
        res += _helper(diff, start+1, present, A);
        
        cache.put(key,res);
        return res;
    }
    
}
