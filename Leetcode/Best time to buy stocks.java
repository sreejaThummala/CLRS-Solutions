public class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length == 0) return 0;
        
        int[] profitsUntil = new int[prices.length];
        int[] profitsAfter = new int[prices.length];
        
        
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++)
        {
            minPrice = Math.min(minPrice, prices[i]);
            profitsUntil[i]= Math.max(profitsUntil[i-1], prices[i]-minPrice );
        }
        
        int maxPrice = prices[prices.length-1];
        for(int i = prices.length-2; i>=0; i--)
        {
            maxPrice = Math.max(maxPrice, prices[i]);
            profitsAfter[i] = Math.max(profitsAfter[i+1], maxPrice-prices[i]);
            
        }
        
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++)
        {
            res = Math.max(res, profitsAfter[i]+profitsUntil[i]);
        }
        
        return res;
    }
}
