import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    private static int chinkyDiamonds(int[] nums, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10,Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++)
        {
            pq.offer(nums[i]);
        }
        
        int ans = 0;
        for(int i = 0; i < k; i++)
        {
            int large = pq.peek();
            pq.poll();
            pq.add(large/2);
            ans += large;
        }
        
        return ans;
    }
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int n = in.nextInt();
		    int k  = in.nextInt();
		    int[] nums = new int[n];
		    for(int i  = 0; i < n; i++){
		        nums[i] = in.nextInt();
		    }
		    System.out.println(chinkyDiamonds(nums,k));
		}
	}
}
