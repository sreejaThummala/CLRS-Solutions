public class Solution {
    public int[] findOrder(int n, int[][] p) {
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++){
            graph.add(new HashSet<Integer>());
        }
        
        int[] indegree = new int[n];
        for(int i = 0; i < p.length; i++){
            if(!graph.get(p[i][1]).contains(p[i][0])){
                graph.get(p[i][1]).add(p[i][0]);
                indegree[p[i][0]]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        
        int count = 0;
        int[] res = new int[n];
        while(!queue.isEmpty()){
            
            int v = queue.poll();
            res[count] = v;
            count++;
            for(Integer u: graph.get(v)){
                indegree[u]--;
                if(indegree[u]==0){
                    queue.add(u);
                }
            }
            
        }
        
        if(count == n) return res;
        
        return new int[0];
        
    }
}
