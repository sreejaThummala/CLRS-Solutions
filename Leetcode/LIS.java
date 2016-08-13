public class Solution {
    public int lengthOfLIS(int[] ar) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i=0; i<ar.length; i++) {
            Integer ceil = set.ceiling(ar[i]);
            if(ceil == null)     //if ceil not present this simply extends the current sequence
                set.add(ar[i]);
            else{                   //replace ceil with this value
                set.remove(ceil);
                set.add(ar[i]);
            }
        }
        return set.size();
        
    }
}
