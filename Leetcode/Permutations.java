public class Solution {
    public List<List<Integer>> permute(int[] num) {
        
        int level = -1;
        int len = num.length;
        int[] branch = new int[len];
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        boolean[] visited = new boolean[len];
        for(int i=0;i<len;i++){
            visited[i] = false;
        }
        dfs(num,len,level,branch,result,visited);
        return result;
        
    }
    
    void dfs(int[] num,int len,int level, int[] branch, List<List<Integer>> result,boolean[] visited){
         if(level>=len-1){
             List<Integer> adds = new ArrayList<Integer>();
             for(int i=0;i<len;i++){
                 adds.add(branch[i]);
             }
             
             result.add(adds);
             return;
         }
         
         for(int i=0;i<len;i++){
             if(!visited[i]){
                 branch[++level]= num[i];
                 visited[i]=true;
                 dfs(num,len,level,branch,result,visited);
                 visited[i]=false;
                 level--;
             }
         }
    }
}
