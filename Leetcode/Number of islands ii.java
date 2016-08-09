/**
A 2d grid map of m rows and n columns is initially filled with water. we may perform an addland operation which turns the water at posotion into a land
given a list of position to operate, count the number of islands after each add land operation.

class use case of union-find algorithm
**/

public class Solution{
  private Map<Integer, Integer> parents = new HashMap<>();
  private static final int[][] DIR = {{1,0},{-1,0},{0,1},{0,-1}};
  public List<Integer> numIslands(int n, int m , Point[] operators){
    List<Integer> res = new ArrayList<>();
    if(operators == null || operators.length == 0) return res;
    boolean[][] islands = new boolean[n][m];
    int count = 0;
    for(Point p : operators){
      if(!islands[p.x][p.y]){
        islands[p.x][p.y] = true;
        int id = x*m+y;
        count++; // the point is one island
        parents.put(id,id);
        for(int i = 0; i < 4; i++){
          int _x = p.x+DIRS[i][0];
          int _y = p.y+DIRS[i][1];
          if(_x < 0|| _y <0 || _x >=n ||_y >= m || !islands[_x][_y]) continue;
          int parent = findRoot(id);
          int _parent = findRoot(_x*m+_y);
          if( parent != _parent){ //for each connection, if it is not already connected
          // decrease one island
           --count;
           union(parent,_parent);
            
          }
          
        }
      }
      res.add(count);
    }
    return res;
    
  }
  
  private int findParent(int id){
    if(id != parents.get(id)){
        return findparent(parents.get(id));
    }
    return id;
  }
  
  private void union(int u, int v){
  if(u<v)
    parents.put(u,v);
  else
    parents.put(v,u);
  }
}
