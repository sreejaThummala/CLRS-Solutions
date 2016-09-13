/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        
        if(intervals.size()==0) return result;
        
       Collections.sort(intervals,(x,y)->(x.start-y.start));
       result.add(intervals.get(0));
       Interval j = result.get(0);
     
        for(int n = 1; n < intervals.size(); n++)
        {
            Interval i = intervals.get(n);
            if(i.start > j.end)
            {
                result.add(i);
                j = i;
                continue;
            }
            result.remove(j);
            Interval m = new Interval(Math.min(i.start,j.start) , Math.max(i.end,j.end));
            result.add(m);
            j = m;
        }
        
        return result;
    }
}
