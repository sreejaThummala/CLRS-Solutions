def ratingThreshold(threshold, ratings):
    n = len(ratings)
    t = [0 for x in range(n)]
    result = []
    for i in range(n):
        for j in ratings[i]:
            t[i] += j
        t[i] = t[i]/float(len(ratings[i]))
        if t[i] < threshold:
            result.append(i)
    return result

