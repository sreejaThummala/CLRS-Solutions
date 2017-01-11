public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if(seqs.size() == 0) return false;
        int n = org.length;
        int count = 0;
        Set<Integer>[] graph = new Set[n+1];
        
        for(int i = 1; i <= n; i++){
            graph[i] = new HashSet<>();
        }
        int[] degree = new int[n+1];
        boolean[] have = new boolean[n+1];
        for(List<Integer> seq: seqs){
            for(int i = 0; i < seq.size(); i++){
                if(seq.get(i) > n || seq.get(i) < 0) return false;
                have[seq.get(i)] = true;
                if(i == 0) continue;
                if(graph[seq.get(i)].contains(seq.get(i-1))) continue;
                graph[seq.get(i)].add(seq.get(i-1));
                if(degree[seq.get(i-1)]++ == 0) count++;
            }
        }
        
        if(count != n-1) return false;
        for(int i = n-1; i >=0; --i){
            if(!have[org[i]]) return false;
            if(degree[org[i]]>0) return false;
            for(Integer p: graph[org[i]]){
                if(--degree[p] == 0 && p != org[i-1]) 
                return false;
            }
            
          
        }
          return true;
    }
}
