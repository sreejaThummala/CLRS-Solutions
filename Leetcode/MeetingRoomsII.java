public int minMeetingRooms(Interval[] intervals){
  if(null == intervals || intervals.length == 0){
    return 0;
  }
  
  Arrays.sort(intervals, new Comparator<Interval<(){
    @Override
    public int compare(Interval o1, Interval o2){
      return o1.start - o2.start;
    }
  });
  
  PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
  int minRoom = 1;
  queue.offer(intervals[0].end);
  for (int i = 1; i < intervals.length; i++) {
    if (intervals[i].start < pq.peek()) {
                numRooms++;
                pq.offer(intervals[i].end);
        } else {
                pq.poll();
                pq.offer(intervals[i].end);
          }
        }
  return numRooms;
}}
