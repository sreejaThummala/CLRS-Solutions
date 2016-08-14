public class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        PriorityQueue<Long> q = new PriorityQueue<>();
        q.add(1l);
        for(int i = 1; i < n; i++){
            
            long tmp = q.poll();
            while(!q.isEmpty() && q.peek()==tmp) tmp = q.poll(); //some numbers which are divisible by 2,3,5 form duplicates
            q.offer(tmp*2);
            q.offer(tmp*3);
            q.offer(tmp*5);
        }
        
        return q.poll().intValue();
    }
}
