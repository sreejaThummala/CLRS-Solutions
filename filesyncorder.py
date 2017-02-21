import heapq
import math
def fileSyncOrder(files, storageLimit, uploadSpeed, duration):
    queue = []
    event = 0
    i = 0
    result = []
    while event <= duration:
        if queue:
            fileSize, ith = heapq.heappop(queue)
            if storageLimit >= fileSize and duration >= event + math.ceil(fileSize/uploadSpeed):
                result.append(ith)
                storageLimit -= fileSize
                event = min(duration, math.ceil(fileSize/uploadSpeed) + event)
        if event > duration:
            break
        while i < len(files) and files[i][1] <= event:
            heapq.heappush(queue,(files[i][0],i))
            i += 1
        if not queue:
            if i == len(files):
                break
            else:
                event = files[i][1]
                while i < len(files) and files[i][1] <= event:
                    heapq.heappush(queue,(files[i][0],i))
                    i += 1
    return result
            
            
   
