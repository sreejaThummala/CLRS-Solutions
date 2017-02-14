import heapq

def jobScheduling(requestTime, jobProcess, timeFromStart):
    
    queue = [] 
    event = 0
    i = 0
    j = 2
    while event < timeFromStart:
        if queue:
            work, ith = heapq.heappop(queue)
            event = min(timeFromStart, event + work)
        while  i < len(jobProcess) and requestTime[i] <= event:
            print i 
            heapq.heappush(queue,(jobProcess[i],i))
            i += 1
        if not queue:
            if i == len(jobProcess):
                return []
            else:
                event = requestTime[i]
                if event <= timeFromStart:
                    heapq.heappush(queue,(jobProcess[i],i))        
                i += 1
    queue.sort()
    result = []
    for job, i in queue:
        result.append(i)
    return result
        
        
