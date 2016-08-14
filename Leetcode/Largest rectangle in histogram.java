public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i =0 ; i<= heights.length; i++){
            int cur = (i == heights.length)? -1: heights[i];
            while(!stack.isEmpty() && cur <= heights[stack.peek()]){
                int h = heights[stack.pop()];
                int left = stack.isEmpty()? 0: stack.peek();
                int right = stack.isEmpty()? i:i-1;
                max = Math.max((right-left)*h,max);
            }
            stack.push(i);
        }
        
        return max;
    }
}
