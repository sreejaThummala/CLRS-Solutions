public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int maxSum = (maxChoosableInteger)*(maxChoosableInteger+1)/2;
        if(maxSum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 1; i <= maxChoosableInteger; i++){
            set.add(i);
        }
        
        return _helper(set, maxChoosableInteger, desiredTotal);
    }
    
    private boolean _helper(TreeSet<Integer> set, int maxChoosableInteger, int desiredTotal){
        if(set.ceiling(desiredTotal) != null) return true;
        
        for(int i = 1; i <= maxChoosableInteger; i++){
            if(!set.contains(i)) continue;
            
            set.remove(i);
            if(!_helper(set, maxChoosableInteger, desiredTotal-i)){
                set.add(i);
                return true;
            }
            
            set.add(i);
        }
        
        return false;
    }
}
