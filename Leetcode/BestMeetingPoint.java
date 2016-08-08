public class solution{

public int minTotalDistance(int[][] grid){
     List<Integer> x = new ArrayList<>();
     List<Integer> y = new ArrayList<>();

     int n = grid.length;
     int m = grid.length;

     for(int i = 0; i< n; i++){
         for(int j = 0; j < m; j++){
          if(grid[i][j] ==1){
               x.add(i);
               y.add(j);
          }}
          return getMP(x)+getMP(y);
     }

     private int getMP(List<Integer> l){
         Collections.sort(l);
          int i = 0;
          int j = l.size()-1;
          int res = 0;
          while(i<j){
               res+= l.get(j--)-l.get(i++);
          }
          return res;
     }
}
}
