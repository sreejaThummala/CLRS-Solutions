memo = dict()

def feedOptimizer(span, h, events):
    stories = list(filter(lambda x:len(x) == 3, list(events)))
    for i,x in enumerate(stories):
        x.append(i+1)
    reloads = list(filter(lambda x:len(x) == 1, events))

    ans = []
    for r in reloads:
        releventStories = filter(lambda x: r[0] - x[0] >= 0 and r[0] - x[0] <= span , stories)
        dp = dict()
        releventStories.sort()
        key = str(releventStories)
        if not key in memo:
            dp = dict()
            k= knapsack(len(releventStories),h, releventStories,dp)
            memo[key] = [k[1]] + k[0]
        ans.append(memo.get(key))
    
    return ans

def knapsack(i,j,_stories,dp):
    
    if (i,j) in dp:
        return dp[(i,j)]
    #knapsack
    if i == 0 or j == 0:
        dp[(i,j)] = [[],0]
        return dp[(i,j)]
    _notIncluded = knapsack(i-1,j,_stories,dp)
    w = _stories[i-1][2]
    s = _stories[i-1][1]
    
    if w > j:
        print _notIncluded[1]
        dp[(i,j)] = _notIncluded
        return dp[(i,j)]
    
    _afterIncluded = knapsack(i-1,j-w,_stories,dp)  

    _included = [[],0]
    _included[0] = list(_afterIncluded[0])
    _included[0].append(_stories[i-1][3])
    _included[1] = _afterIncluded[1] +s
    if _included[1] > _notIncluded[1]:
        dp[(i,j)] = _included
        return dp[(i,j)]
    
    if _included[1] < _notIncluded[1]:
        dp[(i,j)] = _notIncluded
        return _notIncluded
    
    if len(_included[0]) < len(_notIncluded[0]):
        dp[(i,j)] = _included
        return _included
    
    if len(_included[0]) > len(_notIncluded[0]):
        dp[(i,j)] = _notIncluded
        return _notIncluded
    
    if _included[0] < _notIncluded[1]:
        dp[(i,j)]  = _included
        return _included  
    else:
        dp[(i,j)] = _notIncluded
        return _notIncluded
    
    return [[],0]
    
    
   
