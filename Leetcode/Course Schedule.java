/** Total numbe of n courses you have to take labeled from 0 to n-1
pre-requisites - an edge in graph 1->0 course 1 is to be taken before course 0
Creates a dependency graph
Should check if there are no cycles / create a topological sort
**/

public class Solution{
  public boolean canFinish(int numCourses, int[][] p){
    List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
    for(int i = 0; i < numCourses; i++)
    {
      graph.add(new HashSet<Integer>());
    }
    int[] indegree = new int[numCourses];
    for(int i = 0; i < p.length; i++){
      if(!graph.get(p[i][1]).contains(p[i][0]){
          graph.get(p[i][1]).add(p[i][0]);
          indegree[p[i][0]]++;
      }
    }
    
    for(int i = 0; j = 0; i < numCourses; i++){
      for(j = 0; j < numCourses; j++) if(indegree[j] == 0) break;
      if(j==numCourses) return false; //a cycle 
      indegree[j]--;
      for(Integer p : graph.get(j)) indegree[p]--;
    }
    
    return true;
  }
}
