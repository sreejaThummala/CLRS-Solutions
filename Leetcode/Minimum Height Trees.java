public List<Integer> findMinHeightTress(int n , int[][] edges){ //this is undirected graph
  List<Integer> leaf = new ArrayList<>(); //unrooted tree
  //maximum of two MHT
  if(n==1) {
  leaf.add(0);
  return leaf;
  }
  
  Map<Integer, List<Integer>> graph = new HashMap<>();
  for(int i = 0; i < n ; i++) graph.put(i, new ArrayList<>());
  
  int[] degree = new int[n];
  for(int[] edge: edges){
    degree[edge[0]]++;
    degree[edge[1]]++;
    graph.get(edge[0]).add(edge[1]);
    graph.get(edge[1]).add(edge[0]);
  }
  
  for(int i = 0; i < n; i++){
    if(degree[i]==1) leaf.add(i);
  }
  
  while(n>2){
    List<Integer> level = new ArrayList<>();
    for(int l: leaf){
      n--;
      for(int nb: graph.get(l)){
        --degree[nb];
        if(degree[nb] ==1) level.add(nb);
      }
      
    }
          leaf = level;

  }    return leaf;


}
