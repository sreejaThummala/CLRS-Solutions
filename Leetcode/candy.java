public class Solution {
    public int candy(int[] ratings) {
        int cnt = 0;
        int[] children = new int[ratings.length];
        Arrays.fill(children,1);
        for(int i = 1; i < ratings.length; i++)
        {
            if(ratings[i] > ratings[i-1])
            children[i] = children[i-1]+1;
        }
        
        for(int i = ratings.length-2; i >=0; i--)
        {
            if(ratings[i] > ratings[i+1] && children[i] < children[i+1]+1)
            children[i] = children[i+1]+1;
        }
        
        for(int i = 0; i < ratings.length; i++)
            cnt += children[i];
        return cnt;
    }
}
