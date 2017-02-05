def serverFarm(jobs, servers):
    idx = dict()
    for i in range(len(jobs)):
        if jobs[i] in idx:
            idx[jobs[i]].append(i)
        else:
            idx[jobs[i]] = [i]
    jobs.sort(reverse = True)
    ans = [[] for i in range(servers)]
    time = [0]*servers
    for i in range(len(jobs)):
        sidx = time.index(min(time))
        time[sidx] += jobs[i]
        ans[sidx].append(idx[jobs[i]][0])
        idx[jobs[i]].pop(0)
    return ans
        
        

    

