public class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        int cur = 0;
        int prev = 0;
        for(int i = 0; i < n; i++){
            int dx1 = points.get((i+1)%n).get(0) - points.get(i).get(0);
            int dy1 = points.get((i+1)%n).get(1) - points.get(i).get(1);
            int dx2 = points.get((i+2)%n).get(0) - points.get(i).get(0);
            int dy2 = points.get((i+2)%n).get(1) - points.get(i).get(1);
            
            cur = ((dx1 * dy2) - (dx2 * dy1));
            if(cur != 0){
                if(prev*cur < 0) return false;
               
            }
             prev = cur;
            
        }
        
        return true;
        
        
    }
}
