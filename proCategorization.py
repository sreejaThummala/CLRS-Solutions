def proCategorization(pros, preferences):
    memo = {}
    for i in range(len(preferences)):
        for j in preferences[i]:
            if j in memo:
                memo[j].append(pros[i])
            else:
                memo[j] = [pros[i]]
    result = []
    for key, value in memo.items():
        result.append([[key],value])
    result.sort()
    return result

