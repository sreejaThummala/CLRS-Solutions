from sets import Set
from collections import defaultdict
def spamClusterization(requests, IDs, threshold):
    list_of_sets = []
    result = []
    if len(requests) <= 1:
        return []
    for x,req in enumerate(requests):
        set_of_words = set([i.strip(",.?!") for i in req.lower().split()])
        list_of_sets.append([IDs[x],set_of_words])

    list_of_sets.sort()
    result = []
    for i in range(len(list_of_sets)):
        A = list_of_sets[i]  
        for x in range(i+1,len(list_of_sets)):
            B = list_of_sets[x]
            jaccard_index = float(len(A[1] & B[1])) / float(len(A[1] | B[1]))
            if jaccard_index >= threshold:
                if len(A[1]) >= 1 and len(B[1]) >= 1:
                    result.append([str(A[0]),str(B[0])])
                
    temp = []
    for l in connected_components(result):
        l = map(int,l)
        l.sort()
        temp.append(l)
    temp.sort()
    return temp
def connected_components(lists):
    neighbors = defaultdict(set)
    seen = set()
    for each in lists:
        for item in each:
            neighbors[item].update(each)
    def component(node, neighbors=neighbors, seen=seen, see=seen.add):
        nodes = set([node])
        next_node = nodes.pop
        while nodes:
            node = next_node()
            see(node)
            nodes |= neighbors[node] - seen
            yield node
    for node in neighbors:
        if node not in seen:
            yield sorted(component(node))

                
    
