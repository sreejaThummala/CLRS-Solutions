#Question
Given a tree and a number of queries such that every query takes two nodes of tree as parameters. 
For every query pair, find if two nodes are on same path from root to bottom

##Analysis

1. Need to track something from root to node [DFS]
  1. Need to say one node is part of subtree of another node
  2. In DFS, intime of parent node is less than subtree and outtime is greater than subtree [invariant]

### Algorithm
- Preprocess to calculate intime and outime of all nodes
- query the following for each v and u
```
Intime[v] < Intime[u] and Outime[v] > Outime[u]
Or
Intime[u]< Intime[v] and Outime[u] > Outime[v]

```

```java
int[] outTime;
int[] inTime;
int timer; 

void dfs(ArrayList<Integer>[] graph, int v){
   visited[v]= true;
   ++ timer;
   inTime[v] = timer;
   for(Integer u: graph[v]){
    if(!visited[u]) dfs(graph,u);
   }
   
   ++timer;
   outTime[u] = timer;
}

bool query(int v, int u){
  return ((inTime[u]<inTime[v])&&(outTime[u]>outTime[v]))
  || ((inTime[u]>inTime[v])&&(outTime[u]<outTime[v]));
}
