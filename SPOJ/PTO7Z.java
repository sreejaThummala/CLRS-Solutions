/**
you can solve finding the longest path in unrooted tree in O(N)
can be solved in bfs and dfs version
**/

//root can be random node
public int dfs(List<Integer>[] v, int root){
  int m = 0;
  int m1 = -1; // keep track of two paths from here
  int m2 = -1;
  visited[root] = true;
  
  for(int i = 0; i < v[root].size(); i++){
    if(!visited[v[root].get(i)]){
      m = dfs(v,v[root].get(i);
      if(m >= m1){
        m2 = m1;
        m1 = m;
      }else if(m>m2){
        m2 = m;
      }
    }
      total = Math.max(total, m1+m2+1);
      return m1+1;
    }
}
