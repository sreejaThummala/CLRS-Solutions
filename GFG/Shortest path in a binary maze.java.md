#Question
Given a MXN matrix where each element can either be 0 or 1. We need to find the shortest path between source cell to destination cell.
The path can only be created out of a cell if its value is 1.

#Analysis
BFS algorithm

```java
static final int[] ROW_NUM = {-1,0,0,1};
static final int[] COL_NUM = {0,-1,1,0};

static int ROW;
static int COL;

boolean isValid(int row, int col){
  return (row >=0 )&& (row < ROW) &&
        (col > = 0) && (col < COL);
}

int bfs(int[][] M, Point src, Point dest){

  ROW = M.length;
  COL = M[0].length;
  
  if(M[src.x][src.y] == 0 || M[dest.x][dest.y] == 0) return Integer.MAX_VALUE;
  
  boolean[][] visited = new boolean[ROW][COL];
  visited[src.x][src.y] = true;
  
  PriorityQueue<Point> queue = new PriorityQueue<Point>((a,b)->a.d-b.d); 
  
  queue.offer(new Node(src,0));
  
  while(!queue.isEmpty()){
    Node cur == queue.poll();
    Point pCur = cur.p;
    if(pCur.x == dest.x && pCur.y == dest.y) return cur.d;
    for(int i = 0; i < 4; i++){
      int row = pCur.x + ROW_NUM[i];
      int col = pCur.y + COL_NUM[i];
      
      if(isValid(row,col)&& M[row][col] == 1 && !visited[row][col]) 
        queue.offer(new Node(New Point(row,col), cur.d +1));
      
    }
  }
  
  return Integer.MAX_VALUE;
}

class Node{
  Point p;
  int d;
  
  Node(Point p, int d){
    this.p = p;
    this.d = d;
  }
  
  
};
class Point{
  int x;
  int y;

  Point(int x, int y){
    this.x = x;
    this.y = y;
  }
};
