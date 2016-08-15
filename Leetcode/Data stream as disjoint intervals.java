/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {


    TreeSet<Interval> set;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        set = new TreeSet<>((a,b)->(a.start-b.start));
    }
    
    public void addNum(int val) {
        Interval vInterval = new Interval(val,val);
        Interval floor = set.floor(vInterval);
        Interval ceil = set.ceiling(vInterval);
        
        if(floor!= null && floor.end >= val || 
        ceil != null && ceil.start<=val){
            return; //already a part of interval
        }
        
        if(floor!=null && floor.end == val-1){
            set.remove(floor);
            vInterval.start = floor.start;
        }
        
        if(ceil != null && ceil.start == val+1){
            set.remove(ceil);
            vInterval.end = ceil.end;
        }
        
        set.add(vInterval);
        
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(set);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
