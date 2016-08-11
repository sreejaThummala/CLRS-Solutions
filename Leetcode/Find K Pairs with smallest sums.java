//works only when elements are positive
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int[][] neighbors = {{0,1},{1,0}};
        List<int[]> res = new ArrayList<int[]>();
        
        if(nums1 == null || nums2 == null) return res;
        int n =  nums1.length;
        int m = nums2.length;
        
        if(n == 0 || m == 0) return res;
        
        boolean[][] visited = new boolean[n][m];
        int maxSum = nums1[n-1]+nums2[m-1]+1;
        int coord = 0*m + 0;
        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(coord*maxSum+nums1[0]+nums2[0]);
        while(k>0 && !queue.isEmpty()){
            int minHash = queue.poll();
            int coordHash = minHash/maxSum;
            int _xmin = coordHash/m;
            int _ymin = coordHash%m;
            res.add(new int[]{nums1[_xmin], nums2[_ymin]});
            k--;
            for(int[] neighbor : neighbors){
                int _nx = _xmin+neighbor[0];
                int _ny = _ymin+neighbor[1];
                if(_nx>=n || _ny>=m || visited[_nx][_ny]) continue;
                visited[_nx][_ny] = true;
                int _ncoord = _nx*m + _ny;
                queue.offer(_ncoord*maxSum+nums1[_nx]+nums2[_ny]);
            }
            
        }
        
        return res;
    }
}
