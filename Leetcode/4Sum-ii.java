public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ans = 0;
        Map<Integer,Integer> dict = new HashMap<Integer,Integer>();
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++){
                int c = 1;
                Integer tmp = A[i]+B[j];
                if(dict.containsKey(tmp)){
                    c += dict.get(tmp);
                }
                
                dict.put(tmp, new Integer(c));
            }
        }
        
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                Integer tmp = -C[i]-D[j];
                if(dict.containsKey(tmp)){
                    ans += dict.get(tmp);
                }
            }
        }
        
        return ans;
        
    }
}
