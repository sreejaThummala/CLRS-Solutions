public class Solution {
    public int maxProfit(int[] prices) {
        int L = prices.length;
        
        if(L<2) return 0;
        
        int[] buy = {Integer.MIN_VALUE,Integer.MIN_VALUE};
        int[] sell = {0,0};
        
        //simulation of actual process
        for(int i = 0; i < prices.length; i++)
        {
            sell[1] = Math.max(sell[1], buy[1]+prices[i]);
            buy[1] = Math.max(buy[1],sell[0]-prices[i]);
            sell[0] = Math.max(sell[0], buy[0]+prices[i]);
            buy[0] = Math.max(buy[0], -prices[i]);
        }
        
        return sell[1];
    }
}
