public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        List<int[]> heights = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        
        for(int[] b: buildings){
            heights.add(new int[]{b[0],-b[2]});
            heights.add(new int[]{b[1],b[2]});
        }
        
        Collections.sort(heights, (a,b)->(a[0]==b[0])?(a[1]-b[1]):(a[0]-b[0]));
        
        map.put(0,1);
        int prevH = 0;
        for(int[] h: heights){
            
            if(h[1] < 0){
                map.put(-h[1], map.getOrDefault(-h[1],0)+1);
            }else{
                int cnt = map.getOrDefault(h[1],0);
                if(cnt == 1){
                    map.remove(h[1]);
                }else{
                    map.put(h[1],cnt-1);
                }
            }
            int curH = map.lastKey();
            if(prevH != curH){
               result.add(new int[]{h[0],curH});

                prevH = curH;
            }
        }
        return result;
    }
}
