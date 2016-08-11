public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int[][] neighbors = {{0,1},{1,0}};
        List<int[]> res = new ArrayList<int[]>();
        
        if(nums1 == null || nums2 == null) return res;
        int n =  nums1.length;
        int m = nums2.length;
        
        if(n == 0 || m == 0) return res;
        
        boolean[][] visited = new boolean[n][m];
        int minSum = nums1[0]+nums2[0];
        int coord = 0*m + 0;
        int maxCoord = (n+1)*m;
        Queue<Long> queue = new PriorityQueue<Long>();
        queue.offer(Long.valueOf(coord)+Long.valueOf((nums1[0]+nums2[0]-minSum))*maxCoord);
        while(k>0 && !queue.isEmpty()){
            long minHash = queue.poll();
            long coordHash = minHash%maxCoord;
            long _xmin = coordHash/m;
            long _ymin = coordHash%m;
            res.add(new int[]{nums1[(int)_xmin], nums2[(int)_ymin]});
            k--;
            for(int[] neighbor : neighbors){
                long _nx = _xmin+neighbor[0];
                long _ny = _ymin+neighbor[1];
                if(_nx>=n || _ny>=m || visited[(int)_nx][(int)_ny]) continue;
                visited[(int)_nx][(int)_ny] = true;
                long _ncoord = _nx*m + _ny;
                queue.offer(_ncoord+(Long.valueOf(nums1[(int)_nx]+nums2[(int)_ny])-Long.valueOf(minSum))*maxCoord);
            }
            
        }
        
        return res;
    }
}
