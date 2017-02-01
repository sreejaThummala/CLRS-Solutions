def smartAssigning(names, statuses, projects, tasks):
    id = 0
             
    for i in range(len(names)):
        if statuses[i] == False :
            if tasks[i] < tasks[id]:
                id = i
            elif (tasks[i] == tasks[id]):
                if projects[i] < projects[id] :
                    id = i
    return names[id]


