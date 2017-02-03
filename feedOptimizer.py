memo = dict()

def feedOptimizer(span, h, events):
    stories = list(filter(lambda x:len(x) == 3, list(events)))
    for i,x in enumerate(stories):
        x.append(i+1)
    reloads = list(filter(lambda x:len(x) == 1, events))
    
    ans = []
    for r in reloads:
        releventStories = filter(lambda x: r[0] - x[0] >= 0 and r[0] - x[0] <= span , stories)
        releventStories.sort()
        key = str(releventStories)
        if not key in memo:
            memo[key]= knapsack(releventStories,h)
        ans.append(memo.get(key))
    
    return ans

def knapsack(stories,h):
    #knapsack
    dp = [[0]*(h+1) for i in range(0,len(stories)+1)]
    
    for i in range(1,len(stories)+1):
        for j in range(1,h+1):
            w = stories[i-1][2]
            s = stories[i-1][1]
            dp[i][j] = dp[i-1][j]
            if w <=j:
                dp[i][j] = max(dp[i][j],dp[i-1][j-w]+s)
    
    releventStories = findIndices(dp)
    j = h
    for i in range(len(stories),0,-1):
        w = stories[i-1][2]
        s = stories[i-1][1]
        if j >=w:
            if dp[i][j] - dp[i-1][j-w] == s:
                releventStories.append(stories[i-1][3])
                j -= w
    releventStories.sort()        
    ans = []
    ans.append(dp[len(stories)][h])
    ans.extend(releventStories)
    
    return ans

   

